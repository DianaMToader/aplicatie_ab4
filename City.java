package aplicatie_ab4;

/**
 * @author Diana-Madalina Toader
 * Clasa City ce este caracterizata de un nume si un judet.
 * Contine constructorul si 2 functii get pentru cei doi parametrii.
 */
class City {
	String name;
	County county;
	
	City(String name, County county) {
		this.name = name;
		this.county = county;
	}
	
	String getCity() {
		return this.name;
	}
	
	County getCounty() {
		return county;
	}
}
