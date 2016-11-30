package Cycles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SqrtAndBinarySearthTest {

	@Test
	public void testSqrtMethod_49() {
		int result = SqrtAndBinarySearth.SqrtMethod(49);
		assertEquals(7, result);
	}

	@Test
	public void testSqrtMethod_0() {
		int result = SqrtAndBinarySearth.SqrtMethod(0);
		assertEquals(0, result);
	}

	@Test
	public void testSqrtMethod_m12() {
		int result = SqrtAndBinarySearth.SqrtMethod(-12);
		assertEquals(0, result);
	}

	@Test
	public void testSqrtMethod_55() {
		int result = SqrtAndBinarySearth.SqrtMethod(55);
		assertEquals(7, result);
	}
}