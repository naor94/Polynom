package myMath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import javax.management.modelmbean.ModelMBeanNotificationBroadcaster;
/**
 * This class represents a Polynom with add, multiply functionality and other functions.
 

 *@author Naor eliav and michael garusi 
 */
public class Polynom implements Polynom_able{

	ArrayList<Monom> monomList;
	
	/**
	 * constructor that get a string represent polynom and init monomList
	 * @param poly
	 */
	public Polynom(String poly) {
		boolean f=true;
//		for (int i = 0; i < poly.length()-1; i++) {
//			if((poly.charAt(i)=='*'||poly.charAt(i)=='+'||poly.charAt(i)=='-'
//					||poly.charAt(i)=='^')&&(poly.charAt(i+1)=='*'
//					||poly.charAt(i+1)=='+'
//					||poly.charAt(i+1)=='-'
//					||poly.charAt(i+1)=='^')) {
//				System.out.println("the polynom is not good");
//				
//				f=false;
//			}
//			if(!f)
//				break;
//		}
		if(f) {
		monomList=new ArrayList<>();
		double conf=0;
		int pow=0;
		String s="";
		boolean flag=false;
		for(int i=0;i<poly.length();i++) {
			if(poly.charAt(i)=='-')
				flag=true;
		    if(poly.charAt(i)!='*'&&
		    		poly.charAt(i)!='x'&&
		    		poly.charAt(i)!='^'&&
		    		poly.charAt(i)!='+'&&
		    		poly.charAt(i)!='-') {
		    	s=s+poly.charAt(i);
		    }
		     if(poly.charAt(i)=='*') {
		    	conf=Double.parseDouble(s);
		  
		    	if(flag)
		    		conf*=-1;
		    	flag=false;
		    	s="";
		    }
		     if((poly.charAt(i)=='+'||poly.charAt(i)=='-'||poly.length()==i+1)&&conf!=0) {
		    	if(poly.charAt(i)=='-')
		    		flag=true;
		    	pow=Integer.parseInt(s);
		    	if(conf!=0)
		    	{
		    		monomList.add(new Monom(conf,pow));
		    	
		    	}
		   
		    	s="";
		    	
		    }
		    
		}
		Collections.sort(monomList, new Monom_Comperator());

	}
	
	}
	/*
	 * default costructor
	 */
	 public Polynom() {
		 monomList=new ArrayList<>();	
	}
	 /**
	  * copy constructor
	  * @param p
	  */
    public Polynom(Polynom p) {
    	monomList=new ArrayList<>();	
    	for(int i=0;i<p.monomList.size();i++) {
    		Monom e=new Monom(p.monomList.get(i));
    		this.monomList.add(e);
    	}
   	}
    
	@Override
	/**
	 *  This function return string that display the Polynom.
	 *  @return a String such that it can be used for init an equal(s) Polynom
	 */
	public String toString() {
		if(monomList.isEmpty())
			return "";
		String s="";
		for(int i=0;i<monomList.size();i++) {
			if(monomList.get(i).get_coefficient()<0) {
				s=s+monomList.get(i).get_coefficient() +"*"+"x"+ "^"+ monomList.get(i).get_power();
			}
			else
				s=s+"+"+monomList.get(i).get_coefficient() +"*"+"x"+ "^"+ monomList.get(i).get_power();
				
		}
		if(s.charAt(0)=='+')
			return s.substring(1,s.length());
		return s;
	}



	@Override
	/**
	 *  @param x
	 *  This function gets a number x and calculate
	 *  @return the value of the polynom at x.
	 */
	public double f(double x) {
		double sum=0;
		for(int i=0;i<monomList.size();i++) {
			sum=sum+monomList.get(i).f(x);
		}
		return sum;
	}

	@Override
	/**
	 *  @param p1
	 * This function adds new Polynom to the current polynom
	 * 
	 */
	public void add(Polynom_able p1) {
		Iterator<Monom> iter=p1.iteretor();
		while(iter.hasNext()) {
			Monom m=iter.next();
			add(m);
		}
	}

