package Arrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortArrayTest {

	@Test
	public void testBubleSort() {
		int[] ini = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
		int[] excp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		SortArray.BubleSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test
	public void testBubleSort_1() {
		int[] ini = { 9 };
		int[] excp = { 9 };
		SortArray.BubleSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test
	public void testBubleSort_2() {
		int[] ini = { 9, 2 };
		int[] excp = { 2, 9 };
		SortArray.BubleSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test
	public void testBubleSort_0() {
		int[] ini = {};
		int[] excp = {};
		SortArray.BubleSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBubleSort_E() {
		int[] ini = null;
		SortArray.BubleSort(ini);
	}

	@Test
	public void testSelectSort() {
		int[] ini = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
		int[] excp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		SortArray.SelectSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test
	public void testSelectSort_1() {
		int[] ini = { 9 };
		int[] excp = { 9 };
		SortArray.SelectSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test
	public void testSelectSort_2() {
		int[] ini = { 9, 2 };
		int[] excp = { 2, 9 };
		SortArray.SelectSort(ini);
		assertArrayEquals(excp, ini);
		;
	}

	@Test
	public void testSelectSort_0() {
		int[] ini = {};
		int[] excp = {};
		SortArray.SelectSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSelectSort_E() {
		int[] ini = null;
		SortArray.SelectSort(ini);
	}

	@Test
	public void testInsertSort() {
		int[] ini = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
		int[] excp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		SortArray.InsertSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test
	public void testInsertSort_1() {
		int[] ini = { 9 };
		int[] excp = { 9 };
		SortArray.InsertSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test
	public void testInsertSort_2() {
		int[] ini = { 9, 2 };
		int[] excp = { 2, 9 };
		SortArray.InsertSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test
	public void testInsertSort_0() {
		int[] ini = {};
		int[] excp = {};
		SortArray.InsertSort(ini);
		assertArrayEquals(excp, ini);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertSort_E() {
		int[] ini = null;
		SortArray.InsertSort(ini);
	}

}
