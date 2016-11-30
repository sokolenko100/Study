package Function;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GetStringNameDayOfWeekTest {

	@Test
	public void test_DayOfMonday_1() {
		String result = GetStringNameDayOfWeek.GetStringNameDayOfWeeks(1);
		assertEquals("Monday", result);
	}

	@Test
	public void test_DayOfTuesday_2() {
		String result = GetStringNameDayOfWeek.GetStringNameDayOfWeeks(2);
		assertEquals("Tuesday", result);
	}

	@Test
	public void test_DayOfWednesday_3() {
		String result = GetStringNameDayOfWeek.GetStringNameDayOfWeeks(3);
		assertEquals("Wednesday", result);
	}

	@Test
	public void test_DayOfThursday_4() {
		String result = GetStringNameDayOfWeek.GetStringNameDayOfWeeks(4);
		assertEquals("Thursday", result);
	}

	@Test
	public void test_DayOfFriday_5() {
		String result = GetStringNameDayOfWeek.GetStringNameDayOfWeeks(5);
		assertEquals("Friday", result);
	}

	@Test
	public void test_DayOfSaturday_6() {
		String result = GetStringNameDayOfWeek.GetStringNameDayOfWeeks(6);
		assertEquals("Saturday", result);
	}

	@Test
	public void test_DayOfSunday_7() {
		String result = GetStringNameDayOfWeek.GetStringNameDayOfWeeks(7);
		assertEquals("Sunday", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_DayException_m3() {
		GetStringNameDayOfWeek.GetStringNameDayOfWeeks(-3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_DayException_0() {
		GetStringNameDayOfWeek.GetStringNameDayOfWeeks(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_DayException_10() {
		GetStringNameDayOfWeek.GetStringNameDayOfWeeks(10);
	}
}
