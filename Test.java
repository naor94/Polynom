package myMath;


import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		
		testCtor();
		testCopyCtorAndToString();
		testF();
		testAdd();
		testSub();
		testMul();
		testEqual();
		testRoot();
		testArea();
		testDerivative();
		testIsZero();
		testMonomCtor();
		testMonomCopyCtor();
		testAddMonom();
		teseSubMonom();
     	testMulMonom();
		testDerivativeMonom();
		testEqualMonom();
		testFMonom();
		
	}
	
	private static void testFMonom() {
		Monom m1=new Monom(9,2);
		System.out.println("the result need to be 9 --> "+m1.f(1));
		System.out.println("the result need to be 36 --> "+m1.f(2));
	}

	private static void testEqualMonom() {
		Monom m1=new Monom(9,2);
		Monom m2=new Monom(4,2);
		Monom m3=new Monom(3,2);
		Monom m4=new Monom(3,2);
		System.out.println("the result need to be false --> "+m1.equals(m2));
		System.out.println("the result need to be true --> "+m3.equals(m4));
	}

	private static void testDerivativeMonom() {
		Monom m1=new Monom(4,2);
		Monom m2=m1.derivative();
		System.out.println("the result need to be 8.0*x^1 --> "+m2);
	}

	private static void testMulMonom() {
		Monom m1=new Monom(3,2);
		Monom m2=new Monom(4,2);
		Monom m3=m1.mul(m2);
		System.out.println("the result need to be 12.0*x^4 --> "+m3);
	}

	private static void teseSubMonom() {
		Monom m1=new Monom(1,2);
		Monom m2=new Monom(1,2);
		m1.sub(m2);
		System.out.println("the result need to be 0.0*x^2 --> "+m1);
	}

	private static void testAddMonom() {
		Monom m1=new Monom(1,2);
		Monom m2=new Monom(1,2);
		m1.add(m2);
		System.out.println("the result need to be 2.0*x^2 --> "+m1);
	}

	private static void testMonomCopyCtor() {
		Monom m1=new Monom(1,2);
		Monom m2=new Monom(m1);
		System.out.println("the result need to be 1.0*x^2 --> "+m2);
	}

	private static void testMonomCtor() {
	Monom m1=new Monom(1,2);
	System.out.println("the result need to be 1.0*x^2 --> "+m1);

		
	}

	public static void testCtor() {
		String s1="-1*x^3-1*x^2-2*x^0";
		Polynom p1=new Polynom(s1);
		String s2=p1.toString();
		Polynom p2=new Polynom(s2);
		System.out.println("the result need to be -1.0*x^3-1.0*x^2-2.0*x^0 -->" +p1);
		System.out.println("the result need to be -1.0*x^3-1.0*x^2-2.0*x^0 -->" +p2);
	}
	public static void testCopyCtorAndToString() {
		
		Polynom p1=new Polynom("-1*x^3-1*x^2-2*x^0");
		String s2=p1.toString();
		Polynom p2=new Polynom(s2);
		System.out.println("the result need to be -1.0*x^3-1.0*x^2-2.0*x^0 -->" +p2);
	}
	
	public static void testF() {
		Polynom p1=new Polynom("-1*x^3-1*x^2-2*x^0");
		double sum=p1.f(1);
		System.out.println("the sum need to be -4 -->"+sum);
		Polynom p2=new Polynom("-1*x^3-1*x^2-2*x^0");
		double sum2=p2.f(2);
		System.out.println("the sum need to be -14 -->"+sum2);
	}
	
	public static void testAdd() {
		Polynom p1=new Polynom("-1*x^3-1*x^2-2*x^0");
		Polynom p2=new Polynom("-1*x^3-1*x^2-2*x^0");
		p1.add(p2);
		System.out.println("the result need to be -2.0*x^3-2.0*x^2-4.0*x^0----> "+p1);
		Polynom p3=new Polynom("1*x^3+1*x^2+2*x^0");
		Polynom p4=new Polynom("-1*x^3-1*x^2-2*x^0");
		p4.add(p3);
		System.out.println("the result need to be empty becouse is zero --> "+ p4);
	}
	
	public static void testSub() {
		Polynom p1=new Polynom("-1*x^3-1*x^2-2*x^0");
		Polynom p2=new Polynom("-1*x^3-1*x^2-2*x^0");
		p1.substract(p2);
		System.out.println("the result need to be empty becouse is zero ---> "+p1);
		Polynom p3=new Polynom("1*x^3+1*x^2+2*x^0");
		Polynom p4=new Polynom("-1*x^3-1*x^2-2*x^0");
		p4.substract(p3);
		System.out.println("the result need to be -2.0*x^3-2.0*x^2-4.0*x^0 --> "+ p4);
	}
	public static void testMul() {
		Polynom p1=new Polynom("3*x^3+5*x^2");
		Polynom p2=new Polynom("3*x^5");
		p1.multiply(p2);
		System.out.println("the result need to be 9.0*x^8+15.0*x^7 -->" +p1);
		Polynom p4=new Polynom("3*x^3+5*x^2");
		Polynom p3=new Polynom("3*x^5-5*x^2");
		p4.multiply(p3);
		System.out.println("the result need to be 9.0*x^8+15.0*x^7-15.0*x^5-25.0*x^4--> " + 
				p4);
}
	
	public static void testEqual() {
		Polynom p1=new Polynom("3*x^3+5*x^2");
		Polynom p2=new Polynom("3*x^5");
		System.out.println("the result need to be false-->" +p1.equals(p2));
		Polynom p3=new Polynom("5*x^2+3*x^3");
		System.out.println("the result need to be true-->" +p1.equals(p3));
	}
	
	public static void testDerivative() {
		String s1="1*x^3-1*x^2+2*x^0";
		Polynom p1=new Polynom(s1);
		Polynom_able p2=p1.derivative();
		System.out.println("the result need to be 3.0*x^2-2.0*x^1 --> " +p2);
	}

public static void testRoot() {
	String s1="1*x^3-1*x^2+2*x^0";
	Polynom p1=new Polynom(s1);
	System.out.println("the result need to be close to -1.0025--> "+p1.root(-200, 300, 0.01));
	Polynom p2=new Polynom("1*x^3+1*x^2+2*x^0");
	System.out.println("the result need to be close to -1.689--> "+p2.root(-200, 300, 0.01));
	Polynom p3=new Polynom("2*x^0-3*x^2+1*x^3");
	System.out.println("the result need to be close to -0.73 --> " + p3.root(-100, 1.5,0.01));
}

public static void testArea() {
	Polynom p1=new Polynom("2*x^0-3*x^2+1*x^3");
	System.out.println("the result need to be close to 1.25--> "+p1.area(0, 1,0.001));
	Polynom p2=new Polynom("2*x^0");
	System.out.println("the result need to be close to 2--> "+p2.area(1, 2,0.001));
}

public static void testIsZero() {
	Polynom p1=new Polynom("2*x^0-3*x^2+1*x^3");
	System.out.println("the result need to be false --> " +p1.isZero());
	Polynom p2=new Polynom("0*x^0+0*x^9");
	System.out.println("the result need to be true --> " +p2.isZero());
	//System.out.println(p2.monomList.toString());
	Polynom p3=new Polynom();
	System.out.println("the result need to be true --> " +p3.isZero());
}

}


