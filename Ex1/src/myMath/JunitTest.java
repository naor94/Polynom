package myMath;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTest {

	@Test
	void testAdd1() {
		Polynom p1=new Polynom("-1*x^3-1*x^2-2*x^0");
		Polynom p2=new Polynom("-1*x^3-1*x^2-2*x^0");
		p1.add(p2);
		String result=p1.toString();
		assertEquals("-2.0*x^3-2.0*x^2-4.0*x^0",result);
	}
	@Test
	void testAdd2() {
		Polynom p3=new Polynom("1*x^3+1*x^2+2*x^0");
		Polynom p4=new Polynom("-1*x^3-1*x^2-2*x^0");
		p4.add(p3);
		assertEquals("",p4.toString());
	}
	@Test
	void testSub1() {
		Polynom p1=new Polynom("-1*x^3-1*x^2-2*x^0");
		Polynom p2=new Polynom("-1*x^3-1*x^2-2*x^0");
		p1.substract(p2);
		assertEquals("",p1.toString());

}
	@Test
	void testSub2() {
		Polynom p3=new Polynom("1*x^3+1*x^2+2*x^0");
		Polynom p4=new Polynom("-1*x^3-1*x^2-2*x^0");
		p4.substract(p3);
		assertEquals("-2.0*x^3-2.0*x^2-4.0*x^0",p4.toString());
	}
	@Test
	void testMul1() {
		Polynom p1=new Polynom("3*x^3+5*x^2");
		Polynom p2=new Polynom("3*x^5");
		p1.multiply(p2);
		assertEquals("9.0*x^8+15.0*x^7",p1.toString());

		
	}
	@Test
	void testMul2() {
		Polynom p4=new Polynom("3*x^3+5*x^2");
		Polynom p3=new Polynom("3*x^5-5*x^2");
		p4.multiply(p3);
		assertEquals("9.0*x^8+15.0*x^7-15.0*x^5-25.0*x^4",p4.toString());
		
	}
	@Test
	void testEqual1() {
		Polynom p1=new Polynom("3*x^3+5*x^2");
		Polynom p2=new Polynom("3*x^5");
		assertFalse(p1.equals(p2));
		
		
	}
	@Test
	void testEqual2() {
		Polynom p1=new Polynom("3*x^3+5*x^2");
		Polynom p3=new Polynom("5*x^2+3*x^3");
		assertTrue(p1.equals(p3));
		
		
	}
	@Test
	 void testDerivative() {
		String s1="1*x^3-1*x^2+2*x^0";
		Polynom p1=new Polynom(s1);
		Polynom_able p2=p1.derivative();
		assertEquals("3.0*x^2-2.0*x^1",p2.toString());

		
	}

	@Test
	void testRoot() {
		String s1="1*x^3-1*x^2+2*x^0";
		Polynom p1=new Polynom(s1);
		double x=-1.0025;
		double result=p1.root(-200, 300, 0.01);
		assertEquals(x,result,0.0001);

	}
	@Test
	void testRoot1() {
		Polynom p2=new Polynom("1*x^3+1*x^2+2*x^0");
		double x=-1.689;
		double result=p2.root(-200, 300, 0.01);
		assertEquals(x,result,0.001);
		
	}

	@Test
	void testRoot2(){
		Polynom p3=new Polynom("2*x^0-3*x^2+1*x^3");
		double x=-0.73;
		double result=p3.root(-100, 1.5,0.01);
		assertEquals(x,result,0.01);
		
	}
	@Test
	 void testArea() {
		Polynom p1=new Polynom("2*x^0-3*x^2+1*x^3");
		double x=1.25;
		double result=p1.area(0, 1,0.001);
		assertEquals(x,result,0.01);
		
		
	}
	@Test
	 void testArea1() {
		Polynom p2=new Polynom("2*x^0");
		double x=2;
		double result=p2.area(1, 2,0.001);
		assertEquals(x,result,0.01);
		
		
	}
	@Test
	 void testAre2() {
		Polynom p2=new Polynom("2*x^0");
		double x=0.0;
		double result=p2.areaUnderXAxis(1, 2,0.001);
		assertEquals(x,result,0.01);
		
		
	}
	@Test
	 void  testIsZero() {
		Polynom p1=new Polynom("2*x^0-3*x^2+1*x^3");
		assertFalse(p1.isZero());
		
		
	}
	@Test
	 void  testIsZero1() {
		Polynom p2=new Polynom("0*x^0+0*x^9");
		assertTrue(p2.isZero());
		
		
	}
	@Test
	 void  testIsZero2() {
		Polynom p3=new Polynom();
		assertTrue(p3.isZero());
		
		
	}
	@Test
	 void testF() {
		Polynom p1=new Polynom("-1*x^3-1*x^2-2*x^0");
		double result=p1.f(1);
		double x= -4;
		assertEquals(x,result,0.00001);
	
	
}
	@Test
	 void testF1() {
		Polynom p2=new Polynom("-1*x^3-1*x^2-2*x^0");
		double result=p2.f(2);
		double x= -14;
		assertEquals(x,result,0.00001);
	
	
}
	@Test
	 void testCopyCtorAndToString() {
		Polynom p1=new Polynom("-1*x^3-1*x^2-2*x^0");
		String s2=p1.toString();
		Polynom p2=new Polynom(s2);
		assertEquals("-1.0*x^3-1.0*x^2-2.0*x^0",p2.toString());
	}
	@Test
	 void testCtor() {
		String s1="-1*x^3-1*x^2-2*x^0";
		Polynom p1=new Polynom(s1);
		String s2=p1.toString();
		Polynom p2=new Polynom(s2);
		assertEquals("-1.0*x^3-1.0*x^2-2.0*x^0",p1.toString());
		assertEquals("-1.0*x^3-1.0*x^2-2.0*x^0",p2.toString());


		
	}
	@Test
	 void testCtor1() {
		String s1="-1*x^3-1*x^2-2*x^0";
		Polynom p1=new Polynom(s1);
		String s2=p1.toString();
		Polynom p2=new Polynom(s2);
		assertEquals("-1.0*x^3-1.0*x^2-2.0*x^0",p2.toString());


		
	}
	@Test
	 void testMonomCtor() {
		Monom m1=new Monom(1,2);
		assertEquals("1.0*x^2",m1.toString());
	}
	@Test
	 void testMonomCopyCtor(){
		Monom m1=new Monom(1,2);
		Monom m2=new Monom(m1);
		assertEquals("1.0*x^2",m2.toString());
	}
	@Test
	 void testAddMonom(){
		Monom m1=new Monom(1,2);
		Monom m2=new Monom(1,2);
		m1.add(m2);
		assertEquals("2.0*x^2",m1.toString());
	}
	@Test
	 void testSubMonom(){
		Monom m1=new Monom(1,2);
		Monom m2=new Monom(1,2);
		m1.sub(m2);
		assertEquals("0.0*x^2",m1.toString());
	}
	@Test
	 void testMulMonom(){
		Monom m1=new Monom(3,2);
		Monom m2=new Monom(4,2);
		Monom m3=m1.mul(m2);
		assertEquals("12.0*x^4",m3.toString());
	}
	@Test
	 void testDerivativeMonom(){
		Monom m1=new Monom(4,2);
		Monom m2=m1.derivative();
		assertEquals("8.0*x^1",m2.toString());
	}
	@Test
	 void testEqualMonom(){
		Monom m1=new Monom(9,2);
		Monom m2=new Monom(4,2);
		boolean x=m2.equals(m1);
		assertFalse(x);
	}
	@Test
	 void testEqualMonom1(){
		Monom m1=new Monom(3,2);
		Monom m2=new Monom(3,2);
		boolean x=m2.equals(m1);
		assertTrue(x);
	}
	@Test
	 void testFMonom(){
		Monom m1=new Monom(9,2);
		double x=m1.f(1);
		assertEquals(9,x,0.000001);
	}
	@Test
	 void testFMonom1(){
		Monom m1=new Monom(9,2);
		double x=m1.f(2);
		assertEquals(36,x,0.000001);
	}
	
	
	
	
	
	
	
	
	
}
