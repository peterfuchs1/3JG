package bruch;




/**
 * Implementation of fraction
 * 
 * @author Walter Rafeiner-Magor 
 * @version 2010-01-01
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
    /**
     *  Constructor with int value
     * @param numerator as an int
     */
    public Bruch(int numerator)
    {
        // initialise instance variables
        this(numerator,1);
    }
    /**
     * Constructor with int values for numerator and denominator 
     * @param numerator as an int
     * @param denominator as an int
     */
    public Bruch(int numerator, int denominator)
    {
        // initialise instance variables
        this.zaehler=numerator;
        this.nenner=denominator;
        this.checkNenner();
    }
    /**
     * set numerator
     * @param numerator as an int
     */
    public void setZaehler(int numerator) {
        this.zaehler=numerator;
    }
    /**
     * set denominator
     * @param denominator as an int
     */
    public void setNenner(int denominator) {
        this.nenner=denominator;
        this.checkNenner();
    }
    /**
     * get numerator 
     * @return the numerator
     */
    public int getZaehler() {
        return zaehler;
    }
    /**
     * get denominator
     * @return the denominator
     */
    public int getNenner() {
        return nenner;
    }
    /**
     * get the double value of the fraction
     * @return  value of the fraction
     */
    public double quotient()
    {
        // put your code here
        return (double) zaehler/nenner;
    }
    /**
     * get a string 
     */
    public String toString() {
        return ""+this.zaehler+"/"+this.nenner;
    }
    /** 
     * add another fraction
     * @param fraction to use
     * @return sum of the two fractions as a new fraction
     */
    public Bruch add(Bruch fraction){
    	int n=this.nenner*fraction.nenner;
    	int z=this.zaehler*fraction.nenner+fraction.zaehler*this.nenner;
    	return new Bruch(z,n).normalize();
    }
    /**
     * add an int value to the fraction
     * @param i int value
     * @return new fraction
     */
	public Bruch add(int i) {
		return this.add(new Bruch(i));
	}
	/** 
	 * subtract an int value from the fraction
	 * @param i int value
	 * @return new fraction
	 */
	public Bruch sub(int i) {
		return this.sub(new Bruch(i));
	}
	/** 
	 * multiply the fraction with an int value 
	 * @param i int value
	 * @return new fraction
	 */
	public Bruch multi(int i) {
		return this.multi(new Bruch(i));
	}
	/** 
	 * divide the fraction by an int value
	 * @param i int value
	 * @return new fraction
	 */
	public Bruch div(int i) {
		return this.div(new Bruch(i));
	}
	/**
	 * subtract another fraction
	 * @param fraction to use
	 * @return subtraction as a new fraction
	 */
    public Bruch sub(Bruch fraction) {
    	return this.add(new Bruch(-fraction.zaehler,fraction.nenner));
    }
    /**
     * multiply another fraction
     * @param fraction to use
     * @return multiplication as a new fraction
     */
    public Bruch multi(Bruch fraction) {
    	int nenner= this.nenner*fraction.nenner;
    	int zaehler=this.zaehler*fraction.zaehler;
    	return new Bruch(zaehler,nenner).normalize();
    }
    /**
     * divide another fraction
     * @param fraction to use
     * @return division as a new fraction
     */
    public Bruch div(Bruch fraction){
    	if(fraction.zaehler!=0)
    		return this.multi(new Bruch(fraction.nenner,fraction.zaehler));
    	else
    		throw new ArithmeticException("Divide by Zero!");
    }
    /**
     * add to fractions
     * @param fraction1 to use
     * @param fraction2 to use
     * @return sum as a new fraction
     */
    public static Bruch add(Bruch fraction1,Bruch fraction2){
    	Bruch b= new Bruch(fraction1.zaehler*fraction2.nenner+fraction2.zaehler*fraction1.nenner,fraction1.nenner*fraction2.nenner);
    	b.normalize();
    	return b;
    }
    /**
     * subtract fraction2 from fraction1
     * @param fraction1 to use
     * @param fraction2 to use
     * @return subtractions as a new fraction
     */
    public static Bruch sub(Bruch fraction1, Bruch fraction2) {
    	return Bruch.add(fraction1, new Bruch(-fraction2.zaehler,fraction2.nenner));
    }
    /**
     * multiply two fractions
     * @param fraction1 to use
     * @param fraction2 to use
     * @return multiplication as a new fraction
     */
    public static  Bruch multi(Bruch fraction1,Bruch fraction2){
    	return new Bruch(fraction1.zaehler*fraction2.zaehler,fraction1.nenner*fraction2.nenner ).normalize();
    }
    /**
     * @see Object#equals(Object)
     */
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
    /**
     * shorten the fraction
     * @return a new fraction
     */
	private Bruch normalize() {
		int y = Bruch.ggt(zaehler, nenner);
		this.zaehler /= y;
		this.nenner /= y;
		this.checkNenner();
		if(this.nenner<0) {
			this.zaehler *= -1;
			this.nenner *= -1;
		}
		return new Bruch(this.zaehler,this.nenner);
	}
	/**
	 * greatest common denominator
	 * @param numberator to use
	 * @param denominator to use
	 * @return the gcd
	 */
	private static int ggt(int numberator, int denominator) {
		while(denominator!=0) {
			int y=numberator%denominator;
			numberator=denominator;
			denominator=y;
		}
		return numberator;
	}
	/**
	 * check the denominator (denominator!=0)
	 * throws an ArithmeticException 
	 */
	private void checkNenner() {
		if(this.nenner==0)
			throw new ArithmeticException("Divide by Zero!");
	}
	/**
	 * @see Comparable#compareTo(Object)
	 */
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
	public static void main(String[] args) {
		int j=6;
		Bruch[] b=new Bruch[j];
		b[--j]=new Bruch(1);
		b[--j]=new Bruch(1,2);		
		b[--j]=new Bruch(3,1);
		b[--j]=new Bruch(64,32);
		b[--j]=new Bruch(128,128);
		b[--j]=new Bruch(1);
		for(;j<b.length;j++) {
			System.out.println("Mein Bruch: "+b[j]);
			System.out.println("Wir addieren 2 dazu: "+b[j].add(2));
			System.out.println("Wir subtrahieren 2: "+b[j].sub(2));
			System.out.println("Wir multiplizieren mit 2: "+b[j].multi(2));
			System.out.println("Wir dividieren durch 2: "+b[j].div(2));
			System.out.println("Wir addieren den Bruch(3,4) dazu: "+b[j].add(new Bruch(3,4)));
		}
	}
}