 package edu.grinnell.csc207.nikakath.hw4;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testConstructors() throws Exception{
		// Constructors from integers
		Fraction a = new Fraction(1, 2);
		assertEquals("intd", BigInteger.valueOf(1), a.numerator());
		assertEquals("intn", BigInteger.valueOf(2), a.denominator());
		Fraction b = new Fraction(5);
		assertEquals("intn", BigInteger.valueOf(5), b.numerator());
		assertEquals("intn", BigInteger.valueOf(1), b.denominator());

		// Constructors from BigInts
		Fraction c = new Fraction(BigInteger.valueOf(5), BigInteger.valueOf(3));
		assertEquals("intd", BigInteger.valueOf(5), c.numerator());
		assertEquals("intn", BigInteger.valueOf(3), c.denominator());
		Fraction d = new Fraction(BigInteger.valueOf(8));
		assertEquals("intn", BigInteger.valueOf(8), d.numerator());
		assertEquals("intn", BigInteger.valueOf(1), d.denominator());

		// Constructor from String
		Fraction e = new Fraction("6/8");
		Fraction f = new Fraction("7");
		Fraction g = new Fraction ("11/12");
		assertEquals("string", BigInteger.valueOf(4), e.denominator());
		assertEquals("string", BigInteger.valueOf(7), f.numerator());
		assertEquals("string", BigInteger.valueOf(1), f.denominator());
		assertEquals("string", BigInteger.valueOf(11), g.numerator());
		assertEquals("string", BigInteger.valueOf(12), g.denominator());

		// Constructor from double
		Fraction threeFourths = new Fraction(.75);
		Fraction negthreeFourths = new Fraction(-.75);
		assertEquals("double", BigInteger.valueOf(3), threeFourths.numerator());
		assertEquals("double", BigInteger.valueOf(4),
				threeFourths.denominator());
		assertEquals("double", BigInteger.valueOf(-3), negthreeFourths.numerator());
		assertEquals("double", BigInteger.valueOf(4),
				negthreeFourths.denominator());

	} // constructors

	@Test
	public void testPublicMethods() throws Exception{

		// Declarations of variables
		Fraction one = new Fraction(2, 2);
		Fraction single = new Fraction(1, 1);
		Fraction negone = new Fraction(-1);
		Fraction half = new Fraction(1, 2);
		Fraction third = new Fraction(1, 3);
		Fraction neghalf = new Fraction(-1, 2);
		Fraction threefourths = new Fraction(.75);
		Fraction zero = new Fraction(0, 2);

		// numerator()
		assertEquals("num", BigInteger.valueOf(1), one.numerator());

		// denominator()
		assertEquals("den", BigInteger.valueOf(1), one.denominator());

		// add(Fraction)
		assertEquals("pos + pos", new Fraction(7), single.add(new Fraction(6)));
		assertEquals("pos + neg", new Fraction(-5),
				single.add(new Fraction(-6)));
		assertEquals("neg + neg", new Fraction(-6),
				negone.add(new Fraction(-5)));
		assertEquals("frac + 0", single, single.add(new Fraction(0)));

		// subtract(Fraction)
		assertEquals("pos - pos", new Fraction(-5),
				single.subtract(new Fraction(6)));
		assertEquals("pos - neg", new Fraction(7),
				single.subtract(new Fraction(-6)));
		assertEquals("neg - neg", new Fraction(4),
				negone.subtract(new Fraction(-5)));
		assertEquals("neg - pos", new Fraction(-7),
				negone.subtract(new Fraction(6)));
		assertEquals("frac - 0", single, single.subtract(new Fraction(0)));

		// multiply(Fraction)
		assertEquals("pos * pos", new Fraction(6, 2),
				half.multiply(new Fraction(6)));
		assertEquals("pos * neg", new Fraction(-6, 3),
				third.multiply(new Fraction(-6)));
		assertEquals("neg * neg", new Fraction(8, 2),
				neghalf.multiply(new Fraction(-8)));
		assertEquals("frac * 1", single, single.multiply(new Fraction(1)));
		assertEquals("frac * 0", new Fraction(0),
				single.multiply(new Fraction(0)));

		// divide(Fraction) 
		assertEquals("pos / pos", new Fraction(5, 2),
				half.divide(new Fraction(1, 5)));
		assertEquals("pos / neg", new Fraction(-5, 1),
				single.divide(new Fraction(1, -5)));
		assertEquals("frac / 1", half, half.divide(new Fraction(1)));
		try {
		    third.divide(new Fraction(0));
		    fail("Division by 0; should have thrown Exception");
		}
		catch (ArithmeticException e) {
		    assertEquals("Caught division-by-0 exception", "Division by 0", e.getMessage());
		}
		assertEquals("neg / pos", new Fraction(-5, 2),
			neghalf.divide(new Fraction(1, 5)));
		assertEquals("neg / neg", new Fraction(5, 2),
			neghalf.divide(new Fraction(-1, 5)));
		
		// pow(int)
		assertEquals("pos ^ pos", new Fraction(1, 4), half.pow(2));
		assertEquals("pos ^ 0", new Fraction(1), half.pow(0));
		assertEquals("pos ^ 1", half, half.pow(1));
		assertEquals("pos ^ neg", new Fraction(4), half.pow(-2));
		assertEquals("neg ^ pos", new Fraction(-1, 8), neghalf.pow(3));
		assertEquals("neg ^ neg", new Fraction(-8), neghalf.pow(-3));
		
		//reciprocal
		assertEquals(new Fraction(4, 3), threefourths.reciprocal());
		assertEquals(single, one.reciprocal());
		try {
		    zero.reciprocal();
		    fail("Denominator is zero; should have thrown Exception");
		}
		catch (Exception e) {
		    assertEquals("denominator is set to zero", "denominator must not be zero", e.getMessage());
		}
		
		//doubleValue
	//	Double oneHalf = .5;
	//	assertEquals(".75", Double.valueOf(.75), half.doubleValue());
	} //public methods
	
		@Test
		public void testPrivateMethods() throws Exception{

		// simplify()
		assertEquals("2/2", BigInteger.ONE, new Fraction(2, 2).numerator());
		assertEquals("2/2", BigInteger.ONE, new Fraction(2, 2).denominator());
		assertEquals("10/-5", BigInteger.valueOf(-2),
				new Fraction(10, -5).numerator());
		assertEquals("10/-5", BigInteger.ONE,
				new Fraction(10, -5).denominator());
		assertEquals("-5/5", BigInteger.valueOf(-1),
				new Fraction(-5, 5).numerator());
		assertEquals("-5/5", BigInteger.ONE, new Fraction(-5, 5).denominator());
		assertEquals("-5/-10", BigInteger.valueOf(2),
				new Fraction(-5, -10).denominator());
		assertEquals("-5/-10", BigInteger.ONE,
				new Fraction(-5, -10).numerator());

	} //private methods

}
