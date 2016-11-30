package Arrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ReversHalfArrayTest {

	@Test
	public void testReversHalfElement_notEven() {
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] expec = { 4, 3, 2, 1, 5, 9, 8, 7, 6 };
		ReversHalfArray.ReversHalfElement(ini);
		assertArrayEquals(expec, ini);
	}

	@Test
	public void testReversHalfElement_Even() {
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] expec = { 4, 3, 2, 1, 0, 9, 8, 7, 6, 5 };
		ReversHalfArray.ReversHalfElement(ini);
		assertArrayEquals(expec, ini);
	}

	@Test
	public void testReversHalfElement_1() {
		int[] ini = { 9 };
		int[] expec = { 9 };
		ReversHalfArray.ReversHalfElement(ini);
		assertArrayEquals(expec, ini);
	}

	@Test
	public void testReversHalfElement_2() {
		int[] ini = { 9, 2 };
		int[] expec = { 2, 9 };
		ReversHalfArray.ReversHalfElement(ini);
		assertArrayEquals(expec, ini);
	}

	@Test
	public void testReversHalfElement_0() {
		int[] ini = {};
		int[] expec = {};
		ReversHalfArray.ReversHalfElement(ini);
		assertArrayEquals(expec, ini);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testReversHalfElement_E() {
		int[] ini = null;
		ReversHalfArray.ReversHalfElement(ini);
	}

}
