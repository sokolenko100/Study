package Cycles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MirrorOfNumberTest {

	@Test
	public void testMirrorsNumberMethod_123return_321() {
		int result = MirrorOfNumber.MirrorsNumberMethod(123);
		assertEquals(321, result);
	}

	@Test
	public void testMirrorsNumberMethod_m123return_m321() {
		int result = MirrorOfNumber.MirrorsNumberMethod(-123);
		assertEquals(-321, result);
	}

	@Test
	public void testMirrorsNumberMethod_0return_0() {
		int result = MirrorOfNumber.MirrorsNumberMethod(0);
		assertEquals(0, result);
	}
}
