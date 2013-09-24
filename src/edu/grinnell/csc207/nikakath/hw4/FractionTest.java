package edu.grinnell.csc207.nikakath.hw4;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FractionTest {

    @Test
    public void testConstructors() {
	//Constructors from integers 
	Fraction a = new Fraction(1, 2);
	assertEquals("intd", BigInteger.valueOf(1), a.numerator());
	assertEquals("intn", BigInteger.valueOf(2), a.denominator());
	Fraction b = new Fraction(5);
	assertEquals("intn", BigInteger.valueOf(5), b.numerator());	
	assertEquals("intn", BigInteger.valueOf(1), b.denominator());
	
	//Constructors from BigInts
	Fraction c = new Fraction(BigInteger.valueOf(5), BigInteger.valueOf(3));
	assertEquals("intd", BigInteger.valueOf(5), c.numerator());
	assertEquals("intn", BigInteger.valueOf(3), c.denominator());
	Fraction d = new Fraction(BigInteger.valueOf(8));
	assertEquals("intn", BigInteger.valueOf(8), d.numerator());	
	assertEquals("intn", BigInteger.valueOf(1), d.denominator());
	
	//Constructor from String
	Fraction e = new Fraction("6/8");
	Fraction f = new Fraction("7");
	//change to 4 when simplify is working
	assertEquals("string", BigInteger.valueOf(8), e.denominator());
	assertEquals("string", BigInteger.valueOf(7), f.numerator());
	assertEquals("string", BigInteger.valueOf(1), f.denominator());
	
	//Constructor from double
	 Fraction threeFourths = new Fraction (.75);
	 //change to 3 when simplify is working
	 assertEquals("double", BigInteger.valueOf(750), threeFourths.numerator());

    } //constructors
    
    @Test
    public void testPublicMethods() {
	
	// Declarations of variables
	Fraction one = new Fraction(2, 2);
	Fraction single = new Fraction(1, 1);
	Fraction negone = new Fraction(-1);
	Fraction half = new Fraction(1, 2);
	Fraction third = new Fraction(1, 3);
	Fraction neghalf = new Fraction(-1, 2);
	
	// numerator()
	assertEquals("num", BigInteger.valueOf(2), one.numerator());
	
	// numerator()
	assertEquals("den", BigInteger.valueOf(2), one.denominator());
	
	// add(Fraction)
	assertEquals("pos + pos", new Fraction(7), single.add(new Fraction(6)));
	assertEquals("pos + neg", new Fraction(-5), single.add(new Fraction(-6)));
	assertEquals("neg + neg", new Fraction(-6), negone.add(new Fraction(-5)));
	assertEquals("frac + 0", single, single.add(new Fraction(0)));
	
	// subtract(Fraction)
	assertEquals("pos - pos", new Fraction(-5), single.subtract(new Fraction(6)));
	assertEquals("pos - neg", new Fraction(7), single.subtract(new Fraction(-6)));
	assertEquals("neg - neg", new Fraction(4), negone.subtract(new Fraction(-5)));
	assertEquals("neg - pos", new Fraction(-7), negone.subtract(new Fraction(6)));
	assertEquals("frac - 0", single, single.subtract(new Fraction(0)));
	
	// multiply(Fraction)
	assertEquals("pos * pos", new Fraction(6, 2), half.multiply(new Fraction(6)));
	assertEquals("pos * neg", new Fraction(-6, 3), third.multiply(new Fraction(-6)));
	assertEquals("neg * neg", new Fraction(8, 2), neghalf.multiply(new Fraction(-8)));
	assertEquals("frac * 1", single, single.multiply(new Fraction(1)));
	assertEquals("frac * 0", new Fraction(0), single.multiply(new Fraction(0)));
	
	// divide(Fraction) NOT FINISHED
	assertEquals("pos / pos", new Fraction(5, 2), half.divide(new Fraction(1, 5)));
	assertEquals("pos / neg", new Fraction(-5, 2), single.divide(new Fraction(1, -5)));
	assertEquals("frac / 1", half, half.divide(new Fraction(1)));
	
    }

}
