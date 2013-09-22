package edu.grinnell.csc207.nikakath.hw4;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Fraction {
	private BigInteger numerator;
	private BigInteger denominator;

	public Fraction(int num, int den) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.valueOf(den);
		this.simplify();
	} // Fraction(int, int)

	public Fraction(int num) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.ONE;
		this.simplify();
	} // Fraction(int)

	public Fraction(BigInteger num, BigInteger den) {
		this.numerator = num;
		this.denominator = den;
		this.simplify();
	} // Fraction(BigInteger,BigInteger)

	public Fraction(BigInteger num) {
		this.numerator = num;
		this.denominator = BigInteger.ONE;
		this.simplify();
	} // Fraction(BigInteger)

	public Fraction(long num, long den) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.valueOf(den);
		this.simplify();
	} // Fraction(long, long)

	public Fraction(long num) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.ONE;
		this.simplify();
	} // Fraction(long)

	public Fraction(double num) {
		int j = 0;
		String doub = Double.toString(num);
		boolean afterDot = false;

		for (int i = 0; i < doub.length(); i++) {
			if (doub.charAt(i) == '.') {
				afterDot = true;
			}

			if (afterDot) {
				j++;
			}
		}

		this.numerator = BigInteger.valueOf((long) (num * Math.pow(10, j)));
		this.denominator = BigInteger.valueOf((long) (Math.pow(10, j)));
		this.simplify();
	} // Fraction(double)

	public Fraction(String fraction) {
		int j = 0;
		boolean afterSlash = false;

		for (int i = 0; i < fraction.length(); i++) {
			if (fraction.charAt(i) == '/') {
				afterSlash = true;
			}

			if (afterSlash) {
				j++;
			}
		}

		this.numerator = new BigInteger(fraction.substring(0,
				(fraction.length() - j)));
		this.denominator = new BigInteger(fraction.substring(j + 1));
		this.simplify();
	} // Fraction(String)

	public BigInteger numerator() {
		return this.numerator;
	}

	public BigInteger denominator() {
		return this.denominator;
	}

	public Fraction add(Fraction other) {
		BigInteger num = this.numerator().multiply(other.denominator())
				.add(other.numerator().multiply(this.denominator()));
		BigInteger den = this.denominator().multiply(other.denominator());
		Fraction sum = new Fraction(num, den);
		sum.simplify();
		return sum;
	}

	public Fraction subtract(Fraction other) {
		BigInteger num = this.numerator().multiply(other.denominator())
				.subtract(other.numerator().multiply(this.denominator()));
		BigInteger den = this.denominator().multiply(other.denominator());
		Fraction difference = new Fraction(num, den);
		difference.simplify();
		return difference;
	}

	public Fraction multiply(Fraction other) {
		BigInteger num = this.numerator().multiply(other.numerator());
		BigInteger den = this.denominator().multiply(other.denominator());
		Fraction product = new Fraction(num, den);
		product.simplify();
		return product;
	}

	public Fraction divide(Fraction other) {
		if (other.numerator().intValue() != 0) {
			BigInteger num = this.numerator().multiply(other.denominator());
			BigInteger den = this.denominator().multiply(other.numerator());
			Fraction quotient = new Fraction(num, den);
			quotient.simplify();
			return quotient;
		} else {
			throw new ArithmeticException("Division by 0");
		}
	}

	public Fraction pow(int expt) {
		return null;
	}

	public Fraction reciprocal() {
		BigInteger num = this.denominator();
		BigInteger den = this.numerator();
		Fraction recip = new Fraction(num, den);
		recip.simplify();
		return recip;
	}

	public Fraction negate() {
		Fraction neg = new Fraction(this.numerator().multiply(
				BigInteger.valueOf(-1)), this.denominator());
		neg.simplify();
		return neg;
	}

	public double doubleValue() {
		return this.numerator().doubleValue()
				/ this.denominator().doubleValue();
	}

	public BigDecimal bigDecimalValue() {
		return new BigDecimal(this.numerator()).divide(new BigDecimal(this
				.denominator()));
	}

	public Fraction fractionalPart() {
		BigInteger num = this.numerator();
		while (num.compareTo(this.denominator()) > 0) {
			num.subtract(this.numerator());
		}
		Fraction frac = new Fraction(num, this.denominator());
		frac.simplify();
		return frac;
	}

	public BigInteger wholePart() {
		Fraction whole = this.subtract(this.fractionalPart());
		whole.simplify();
		return whole.numerator();
	}

	private void simplify() {
		// TODO Auto-generated method stub
	}

} // Fraction
