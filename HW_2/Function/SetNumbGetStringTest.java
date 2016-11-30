package Function;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SetNumbGetStringTest {

	@Test
	public void testShowStringNumb_123() {
		String result = SetNumbGetString.ShowNumbFromString(123);
		assertEquals("сто двадцать три", result);
	}

	@Test
	public void testShowStringNumb_0() {
		String result = SetNumbGetString.ShowNumbFromString(0);
		assertEquals(" ноль", result);
	}

	@Test
	public void testShowStringNumb_999() {
		String result = SetNumbGetString.ShowNumbFromString(999);
		assertEquals("девятьсот девяносто девять", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShowStringNumb_1000() {
		SetNumbGetString.ShowNumbFromString(1000);
	}
}