	@Override
	/**
	 *  @param monom m1
	 *This function adds new Monom to the current polynom  if power if eqaul else add to end of monomList
	 */
	public void add(Monom m1) {
	for(int i=0;i<monomList.size();i++) {
		if(monomList.get(i).get_power()==m1.get_power()) {
			monomList.get(i).add(m1);
			if(monomList.get(i).get_coefficient()==0)
				monomList.remove(monomList.get(i));
			return;
		}
	}
	monomList.add(m1);
	Collections.sort(monomList,new Monom_Comperator());
	
	}

	@Override
	/**
	 *  @param p1
	 * This function subs new Polynom from current polynom
	 * 
	 */
	public void substract(Polynom_able p1) {
		Iterator<Monom> iter=p1.iteretor();
		while(iter.hasNext()) {
			Monom m=iter.next();
			add(new Monom(m.get_coefficient()*-1,m.get_power()));
		}
		
	}

	@Override
	/**
	 *  @param p1
	 * This The function calculates the product of two polynomials
	 */
	public void multiply(Polynom_able p1) {
		Iterator<Monom> iter=p1.iteretor();
		ArrayList<Monom> ans=new ArrayList<>();
		while(iter.hasNext()) {
			Monom m=iter.next();
			for(int i=0;i<monomList.size();i++) {
				Monom e=monomList.get(i).mul(m);
				ans.add(e);
		}
		}

		monomList=ans;
		Collections.sort(monomList, new Monom_Comperator());
	}
	

	@Override
	/**
	 *  @param p1
	 * the function check if p1 equal to current polynom
	 * @return true if equal,else return false
	 */
	public boolean equals(Polynom_able p1) {
		Iterator<Monom> iter=p1.iteretor();
		int k=0;
		while(iter.hasNext()) {
			Monom m=iter.next();
			if(m.equals(monomList.get(k)))
				k++;
			else
				return false;
		}
		if(k!=monomList.size())
			return false;
		return true;
	}

	@Override
	/**
	 * @return true if monomlist is empty else return false 
	 */
	public boolean isZero() {
		return monomList.isEmpty();
	}


	@Override
	/**
	 *  @param x0,x1,eps.
	 * This function is used to find root of an equation in a given interval that is value of ‘x’ for which f(x) = 0 .
	 * it uses Bisection Method.
	 * The method is based on The Intermediate Value Theorem which states that if f(x) is a continuous function and there are two real numbers x0 and x1 such 
	 * that f(x0)*f(x1) 0 and f(b) < 0), then it is guaranteed that it has at least one root between them.
	 */
	public double root(double x0, double x1, double eps) {
	
	double middle=x0;
	while(x1-x0>=eps) {
		middle=(x0+x1)/2;
		if(f(middle)==0)
			break;
			else if (f(middle)*f(x0) < 0) 
	            x1=middle; 
	        else
	            x0=middle; 
	    } 
	
	return middle;
	}

	@Override
	/**
	 * @return copy of current polynom
	 */
	public Polynom_able copy() {
		
    	return new Polynom(this);
	}

	@Override
	/**
	 * This function calculates the derivative of the polynomial.
     *@return polynom represent the derivative
	 */
	public Polynom_able derivative() {
		Polynom p=new Polynom();		for(int i=0;i<monomList.size();i++) {
			Monom e=monomList.get(i).derivative();
			if(e.get_coefficient()!=0)
				p.monomList.add(e);
		}
		return p;
	}

	@Override
	/**
	 * Compute a Riman's integral from x0 to x1 in eps steps. 
	 * @param x0 starting pooint
	 * @param x1 end point
	 * @param eps positive step value
	 * @return the approximated area above X-axis below this function bounded in the range of [x0,x1]
	 */
	public double area(double x0, double x1, double eps) {
		double x=0;
		for (double i = x0; i < x1; i=i+eps) {
			double z=f(i);
			if(z>0) {
			x=x+(z*eps);
			}
		}
		return x;
	}
	/**
	 * Compute a Riman's integral from x0 to x1 in eps steps. 
	 * @param x0 starting pooint
	 * @param x1 end point
	 * @param eps positive step value
	 * @return the approximated area below X-axis below this function bounded in the range of [x0,x1]
	 */
	public double areaUnderXAxis(double x0, double x1, double eps) {
		double x=0;
		for (double i = x0; i < x1; i=i+eps) {
			double z=f(i);
			if(z<0) {
			x=x+(z*eps);
			}
		}
		return x*-1;
	}

	@Override
	public Iterator<Monom> iteretor() {
		return monomList.iterator();
	}
	
}
