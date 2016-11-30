package Arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinElemArrayTest {

	@Test
	public void testSearthMinElementArray() {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int result = MinElemArray.SearthMinElementArray(array);
		assertEquals(1, result);
	}

	@Test
	public void testSearthMinElementArray_1() {
		int[] array = { 9 };
		int result = MinElemArray.SearthMinElementArray(array);
		assertEquals(9, result);
	}

	@Test
	public void testSearthMinElementArray_2() {
		int[] array = { 9, 2 };
		int result = MinElemArray.SearthMinElementArray(array);
		assertEquals(2, result);
	}

	@Test
	public void testSearthMinElementArray_0() {
		int[] array = {};
		int result = MinElemArray.SearthMinElementArray(array);
		assertEquals(0, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearthMinElementArray_E() {
		int[] array = null;
		MinElemArray.SearthMinElementArray(array);
	}
}
