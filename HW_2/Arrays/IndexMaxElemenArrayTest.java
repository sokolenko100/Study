package Arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndexMaxElemenArrayTest {

	@Test
	public void testSearthMaxElementIndex() {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int result = IndexMaxElemenArray.SearthMaxElementIndex(array);
		assertEquals(0, result);
	}

	@Test
	public void testSearthMaxElementIndex_1() {
		int[] array = { 9 };
		int result = IndexMaxElemenArray.SearthMaxElementIndex(array);
		assertEquals(0, result);
	}

	@Test
	public void testSearthMaxElementIndex_2() {
		int[] array = { 9, 2 };
		int result = IndexMaxElemenArray.SearthMaxElementIndex(array);
		assertEquals(0, result);
	}

	@Test
	public void testSearthMinElementIndex_0() {
		int[] array = {};
		int result = IndexMaxElemenArray.SearthMaxElementIndex(array);
		assertEquals(0, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearthMinElementIndex_E() {
		int[] array = null;
		IndexMaxElemenArray.SearthMaxElementIndex(array);
	}

}
