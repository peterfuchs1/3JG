package bruch;



/**
 * Write a description of class Bruch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bruch implements Comparable<Bruch>
{
    // instance variables - replace the example below with your own
    private int zaehler;
    private int nenner;

    /**
     * Constructor for objects of class Bruch
     */
    public Bruch()
    {
        // initialise instance variables
        this(0,1);
    }
    public Bruch(int zaehler)
    {
        // initialise instance variables
        this(zaehler,1);
    }
    public Bruch(int zaehler, int nenner)
    {
        // initialise instance variables
        this.zaehler=zaehler;
        this.nenner=nenner;
        this.normalize();
    }
    
    public void setZaehler(int zaehler) {
        this.zaehler=zaehler;
        this.normalize();
    }
    public void setNenner(int nenner) {
        this.nenner=nenner;
        this.normalize();
    }
    public int getZaehler() {
        return zaehler;
    }
    public int getNenner() {
        return nenner;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double quotient()
    {
        // put your code here
        return (double) zaehler/nenner;
    }
    public String toString() {
        return ""+this.zaehler+"/"+this.nenner;
    }

    public Bruch add(Bruch b){
    	int n=this.nenner*b.nenner;
    	int z=this.zaehler*b.nenner+b.zaehler*this.nenner;
    	this.zaehler=z;
    	this.nenner=n;
    	this.normalize();
    	return this;
    }
	public Bruch add(int i) {
		return this.add(new Bruch(i));
	}
	public Bruch sub(int i) {
		return this.sub(new Bruch(i));
	}
	public Bruch multi(int i) {
		return this.multi(new Bruch(i));
	}
	public Bruch div(int i) {
		return this.div(new Bruch(i));
	}
    public Bruch sub(Bruch b) {
    	this.add(new Bruch(-b.zaehler,b.nenner));
    	return this;
    }
    public Bruch multi(Bruch b) {
    	this.nenner*=b.nenner;
    	this.zaehler*=b.zaehler;
    	this.normalize();
    	return this;
    }
    public Bruch div(Bruch b){
    	if(b.zaehler!=0)
    		this.multi(new Bruch(b.nenner,b.zaehler));
    	else
    		throw new ArithmeticException("Divide by Zero!");
    	return this;
    }
    public static Bruch add(Bruch b1,Bruch b2){
    	Bruch b= new Bruch(b1.zaehler*b2.nenner+b2.zaehler*b1.nenner,b1.nenner*b2.nenner);
    	b.normalize();
    	return b;
    }
    public static Bruch sub(Bruch b1, Bruch b2) {
    	return Bruch.add(b1, new Bruch(-b2.zaehler,b2.nenner));
    }
    public static  Bruch multi(Bruch b1,Bruch b2){
    	Bruch b= new Bruch(b1.zaehler*b2.zaehler,b1.nenner*b2.nenner );
    	b.normalize();
    	return b;
    }
    @Override
    public boolean equals(Object o) {
    	if(o==null) return false;
    	if(this==o) return true;
    	if(this.getClass()==o.getClass()) {
    		Bruch b = (Bruch)o;
    		return (this.zaehler== b.zaehler && this.nenner==b.nenner);
    	}
   
    	return false;
    }
	private void normalize() {
		int y = Bruch.ggt(zaehler, nenner);
		this.zaehler /= y;
		this.nenner /= y;
		this.checkNenner();
		if(this.nenner<0) {
			this.zaehler *= -1;
			this.nenner *= -1;
		}
	}
	private static int ggt(int a, int b) {
		while(b!=0) {
			int y=a%b;
			a=b;
			b=y;
		}
		return a;
	}
	private void checkNenner() {
		if(this.nenner==0)
			throw new ArithmeticException("Divide by Zero!");
	}
	@Override
	public int compareTo(Bruch o) {
		double v=this.quotient()-o.quotient();
		if(v<0.0)
			return -1;
		else if (v>0.0)
			return 1;
		else
			return 0;
	}
	
}