package Arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearthSummElementDoesNotEvenTest {

	@Test
	public void testSummCountDoesNotEventElement() {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int result = SearthSummElementDoesNotEven
				.SummCountDoesNotEventElement(array);
		assertEquals(4, result);
	}

	@Test
	public void testSummCountDoesNotEventElement_1() {
		int[] ini = { 9 };
		int result = SearthSummElementDoesNotEven
				.SummCountDoesNotEventElement(ini);
		assertEquals(0, result);
	}

	@Test
	public void testSummCountDoesNotEventElement_2() {
		int[] ini = { 9, 2 };
		int result = SearthSummElementDoesNotEven
				.SummCountDoesNotEventElement(ini);
		assertEquals(1, result);
	}

	@Test
	public void testSummCountDoesNotEventElement_0() {
		int[] ini = {};
		int result = SearthSummElementDoesNotEven
				.SummCountDoesNotEventElement(ini);
		assertEquals(0, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSummCountDoesNotEventElement_E() {
		int[] ini = null;
		SearthSummElementDoesNotEven.SummCountDoesNotEventElement(ini);
	}
}
