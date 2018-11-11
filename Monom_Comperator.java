package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	@Override
	public int compare(Monom m1, Monom m2) {
		
		return m1.get_power()-m2.get_power();
	}

	
}
