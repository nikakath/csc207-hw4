package edu.grinnell.csc207.nikakath.hw4;

import java.util.Arrays;

import edu.grinnell.csc207.nikakath.hw4.Fraction;

public class Calculator {
	static String[] rs = { "0", "0", "0", "0", "0", "0", "0", "0" };

	public static Fraction evaluate(String expression) {
		System.out.println("expression sent is " + expression);
		String[] expressions = expression.split(" ");
		if (expression.contains("=")) {
			String substring = expression.substring(expression.indexOf("="));
			rs[Character.getNumericValue(expression.charAt(1))] = substring;
		}

		else if (expressions.length <= 2) {
			if (expression.contains("r")) {
				return (evaluate(rs[Character.getNumericValue(expression.charAt(1))]));
			} else {
				return new Fraction(expressions[0]);
			}
		}

		else {
			Fraction first = evaluate(expressions[0]);
			Fraction other = evaluate(expressions[2]);
			String rest = "";

			for (int i = 3; i < expressions.length; i++) {
				rest = rest.concat(" ").concat(expressions[i]);
			}
			System.out.println("right before division " + expression);

			if (expressions[1].equals("/")) {
				return evaluate(first.divide(other).toString().concat(rest));
			} else if (expressions[1].equals("+")) {
				return evaluate(first.add(other).toString().concat(rest));
			} else if (expressions[1].equals("*")) {
				return evaluate(first.multiply(other).toString().concat(rest));
			} else if (expressions[1].equals("-")) {
				return evaluate(first.subtract(other).toString().concat(rest));
			}

		}
		
		return null;
	}

	public static void main(String[] args) {
		System.out.println(evaluate("4 / 3"));
	}
}
