package ConditionsOperations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculateSimpleOperationTest {
	@Test
	public void testCalc_Plus() {
		int rez = CalculateSimpleOperation.calc(5, 10, '+');
		assertEquals(15, rez);
	}

	@Test
	public void testCalc_Minus() {
		int rez = CalculateSimpleOperation.calc(50, 10, '-');
		assertEquals(40, rez);
	}

	@Test
	public void testCalc_Mult() {
		int rez = CalculateSimpleOperation.calc(5, 10, '*');
		assertEquals(50, rez);
	}

	@Test
	public void testCalc_Div() {
		int rez = CalculateSimpleOperation.calc(10, 10, '/');
		assertEquals(1, rez);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalc_Except_b_eql_0() {
		CalculateSimpleOperation.calc(10, 0, '/');
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalc_Except_op_eql_y() {
		CalculateSimpleOperation.calc(10, 4, 'y');
	}

}
