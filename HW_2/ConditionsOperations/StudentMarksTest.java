package ConditionsOperations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StudentMarksTest {
	@Test(expected = IllegalArgumentException.class)
	public void ShowResaltTaskFifth_test_m1() {
		StudentMarks.ShowResaltTaskFifth(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ShowResaltTaskFifth_test_101() {
		StudentMarks.ShowResaltTaskFifth(101);
	}

	@Test
	public void ShowResaltTaskFifth_test_0() {
		String marks = StudentMarks.ShowResaltTaskFifth(0);
		assertEquals("F", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_10() {
		String marks = StudentMarks.ShowResaltTaskFifth(10);
		assertEquals("F", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_19() {
		String marks = StudentMarks.ShowResaltTaskFifth(19);
		assertEquals("F", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_20() {
		String marks = StudentMarks.ShowResaltTaskFifth(20);
		assertEquals("E", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_25() {
		String marks = StudentMarks.ShowResaltTaskFifth(25);
		assertEquals("E", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_39() {
		String marks = StudentMarks.ShowResaltTaskFifth(39);
		assertEquals("E", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_40() {
		String marks = StudentMarks.ShowResaltTaskFifth(40);
		assertEquals("D", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_45() {
		String marks = StudentMarks.ShowResaltTaskFifth(45);
		assertEquals("D", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_59() {
		String marks = StudentMarks.ShowResaltTaskFifth(59);
		assertEquals("D", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_60() {
		String marks = StudentMarks.ShowResaltTaskFifth(60);
		assertEquals("C", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_64() {
		String marks = StudentMarks.ShowResaltTaskFifth(64);
		assertEquals("C", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_74() {
		String marks = StudentMarks.ShowResaltTaskFifth(74);
		assertEquals("C", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_75() {
		String marks = StudentMarks.ShowResaltTaskFifth(75);
		assertEquals("B", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_80() {
		String marks = StudentMarks.ShowResaltTaskFifth(80);
		assertEquals("B", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_89() {
		String marks = StudentMarks.ShowResaltTaskFifth(89);
		assertEquals("B", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_90() {
		String marks = StudentMarks.ShowResaltTaskFifth(90);
		assertEquals("A", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_95() {
		String marks = StudentMarks.ShowResaltTaskFifth(95);
		assertEquals("A", marks);
	}

	@Test
	public void ShowResaltTaskFifth_test_100() {
		String marks = StudentMarks.ShowResaltTaskFifth(100);
		assertEquals("A", marks);
	}
}
