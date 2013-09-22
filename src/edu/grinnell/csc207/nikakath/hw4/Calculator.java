package edu.grinnell.csc207.nikakath.hw4;
import edu.grinnell.csc207.nikakath.hw4.Fraction;

public class Calculator {
	String r0, r1, r2, r3, r4, r5, r6,
			r7 = r0 = r1 = r2 = r3 = r4 = r5 = r6 = r7 = "0";

	public Fraction evaluate(String expression) {

		String[] expressions = expression.split(" ");

		if (expression.contains("=")) {
			if (expressions[0].equals("r0"))
				r0 = expressions[2];
			else if (expressions[0].equals("r1"))
				r1 = expressions[2];
			else if (expressions[0].equals("r2"))
				r2 = expressions[2];
			else if (expressions[0].equals("r3"))
				r3 = expressions[2];
			else if (expressions[0].equals("r4"))
				r4 = expressions[2];
			else if (expressions[0].equals("r5"))
				r5 = expressions[2];
			else if (expressions[0].equals("r6"))
				r6 = expressions[2];
			else if (expressions[0].equals("r7"))
				r7 = expressions[2];
		}

		else if (expressions.length == 1) {
			if (expression.contains("r")) {
				return (evaluate(expression));
			} else {
				return new Fraction(expression);
			}
		}

		else {
			Fraction  first = evaluate(expressions[0]);
			Fraction other= evaluate(expressions[2]);
			if (expressions[1].equals("/"))
			{
				return first.divide(other);
			}
			else if (expressions[1].equals("+"))
			{
				return first.add(other);
			}
			else if (expressions[1].equals("*"))
			{
				return first.multiply(other);
			}
			else if (expressions[1].equals("-"))
			{
				return first.subtract(other);
			}

			
		}

		return null;
	}
}
