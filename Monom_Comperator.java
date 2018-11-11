package myMath;


import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	@Override
	/**
	 * @param m1
	 * @param m2
	 * @return negtive if m1 smaller then m1,positive if m1 bigger then m2 else return 0
	 * 
	 */
	public int compare(Monom m1, Monom m2) {
		int result = m2.get_power() - m1.get_power();
		return result;

	}

}
