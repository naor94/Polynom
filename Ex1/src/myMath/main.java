package myMath;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynom p=new Polynom("1*x^3+2*x^2+5*x^0");
		double x=p.area(-2,2, 0.001);
		double y=p.areaUnderXAxis(-2,2, 0.001);
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(x+y)
		Polynom_able p1=p.derivative();
		System.out.println(p1.toString());
		double z=p1.root(-10,10, 0.001);
		System.out.println(z);
		System.out.println(p.f(z));

		

	}

}
