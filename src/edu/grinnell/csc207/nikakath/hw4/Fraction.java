package edu.grinnell.csc207.nikakath.hw4;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.regex.*;

public class Fraction {

	public static void main(String[] args) {
		
		PrintWriter pen = new PrintWriter(System.out, true);
		
	}

	private BigInteger numerator;
	private BigInteger denominator;
	
	public Fraction(int num, int den) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.valueOf(den);
		
		//this.simplify();
		
	} //Fraction(int, int)
	
	public Fraction(int num) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.ONE;
		
		//this.simplify();
		
	} //Fraction(int)
	
	public Fraction(BigInteger num, BigInteger den) {
		this.numerator = num;
		this.denominator = den;
		
		//this.simplify();
		
	} //Fraction(BigInteger,BigInteger)
	
	public Fraction(BigInteger num) {
		this.numerator = num;
		this.denominator = BigInteger.ONE;
		
		//this.simplify();
		
	} //Fraction(BigInteger)
	
	public Fraction(long num, long den) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.valueOf(den);
		
		//this.simplify();
		
	} //Fraction(long, long)
	
	public Fraction(long num) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.ONE;
		
		//this.simplify();
		
	} //Fraction(long)
	
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
		
		//this.simplify();
	} //Fraction(double)
	
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
		
		this.numerator = new BigInteger(fraction.substring(0,(fraction.length() - j)));
		this.denominator = new BigInteger(fraction.substring(j + 1));
		
		//this.simplify();
	
	} //Fraction(String)
	
} //Fraction
