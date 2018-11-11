package myMath;

import java.util.ArrayList;
import java.util.Iterator;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Monom m=new Monom(4,2);
Monom z=new Monom(3,5);

double x=m.f(3);
//System.out.println(x);
Monom y=m.multyply(z);
//System.out.println(y.get_power());

ArrayList<Monom> l=new ArrayList<>();
l.add(m);
l.add(z);
Iterator <Monom> it=l.iterator();
while(it.hasNext()) {
	it.next();
	System.out.println('a');
}

	}

}
