package edu.grinnell.csc207.nikakath.hw4;

import java.util.Arrays;
import java.io.IOException;
import java.io.PrintWriter;

import edu.grinnell.csc207.nikakath.hw4.Fraction;

public class Calculator {
	static String[] rs = { "0", "0", "0", "0", "0", "0", "0", "0" };

	public static Fraction evaluate(String expression) throws Exception {
		String[] expressions = expression.split(" ");
		/*if (expressions.length > 1) {

			if (expressions[1].compareTo("=") == 0) {
				if (expressions[0].charAt(0) != 'r') {
					throw new Exception(
							"you must include a memory address if you want to store something. You included: "
									+ expressions[0]);
				} else if (expressions[0].length()>2 && Character.getNumericValue(expressions[0].charAt(1)) > 7
						|| Character.getNumericValue(expressions[0].charAt(1)) < 0) {
					throw new Exception(
							"You must specify a memory address between 0 and 7");
				}
			} else {
				for (int index = 1; index < expressions.length - 1; index = index + 2) {
					if (expressions[index].compareTo("+") != 0
							&& expressions[index].compareTo("-") != 0
							&& expressions[index].compareTo("*") != 0
							&& expressions[index].compareTo("/") != 0) {
						throw new Exception("At location " + index
								+ ", user included a non-recognized operation.");
					}
				}
			}

			for (int index = 0; index < expressions.length - 1; index = index + 2) {
				for (int i = 0; i < expressions[index].length(); i++) {
					if (Character.isDigit(expressions[index].charAt(i)) == false
							&& expressions[index].charAt(i) != 'r'
							&& expressions[index].charAt(i) != '/') {
						System.out.println(expressions[index]);
						throw new Exception("at Location " + index
								+ ", user included a non-parsable input.");
					}

				}
			}
		}*/

		if (expression.contains("=")) {
			String substring = expression.substring(expression.indexOf("=")+2);
			System.out.println(expression.substring(expression.indexOf("=")+2));
			rs[Character.getNumericValue(expression.charAt(1))] = substring;
			return null;
		}

		else if (expressions.length <= 2) {
			if (expression.contains("r")) {
				return (evaluate(rs[Character.getNumericValue(expression
						.charAt(1))]));
			} else {
				System.out.println(expressions[0]);
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
			if (expressions[1].equals("/")) {
				return evaluate(first.divide(other).toString().concat(rest));
			} else if (expressions[1].equals("+")) {

				return evaluate(first.add(other).toString().concat(rest));
			} else if (expressions[1].equals("*")) {
				return evaluate(first.multiply(other).toString().concat(rest));
			} else if (expressions[1].equals("-")) {
				return evaluate(first.subtract(other).toString().concat(rest));
			} // IMPLEMENT POW ("^")

		}

		return null;
	}

	public static void main(String[] args) throws Exception {
		String in = "";
		PrintWriter pen = new PrintWriter(System.out, true);
		java.io.BufferedReader eyes;
		java.io.InputStreamReader istream;
		istream = new java.io.InputStreamReader(System.in);
		eyes = new java.io.BufferedReader(istream);
		boolean terminate = false;

		while (!terminate) {
			pen.print("Input expression: ");
			pen.flush();
			try {
				in = eyes.readLine();
			} catch (IOException e) {
				pen.println("I'm sorry; something was wrong with your input. "
						+ e.getMessage());
				pen.flush();
			}
			try {
				Fraction result = evaluate(in);
				if (result == null) {
					pen.println("Stored!");
					pen.flush();
				} else {
					pen.println(in + " = " + result.toString());
					pen.flush();
				}
			} catch (Exception e) {
				pen.println("I'm sorry; something was wrong with your input. "
						+ e.getMessage());
				pen.flush();
			}
			pen.print("Input another expression? y/n ");
			pen.flush();
			try {
				in = eyes.readLine();
			} catch (IOException e) {
				pen.println("I'm sorry; something was wrong with your input. "
						+ e.getMessage());
				pen.flush();
			}
			if (in.startsWith("n")) {
				terminate = true;
			}
		}
		pen.close();
		try {
			eyes.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
