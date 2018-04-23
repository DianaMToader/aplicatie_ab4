package aplicatie_ab4;

/**
 * @author Diana-Madalina Toader
 * Clasa Country care descrie o tara, avand drept caracteristici numele.
 * Contine constructorul si o functie get.
 */
class Country {
	String name;
	
	Country(String name) {
		this.name = name;
	}
	
	String getCountry() {
		return name;
	}
}
