package myMath;


/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 *
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Naor eliav
 *
 */
public class Monom implements function{
	
	private double _coefficient; // the coefficient of monom 
	private int _power; //the power of monom
	
	/**
	 * This constructor get a and b and init coefficient and power 
	 * @param a
	 * @param b
	 * 
	 */
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	/**
	 * copy constructor
	 * @param monom 0t
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	// ***************** add your code below **********************

	public int get_power() {
		
		return _power;
	}
	public double get_coefficient() {
		
		return _coefficient;
	}
	public void set_coefficient(double a){
		this._coefficient = a;
	}
	public void set_power(int p) {
		this._power = p;
	}
	
	
	@Override
	/**
	 * This function gets a number x and calculate the value of the monom at x.
	 * @param x.
	 */
	public double f(double x) {
		return this._coefficient*(Math.pow(x, this._power));
	} 
	/**
	 * This function gets new monom m and adds it to current monom if their powers are equals.
	 * @param monom m
	 */
	public void add(Monom m) {
		if(m.get_power()==this._power)
		set_coefficient(m.get_coefficient()+this._coefficient);
	}
	
	/**
	 * This function gets new monom m and subtract it from current monom if their powers are equals.
	 * @param monom m
	 */
	public void sub(Monom m) {
		if(m._power==this._power) {
			set_coefficient(this._coefficient-m.get_coefficient());
	}
	}
	/**
	 * This function gets an object type of monom and multiplies it by another monom
	 * @param monom m
	 * @return a product of two monoms.
	 */
	public Monom mul(Monom m) {
		return new Monom (this._coefficient*m.get_coefficient(),this._power+m.get_power());
	}
	/**
	 * This function gets a monom object and compare it to another monom object.
	 *  
	 * @param monom m
	 * @return return true if the monoms are equals and false if they are not.
	 */
	public boolean equals(Monom m) {
		return m.get_coefficient()==this._coefficient&&m.get_power()==this._power;
	}
	@Override
	/**
	 * This function prints the display of the monom.
	 * @return streung represent monom.
	 */
	public String toString() {
		return  _coefficient +"*"+"x"+ "^"+ _power;

	}
	/**
	 * This function calculates the derivative of the monom.
	 * @return new monom which represent the derivative.
	 */
	public Monom derivative() {
		if(this._power>=1) {
			return new Monom(this._power*this._coefficient,this._power-1);
		}
		return new Monom(0,0);
}
	
}
