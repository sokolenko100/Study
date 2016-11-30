package ConditionsOperations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TaskConditionsFirstTest {

	@Test
	public void testShowResaltTaskIf_Mul() {
		int result = TaskConditionsFirst.ShowResaltTaskIf_1(6, 5);
		assertEquals(30, result);
	}

	@Test
	public void testShowResaltTaskIf_Plus() {
		int result = TaskConditionsFirst.ShowResaltTaskIf_1(5, 5);
		assertEquals(10, result);
	}

	@Test
	public void testSearthMinElementIndex_ma() {
		int result = TaskConditionsFirst.ShowResaltTaskIf_1(-2, 5);
		assertEquals(-10, result);
	}

	@Test
	public void testSearthMinElementIndex_mb() {
		int result = TaskConditionsFirst.ShowResaltTaskIf_1(2, -5);
		assertEquals(-10, result);
	}
}
