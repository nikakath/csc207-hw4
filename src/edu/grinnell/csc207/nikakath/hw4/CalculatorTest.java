package edu.grinnell.csc207.nikakath.hw4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEvaluate() throws Exception {
		assertEquals("1", Calculator.evaluate("1/2 + 1/2").toString());
		assertEquals("1/2", Calculator.evaluate("r1 + 1/2").toString());
		assertEquals("11/2", Calculator.evaluate("5 + 1/2").toString());
		assertEquals("0", Calculator.evaluate("0 + 0").toString());
		assertEquals("3/4", Calculator.evaluate("5/4 - 1/2").toString());
		assertEquals("1", Calculator.evaluate("1/2 + 1/2").toString());
		assertEquals("1/4", Calculator.evaluate("1/2 * 1/2").toString());
		assertEquals("1", Calculator.evaluate("1/2 / 1/2").toString());
		assertEquals("2", Calculator.evaluate("1/2 + 1/2 + 1").toString());
		assertEquals("1", Calculator.evaluate("1/2 * 1/2 + 3/4").toString());
		assertEquals("1/2", Calculator.evaluate("1/2").toString());
		assertEquals("3/2", Calculator.evaluate("6/4").toString());
		Calculator.evaluate("r1 = 5 + 5");
		assertEquals("21/2", Calculator.evaluate("1/2 + r1").toString());
	}

}
