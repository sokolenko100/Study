package Arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxElementArrayTest {

	@Test
	public void testSearthMaxElementArray() {
		int[] arrayMy = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int result = MaxElementArray.SearthMaxElementArray(arrayMy);
		assertEquals(9, result);
	}

	@Test
	public void testSearthMaxElementIndex_1() {
		int[] array = { 9 };
		int result = MaxElementArray.SearthMaxElementArray(array);
		assertEquals(9, result);
	}

	@Test
	public void testSearthMaxElementIndex_2() {
		int[] array = { 9, 2 };
		int result = MaxElementArray.SearthMaxElementArray(array);
		assertEquals(9, result);
	}

	@Test
	public void testSearthMinElementIndex_0() {
		int[] array = {};
		int result = MaxElementArray.SearthMaxElementArray(array);
		assertEquals(0, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearthMinElementIndex_E() {
		int[] array = null;
		MaxElementArray.SearthMaxElementArray(array);
	}
}
