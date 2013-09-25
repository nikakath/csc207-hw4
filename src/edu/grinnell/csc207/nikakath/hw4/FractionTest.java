package edu.grinnell.csc207.nikakath.hw4;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;

public class FractionTest {

	@Test
	public void testConstructors() throws Exception {
		// Constructors from integers
		Fraction a0 = new Fraction(1, 2);
		assertEquals("1/2 ints", BigInteger.ONE, a0.numerator());
		assertEquals("1/2 ints", BigInteger.valueOf(2), a0.denominator());
		Fraction a1 = new Fraction(0, -3);
		assertEquals("0 ints", BigInteger.ZERO, a1.numerator());
		assertEquals("0 ints", BigInteger.ONE, a1.denominator());
		try {
			Fraction a2 = new Fraction(-3, 0);
			fail("Division by 0; should have thrown Exception");
		} catch (Exception e) {
			assertEquals("Caught division-by-0 exception",
					"denominator must not be zero", e.getMessage());
		}
		Fraction a3 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
		assertEquals("MAX/MIN ints", BigInteger.valueOf(Integer.MAX_VALUE)
				.negate(), a3.numerator());
		assertEquals("MAX/MIN ints", BigInteger.valueOf(Integer.MIN_VALUE)
				.negate(), a3.denominator());

		Fraction b0 = new Fraction(5);
		assertEquals("pos int", BigInteger.valueOf(5), b0.numerator());
		assertEquals("pos int", BigInteger.ONE, b0.denominator());
		Fraction b1 = new Fraction(Integer.MAX_VALUE);
		assertEquals("MAX int", BigInteger.valueOf(Integer.MAX_VALUE),
				b1.numerator());
		assertEquals("MAX int", BigInteger.ONE, b1.denominator());
		Fraction b2 = new Fraction(Integer.MIN_VALUE);
		assertEquals("MIN int", BigInteger.valueOf(Integer.MIN_VALUE),
				b2.numerator());
		assertEquals("MIN int", BigInteger.ONE, b2.denominator());
		Fraction b3 = new Fraction(0);
		assertEquals("0 int", BigInteger.ZERO, b3.numerator());
		assertEquals("0 int", BigInteger.ONE, b3.denominator());
		Fraction b4 = new Fraction(-5);
		assertEquals("neg int", BigInteger.valueOf(-5), b4.numerator());
		assertEquals("neg int", BigInteger.ONE, b4.denominator());

		// Constructors from BigInts
		Fraction c0 = new Fraction(BigInteger.ONE, BigInteger.valueOf(2));
		assertEquals("1/2 bigints", BigInteger.ONE, c0.numerator());
		assertEquals("1/2 bigints", BigInteger.valueOf(2), c0.denominator());
		Fraction c1 = new Fraction(BigInteger.ZERO, BigInteger.valueOf(-3));
		assertEquals("0 bigints", BigInteger.ZERO, c1.numerator());
		assertEquals("0 bigints", BigInteger.ONE, c1.denominator());
		try {
			Fraction c2 = new Fraction(BigInteger.valueOf(-3), BigInteger.ZERO);
			fail("Division by 0; should have thrown Exception");
		} catch (Exception e) {
			assertEquals("Caught division-by-0 exception",
					"denominator must not be zero", e.getMessage());
		}
		Fraction c3 = new Fraction(BigInteger.valueOf(Integer.MAX_VALUE),
				BigInteger.valueOf(Integer.MIN_VALUE));
		assertEquals("MAX/MIN bigints", BigInteger.valueOf(Integer.MAX_VALUE)
				.negate(), c3.numerator());
		assertEquals("MAX/MIN bigints", BigInteger.valueOf(Integer.MIN_VALUE)
				.negate(), c3.denominator());

		Fraction d0 = new Fraction(BigInteger.valueOf(5));
		assertEquals("pos bigint", BigInteger.valueOf(5), d0.numerator());
		assertEquals("pos bigint", BigInteger.ONE, d0.denominator());
		Fraction d1 = new Fraction(BigInteger.valueOf(Integer.MAX_VALUE));
		assertEquals("MAX bigint", BigInteger.valueOf(Integer.MAX_VALUE),
				d1.numerator());
		assertEquals("MAX bigint", BigInteger.ONE, d1.denominator());
		Fraction d2 = new Fraction(BigInteger.valueOf(Integer.MIN_VALUE));
		assertEquals("MIN bigint", BigInteger.valueOf(Integer.MIN_VALUE),
				d2.numerator());
		assertEquals("MIN bigint", BigInteger.ONE, d2.denominator());
		Fraction d3 = new Fraction(BigInteger.ZERO);
		assertEquals("0 bigint", BigInteger.ZERO, d3.numerator());
		assertEquals("0 bigint", BigInteger.ONE, d3.denominator());
		Fraction d4 = new Fraction(BigInteger.valueOf(-5));
		assertEquals("neg bigint", BigInteger.valueOf(-5), d4.numerator());
		assertEquals("neg bigint", BigInteger.ONE, d4.denominator());

		// Constructor from String
		Fraction e = new Fraction("6/8");
		Fraction f = new Fraction("-7");
		Fraction g = new Fraction("11/-12");
		assertEquals("pos string", BigInteger.valueOf(3), e.numerator());
		assertEquals("pos string", BigInteger.valueOf(4), e.denominator());
		assertEquals("neg int string", BigInteger.valueOf(-7), f.numerator());
		assertEquals("neg int string", BigInteger.valueOf(1), f.denominator());
		assertEquals("neg string", BigInteger.valueOf(-11), g.numerator());
		assertEquals("neg string", BigInteger.valueOf(12), g.denominator());

		// Constructor from double
		Fraction h0 = new Fraction(.75);
		assertEquals("pos double", BigInteger.valueOf(3), h0.numerator());
		assertEquals("pos double", BigInteger.valueOf(4), h0.denominator());
		Fraction h1 = new Fraction(-.75);
		assertEquals("neg double", BigInteger.valueOf(-3), h1.numerator());
		assertEquals("neg double", BigInteger.valueOf(4), h1.denominator());
		Fraction h2 = new Fraction(-0.0);
		assertEquals("neg 0 double", BigInteger.valueOf(0), h2.numerator());
		assertEquals("neg 0 double", BigInteger.valueOf(1), h2.denominator());
	} // constructors

	@Test
	public void testPublicMethods() throws Exception {

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
		} catch (ArithmeticException e) {
			assertEquals("Caught division-by-0 exception", "Division by 0",
					e.getMessage());
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

		// reciprocal
		assertEquals(new Fraction(4, 3), threefourths.reciprocal());
		assertEquals(single, one.reciprocal());
		try {
			zero.reciprocal();
			fail("Denominator is zero; should have thrown Exception");
		} catch (Exception e) {
			assertEquals("denominator is set to zero",
					"denominator must not be zero", e.getMessage());
		}

		// doubleValue
		// Double oneHalf = .5;
		// assertEquals(".75", Double.valueOf(.75), half.doubleValue());
		// public methods

		// negate
		assertEquals("negate 1", new Fraction(-1), one.negate());
		assertEquals("negate -1", new Fraction(1), negone.negate());
		assertEquals("negate -1/2", new Fraction(1, 2), neghalf.negate());

	} // public methods

	@Test
	public void testPrivateMethods() throws Exception {

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

	} // private methods

}
