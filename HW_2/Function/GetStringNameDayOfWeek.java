package Function;

public class GetStringNameDayOfWeek {

	private static final int Monday = 1;
	private static final int Tuesday = 2;
	private static final int Wednesday = 3;
	private static final int Thursday = 4;
	private static final int Friday = 5;
	private static final int Saturday = 6;
	private static final int Sunday = 7;

	public static String GetStringNameDayOfWeeks(int dayOfWeek) {
		String resalt = "";
		if (dayOfWeek < 1 || dayOfWeek > 7) {
			throw new IllegalArgumentException();
		}
		switch (dayOfWeek) {
		case Monday: {
			resalt = "Monday";
			break;
		}
		case Tuesday: {
			resalt = "Tuesday";
			break;
		}
		case Wednesday: {
			resalt = "Wednesday";
			break;
		}
		case Thursday: {
			resalt = "Thursday";
			break;
		}
		case Friday: {
			resalt = "Friday";
			break;
		}
		case Saturday: {
			resalt = "Saturday";
			break;
		}
		case Sunday: {
			resalt = "Sunday";
			break;
		}
		default:

			break;
		}
		return resalt;
	}
}
