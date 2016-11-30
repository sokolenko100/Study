package ConditionsOperations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class considerMax_return_multABCPlus_3_or_summABCPlus_3Test {

	@Test
	public void searchCoordinate_test_Mult_vABC_Plus_3() {
		int result = considerMax_return_multABCPlus_3_or_summABCPlus_3
				.showResaltTaskThird(6, 5, 5);
		assertEquals(153, result);
	}

	@Test
	public void searchCoordinate_test_Summ_ABC_Plus_3() {
		int result = considerMax_return_multABCPlus_3_or_summABCPlus_3
				.showResaltTaskThird(6, 5, -5);
		assertEquals(9, result);
	}

	@Test
	public void searchCoordinate_test_All_0() {
		int result = considerMax_return_multABCPlus_3_or_summABCPlus_3
				.showResaltTaskThird(0, 0, 0);
		assertEquals(3, result);
	}

	@Test
	public void searchCoordinate_test_a_eql_0() {
		int result = considerMax_return_multABCPlus_3_or_summABCPlus_3
				.showResaltTaskThird(0, 3, -4);
		assertEquals(3, result);
	}

	@Test
	public void searchCoordinate_test_b_eql_0() {
		int result = considerMax_return_multABCPlus_3_or_summABCPlus_3
				.showResaltTaskThird(6, 0, 8);
		assertEquals(17, result);
	}

	@Test
	public void searchCoordinate_test_c_eql_0() {
		int result = considerMax_return_multABCPlus_3_or_summABCPlus_3
				.showResaltTaskThird(-5, 5, 0);
		assertEquals(3, result);
	}
}
