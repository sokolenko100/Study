package Function;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchDistanceBetwinTwoPoinsTest {

	@Test
	public void TestDistanceBetwinTwoPoins() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, 1,
				2, 2, 1, 2);
		assertEquals(2, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_x0_eql_0() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(0, 1,
				2, 2, 1, 2);
		assertEquals(2, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_y0_eql_0() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, 0,
				2, 2, 1, 2);
		assertEquals(2, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_x1_eql_0() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, 1,
				0, 2, 1, 2);
		assertEquals(2, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_y1_eql_0() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, 1,
				2, 0, 1, 2);
		assertEquals(2, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_z0_eql_0() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, 1,
				2, 2, 0, 2);
		assertEquals(2, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_z1_eql_0() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, 1,
				2, 2, 1, 0);
		assertEquals(2, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_all_eql_0() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(0, 0,
				0, 0, 0, 0);
		assertEquals(0, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_x0_eql_m1() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(-1, 1,
				2, 2, 1, 2);
		assertEquals(3, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_y0_eql_m1() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, -1,
				2, 2, 1, 2);
		assertEquals(3, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_x1_eql_m2() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, 1,
				-2, 2, 1, 2);
		assertEquals(3, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_y1_eql_m2() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, 1,
				2, -2, 1, 2);
		assertEquals(3, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_z0_eql_m1() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, 1,
				2, 2, -1, 2);
		assertEquals(3, result);
	}

	@Test
	public void TestDistanceBetwinTwoPoins_z1_eql_m2() {
		int result = SearchDistanceBetwinTwoPoins.DistanceBetwinTwoPoins(1, 1,
				2, 2, 1, -2);
		assertEquals(2, result);
	}
}
