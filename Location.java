package aplicatie_ab4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Diana-Madalina Toader
 * Clasa Location ce descrie o locatie caracterizata prin:
 *     - nume
 *     - oras
 *     - pret mediu pe zi
 *     - activitati ce se pot desfasura
 *     - data de sosire si de plecare(obiecte de tip Date)
 * Clasa contine un constructor si gettere pentru fiecare parametru.
 */
class Location {
	String name;
	City city;
	int mediumPrice;
	List<String> activities = new ArrayList<String>();
	Date checkIn, checkOut;
	
	Location(String name, City city, int mediumPrice, List<String> activities,
			Date checkIn, Date checkOut) {
		this.name = name;
		this.city = city;
		this.mediumPrice = mediumPrice;
		this.activities = activities;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	String getLocation() {
		return this.name;
	}
	
	City getCity() {
		return this.city;
	}
	
	int getPrice() {
		return this.mediumPrice;
	}
	
	List<String> getActivities() {
		return this.activities;
	}
	
	@SuppressWarnings("deprecation")
	int getYearCheckIn() {
		return this.checkIn.getYear();
	}
	
	@SuppressWarnings("deprecation")
	int getMonthCheckIn() {
		return this.checkIn.getMonth();
	}
	
	@SuppressWarnings("deprecation")
	int getDayCheckIn() {
		return this.checkIn.getDate();
	}
	
	@SuppressWarnings("deprecation")
	int getYearCheckOut() {
		return this.checkOut.getYear();
	}
	
	@SuppressWarnings("deprecation")
	int getMonthCheckOut() {
		return this.checkOut.getMonth();
	}
	
	@SuppressWarnings("deprecation")
	int getDayCheckOut() {
		return this.checkOut.getDate();
	}
	
	/*
	 * Metoda ce returneaza perioada care se poate petrece in locatie.
	 */
	@SuppressWarnings("deprecation")
	int getNumberDays() {
		return this.checkOut.getDate() - this.checkIn.getDate() + 1;
	}
}
