 package edu.grinnell.csc207.nikakath.hw4;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testConstructors() {
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
		assertEquals("string", BigInteger.valueOf(4), e.denominator());
		assertEquals("string", BigInteger.valueOf(7), f.numerator());
		assertEquals("string", BigInteger.valueOf(1), f.denominator());

		// Constructor from double
		Fraction threeFourths = new Fraction(.75);
		assertEquals("double", BigInteger.valueOf(3), threeFourths.numerator());
		assertEquals("double", BigInteger.valueOf(4),
				threeFourths.denominator());

	} // constructors

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

		// divide(Fraction) NOT FINISHED
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
		
	} //public methods
	
		@Test
		public void testPrivateMethods() {

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
