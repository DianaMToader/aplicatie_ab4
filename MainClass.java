package aplicatie_ab4;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException {
		String raspuns;
		int ok = 0;
		Scanner scan = new Scanner(System.in);
		Application app = new Application();
		
		// citirea din fisier
		app.readInput(args[0]);
		
		// interactiune cu utilizatorul
		System.out.println("Doriti sa aflati:");
		System.out.println("A. Toate informatiile despre o anumita locatie");
		System.out.println("B. Top 5 locatii pe o anumita perioada");
		System.out.println("C. Unde este cel mai ieftin sa practic 10 zile o activitate");
		System.out.println("Raspunsul dumneavoastra(A/B/C)");
		raspuns = scan.next();//citeste raspuns!!!!!
		
		/*
		 *  Cat timp raspunsul la intrebarea "Doriti si alte informatii? (DA/NU)"
		 *  este DA
		 */
		while(raspuns.equals("NU") != true) {
			// daca nu e prima data cand intra in while
			if (ok == 1) {
				System.out.println("Raspunsul dumneavoastra(A/B/C)");
				raspuns = scan.next();
			}
			ok = 1;
			
			switch(raspuns) {
			case "A":
				//toate	informatiile despre	locatia	cu numele X
				app.information(scan);
				
				System.out.println("Doriti si alte informatii? (DA/NU)");
				raspuns = scan.next();
				break;
				
			case "B":
				/*
				 *  top 5 locatii din tara/judetul/orasul X in care pot merge in
				 *  perioada A-B ordonate dupa costul total	pentru a merge toata
				 *  perioada A-B acolo	
				 */
				app.topFive(scan);
	
				System.out.println("Doriti si alte informatii? (DA/NU)");
				raspuns = scan.next();
				break;
				
			case "C":
				// cel mai ieftin sa practic 10	zile o activitate
				app.cheapest(scan);
				
				System.out.println("Doriti si alte informatii? (DA/NU)");
				raspuns = scan.next();
				break;
				
			default:
				System.out.println("Optiunea nu este valida. Va rugam selectati una dintre variantele A, B sau C");
			}
		}
	}

}
