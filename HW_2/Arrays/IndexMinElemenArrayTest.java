package Arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndexMinElemenArrayTest {

	@Test
	public void testSearthMinElementIndex() {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int result = IndexMinElemenArray.SearthMinElementIndex(array);
		assertEquals(8, result);
	}

	@Test
	public void testSearthMinElementIndex_1() {
		int[] array = { 9 };
		int result = IndexMinElemenArray.SearthMinElementIndex(array);
		assertEquals(0, result);
	}

	@Test
	public void testSearthMinElementIndex_2() {
		int[] array = { 9, 2 };
		int result = IndexMinElemenArray.SearthMinElementIndex(array);
		assertEquals(1, result);
	}

	@Test
	public void testSearthMinElementIndex_0() {
		int[] array = {};
		int result = IndexMinElemenArray.SearthMinElementIndex(array);
		assertEquals(0, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearthMinElementIndex_E() {
		int[] array = null;
		IndexMinElemenArray.SearthMinElementIndex(array);
	}
}
