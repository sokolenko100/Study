package Cycles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleNumberTest {

	@Test
	public void testCheckSimpleNumber_Simple_5() {
		Boolean result = SimpleNumber.checkSimpleNumber(5);
		assertEquals(true, result);
	}

	@Test
	public void testCheckSimpleNumber_Simple_997() {
		Boolean result = SimpleNumber.checkSimpleNumber(997);
		assertEquals(true, result);
	}

	@Test
	public void testCheckSimpleNumber_DoesNotSimple() {
		Boolean result = SimpleNumber.checkSimpleNumber(4);
		assertEquals(false, result);
	}

	@Test
	public void testCheckSimpleNumber_0() {
		Boolean result = SimpleNumber.checkSimpleNumber(0);
		assertEquals(true, result);
	}

	@Test
	public void testCheckSimpleNumber_m4_DoesNotSimple() {
		Boolean result = SimpleNumber.checkSimpleNumber(-4);
		assertEquals(true, result);
	}

	@Test
	public void testCheckSimpleNumber_m5_Simple() {
		Boolean result = SimpleNumber.checkSimpleNumber(-5);
		assertEquals(true, result);
	}
}
