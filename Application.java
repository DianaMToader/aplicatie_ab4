package aplicatie_ab4;

import java.io.*;
import java.util.*;

class Application {
	static List<Location> loc = new ArrayList<Location>();
	private static BufferedReader br;
	
	/**
	 * @param inputFile
	 * @throws IOException
	 * Functie care citeste din fisier.
	 * Fisierul contine locatii de forma:
	 * Nume locatie, Oras-Judet-Tara, pret mediu pe zi, activitate1 activitate2 
	 * ... activitateN, zi/luna/an, zi/luna/an 
	 */
	void readInput(String inputFile) throws IOException {
		File file = new File(inputFile);
		br = new BufferedReader(new FileReader(file));
		 
		String st;
		while ((st = br.readLine()) != null) {
			String []argloc = st.split(", ");
			String []city1 = argloc[1].split("-");
			String []activ = argloc[3].split(" ");
			String []s = argloc[4].split("/");
			String []p = argloc[5].split("/");
			List<String> activities = new ArrayList<String>();
			
			for(int i = 0; i < activ.length; i++)
				activities.add(activ[i]);
			City city = new City(city1[0], new County(city1[1],new Country(city1[2])));
			@SuppressWarnings("deprecation")
			Date checkIn = new Date(Integer.parseInt(s[2]),Integer.parseInt(s[1]), 
					 Integer.parseInt(s[0]));
			@SuppressWarnings("deprecation")
			Date checkOut = new Date(Integer.parseInt(p[2]),Integer.parseInt(p[1]), 
					 Integer.parseInt(p[0]));
			loc.add(new Location(argloc[0], city, Integer.parseInt(argloc[2]), 
					activities, checkIn, checkOut));
		}	 
	}
	
	/*
	 * Afiseaza toate informatiile despre locatia dorita.
	 */
	void information(Scanner scan) {
		System.out.println("Introduceti locatia:");
		String raspuns = scan.next();
		for(int i = 0; i < loc.size(); i++) {
			Location location = loc.get(i);
			if(location.getLocation().equals(raspuns)) {
				System.out.println("Locatia se afla in orasul " + 
						location.getCity().getName() + ", judet " + 
						location.getCity().getCounty().getName()+ ", tara " + 
						location.getCity().getCounty().getCountry().getName());
				System.out.println("Pret mediu pe zi: " + location.getPrice());
				System.out.println("Se pot desfasura urmatoarele activitati:" + location.getActivities());
				System.out.println("In perioada: " + location.getDayCheckIn() + 
						"." + location.getMonthCheckIn() + "." + 
						location.getYearCheckIn() + " - " + location.getDayCheckOut() + 
						"." + location.getMonthCheckOut() + "." + 
						location.getYearCheckOut());
				break;
			}
		}
	}
	
	/*
	 * Verifica daca datele de sosire si de plecare introduse de la tastatura 
	 * se potrivesc cu cele ale locatiei selectate.
	 * Functia este folosita in topFive.
	 */
	boolean check(Location location, String[] checkIn, String[] checkOut){
		return location.getDayCheckIn()== Integer.parseInt(checkIn[0]) &&
				location.getMonthCheckIn()==Integer.parseInt(checkIn[1]) &&
				location.getYearCheckIn()==Integer.parseInt(checkIn[2]) &&
				location.getDayCheckOut()==Integer.parseInt(checkOut[0]) &&
				location.getMonthCheckOut()==Integer.parseInt(checkOut[1]) &&
				location.getYearCheckOut()==Integer.parseInt(checkOut[2]);
	}
	
	/*
	 * Afiseaza cele 5 locatii din tara/judetul/orasul introdus de la tastatura
	 * pentru datele de sosire si de plecare inroduse de la tastatura.
	 * Datele trebuie introduse in format: dd/mm/yyyy.
	 * Am folosit un Priority Queue de locatii care foloseste comparatorul
	 * ComparePrice pentru a tine locatiile ordonate crescator dupa pretul total 
	 * al locatiei.
	 * La final scot din Priority Queue primele 5 locatii sau in cazul in care
	 * coada contine mai putine elemente, le scot si le afisez pe acestea.
	 */
	void topFive(Scanner scan) {
		System.out.println("Introduceti tara/judetul/orasul:");
		String raspuns = scan.next();
		System.out.println("Introduceti perioada:");
		System.out.print("Sosire: ");
		String[] sosire = scan.next().split("/");
		System.out.print("Plecare: ");
		String[] plecare = scan.next().split("/");
		
		Queue<Location> pq = new PriorityQueue<Location>(new ComparePrice());
		
		for(int i=0;i<loc.size();i++){
			Location location = loc.get(i);
			if(location.getCity().getName().equals(raspuns) &&
					check(location, sosire, plecare))
				pq.add(location);
			else 
				if(location.getCity().getCounty().getName().equals(raspuns) &&
						check(location, sosire, plecare))
					pq.add(location);
				else
					if(location.getCity().getCounty().getCountry().getName().equals(raspuns)&&
							check(location, sosire, plecare))
						pq.add(location);
		}
		
		int ok = 5;
		System.out.println("Top 5 localitati pentru perioada aleasa, ordonate dupa cost:");
		while(ok != 0 && pq.size() != 0) {
			Location l1 = pq.poll();
			System.out.println(l1.getLocation() + " - pret: "+ l1.getPrice());
			ok--;
		}
	}
	
	/*
	 * Pastrez intr-un Priority Queue toate locatiile in care se poate desfasura
	 * activitatea introdusa de la tastatura si unde se poate sta 10 zile. Coada
	 * este sortata crescator dupa pret.
	 * Se afiseaza prima locatie din coada.
	 */
	void cheapest(Scanner scan){
		System.out.println("Introduceti activitatea:");
		Queue<Location> locactiv = new PriorityQueue<Location>(new CompareLocation());
		String raspuns = scan.next();
		for(int i = 0; i < loc.size(); i++) {
			List<String> activ = loc.get(i).getActivities();
			for(int j = 0; j < activ.size(); j++) {
				if(activ.get(j).equals(raspuns) && loc.get(i).getNumberDays() == 10)
						locactiv.add(loc.get(i));
			}
		}
		System.out.println("Cel mai ieftin loc este: " + locactiv.peek().getLocation());
	}

}
