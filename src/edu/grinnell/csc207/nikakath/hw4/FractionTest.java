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
	//change to 4 when simplify is working
	assertEquals("string", BigInteger.valueOf(8), e.denominator());
	
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
	Fraction single2 = new Fraction(1);
	
	// numerator()
	assertEquals("num", BigInteger.valueOf(2), one.numerator());
	
	// numerator()
	assertEquals("den", BigInteger.valueOf(2), one.denominator());
	
	// add(Fraction)
	assertEquals("pos", one, single.add(single2));
	
    }

}
