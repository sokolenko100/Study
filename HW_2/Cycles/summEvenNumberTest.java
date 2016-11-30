package Cycles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class summEvenNumberTest {

	@Test
	public void testSummAndCountEventNumberMethod() {
		int[] result = summEvenNumber.SummAndCountEventNumberMethod();
		assertEquals(2450, result[0]);
		assertEquals(49, result[1]);
	}
}
