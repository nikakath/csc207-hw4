package edu.grinnell.csc207.nikakath.hw4;

import java.math.BigInteger;

public class Fraction {

	public static void main(String[] args) {
	
	}

	private BigInteger numerator;
	private BigInteger denominator;
	
	public Fraction(int num, int den) {
		this.numerator = BigInteger.valueOf((long) num);
		this.denominator = BigInteger.valueOf((long) den);
	}
	
	public Fraction(int num) {
		this.numerator = BigInteger.valueOf((long) num);
		this.denominator = BigInteger.ONE;
	}
	
	public Fraction(BigInteger num, BigInteger den) {
		this.numerator = num;
		this.denominator = den;
	}
	
	public Fraction(BigInteger num) {
		this.numerator = num;
		this.denominator = BigInteger.ONE;
	}
	
	public Fraction(long num, long den) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.valueOf(den);
	}
	
	public Fraction(long num) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.ONE;
	}
	
	public Fraction(double num, double den) {
		this.numerator = BigInteger.valueOf((long) num);
		this.denominator = BigInteger.valueOf((long) den);
	}
	
	public Fraction(double num) {
		this.numerator = BigInteger.valueOf((long) num);
		this.denominator = BigInteger.ONE;
	}
	
	public Fraction(String fraction) {
		
	}
	
}
