package Cycles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void testSearthFactorial() {
		int result = Factorial.SearthFactorial(5);
		assertEquals(120, result);
	}

	@Test
	public void testSearthFactorial_0() {
		int result = Factorial.SearthFactorial(0);
		assertEquals(1, result);
	}

	@Test
	public void testSearthFactorial_1() {
		int result = Factorial.SearthFactorial(1);
		assertEquals(1, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearthFactorial_Exception() {
		Factorial.SearthFactorial(-5);
	}

}
