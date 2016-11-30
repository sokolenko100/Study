package Arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SummElemenWithDoesnotEvenIndexTest {

	@Test
	public void SummElemenWithDoesnotEvenIndex() {
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int result = SummElemenWithDoesnotEvenIndex
				.SearthSummElementDoesNotEven(ini);
		assertEquals(20, result);
	}

	@Test
	public void SummElemenWithDoesnotEvenIndex_1() {
		int[] ini = { 9 };
		int result = SummElemenWithDoesnotEvenIndex
				.SearthSummElementDoesNotEven(ini);
		assertEquals(0, result);
	}

	@Test
	public void SummElemenWithDoesnotEvenIndex_2() {
		int[] ini = { 9, 2 };
		int result = SummElemenWithDoesnotEvenIndex
				.SearthSummElementDoesNotEven(ini);
		assertEquals(2, result);
	}

	@Test
	public void SummElemenWithDoesnotEvenIndex_0() {
		int[] ini = {};
		int result = SummElemenWithDoesnotEvenIndex
				.SearthSummElementDoesNotEven(ini);
		assertEquals(0, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void SummElemenWithDoesnotEvenIndex_E() {
		int[] ini = null;
		SummElemenWithDoesnotEvenIndex.SearthSummElementDoesNotEven(ini);
	}
}
