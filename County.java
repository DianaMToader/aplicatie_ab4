package aplicatie_ab4;

/**
 * @author Diana-Madalina Toader
 * Clasa County care descrie un judet, care are drept caracteristici un 
 * nume si o tara.
 * Contine constructorul si 2 functii get pentru cei doi parametrii.
 */
class County {
	String name;
	Country country;
	
	County(String name, Country country){
		this.name = name;
		this.country = country;
	}
	
	String getCounty(){
		return this.name;
	}
	
	Country getCountry(){
		return country;
	}
}
