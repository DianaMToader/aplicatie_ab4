package aplicatie_ab4;

import java.util.Comparator;

/**
 * 
 * @author Diana-Madalina Toader
 * Comparator folosit pentru ordonarea crescatoare dupa pretul total.
 *
 */
class ComparePrice implements Comparator<Location> {
	
	@Override
	public int compare(Location loc0, Location loc1) {
		// TODO Auto-generated method stub
		return loc1.getPrice() * loc0.getNumberDays() - loc1.getPrice() * loc1.getNumberDays();
	}
}
