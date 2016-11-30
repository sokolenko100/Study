package Arrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ReversArrayTest {

	@Test
	public void testRevers_notEven() {
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] expec = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ReversArray.Revers(ini);
		assertArrayEquals(expec, ini);
	}

	@Test
	public void testRevers_Even() {
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] expec = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ReversArray.Revers(ini);
		assertArrayEquals(expec, ini);
	}

	@Test
	public void testRevers_1() {
		int[] ini = { 9 };
		int[] expec = { 9 };
		ReversArray.Revers(ini);
		assertArrayEquals(expec, ini);
	}

	@Test
	public void testRevers_2() {
		int[] ini = { 9, 2 };
		int[] expec = { 2, 9 };
		ReversArray.Revers(ini);
		assertArrayEquals(expec, ini);
	}

	@Test
	public void testRevers_0() {
		int[] ini = {};
		int[] expec = {};
		ReversArray.Revers(ini);
		assertArrayEquals(expec, ini);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRevers_E() {
		int[] ini = null;
		ReversArray.Revers(ini);
	}
}
