package Cycles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SummNumbersValue_2Test {

	@Test
	public void testConsiderSuumNumbersValue() {
		int result = SummNumbersValue_2.considerSuumNumbersValue(123);
		assertEquals(6, result);
	}

	@Test
	public void testConsiderSuumNumbersValue_0() {
		int result = SummNumbersValue_2.considerSuumNumbersValue(0);
		assertEquals(0, result);
	}

	@Test
	public void testConsiderSuumNumbersValue_m123() {
		int result = SummNumbersValue_2.considerSuumNumbersValue(-123);
		assertEquals(-6, result);
	}
}
