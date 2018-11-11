package myMath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	
	ArrayList<Monom> monomList;

	public Polynom(String poly) {
		ArrayList<Monom> monomList=new ArrayList<Monom>();
		String s="";
		int i=0;
		int j=0;
			while(poly.charAt(i)!='*') {
			s=s+poly.charAt(i);
			i++;
		}
			monomList.get(j).set_coefficient(Double.parseDouble(s));
			s="";
			
			
			
			
		
		
	
		

		
		
		
		
		
		
	}
	public Polynom() {
		 monomList=new ArrayList<>();
	}
	@Override
	public double f(double x) {
		double y=0;
		for (int i = 0; i < monomList.size(); i++) {
			y=y+monomList.get(i).f(x);
			
		}
		return y;
	}

	@Override
	public void add(Polynom_able p1) {
		p1.iteretor()
		
		
	}

	@Override
	public void add(Monom m1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void substract(Polynom_able p1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void multiply(Polynom_able p1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean equals(Polynom_able p1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double root(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Polynom_able copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynom_able derivative() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double area(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Monom> iteretor() {
		return monomList.iterator();
	}

	// ********** add your code below ***********
	
}
