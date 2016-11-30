package ConditionsOperations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TaskConditionsSearchCoordinateTest {

	@Test
	public void searchCoordinate_test_firstquarter() {
		int result = TaskConditionsSearchCoordinate.searchCoordinate(6, 5);
		assertEquals(1, result);
	}

	@Test
	public void searchCoordinate_test_secondquarter() {
		int result = TaskConditionsSearchCoordinate.searchCoordinate(6, -5);
		assertEquals(2, result);
	}

	@Test
	public void searchCoordinate_test_thirdquarter() {
		int result = TaskConditionsSearchCoordinate.searchCoordinate(-6, -5);
		assertEquals(3, result);
	}

	@Test
	public void searchCoordinate_test_fourthquarter() {
		int result = TaskConditionsSearchCoordinate.searchCoordinate(-6, 5);
		assertEquals(4, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void searchCoordinate_test_exeption0_0() {
		TaskConditionsSearchCoordinate.searchCoordinate(0, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void searchCoordinate_test_exeption1_0() {
		TaskConditionsSearchCoordinate.searchCoordinate(1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void searchCoordinate_test_exeption0_1() {
		TaskConditionsSearchCoordinate.searchCoordinate(0, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void searchCoordinate_test_exeption_m1_0() {
		TaskConditionsSearchCoordinate.searchCoordinate(-1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void searchCoordinate_test_exeption_0_m1() {
		TaskConditionsSearchCoordinate.searchCoordinate(0, -1);
	}
}
