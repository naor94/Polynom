
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	private double _coefficient; // 
	private int _power;
	
	
	
	
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	// ***************** add your code below **********************


	//****************** Private Methods and Data *****************
	
	public double get_coefficient() {
		// TODO Auto-generated method stub
		return this._coefficient;
	}
	public int get_power() {
		// TODO Auto-generated method stub
		return this._power;
	}
	public void set_coefficient(double a){
		this._coefficient = a;
	}
	public void set_power(int p) {
		this._power = p;
	}
	
	
	@Override
	public double f(double x) {
		
		return (this._coefficient*Math.pow(x, this._power));
	} 
	
	public Monom derivative() {
		Monom m=new Monom(this._power*this._coefficient,this._power-1);
		return m;
	}
	public void add(Monom s) {
		if(s.get_power()==this._power) {
			set_coefficient(s.get_coefficient()+this._coefficient);
			
		}
	}
		public Monom multyply(Monom s) {
			return new Monom(s.get_coefficient()*this._coefficient,s.get_power()+this._power);
	}
	
}
