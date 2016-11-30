package Cycles;

public class MirrorOfNumber {
	public static int MirrorsNumberMethod(int number) {
		int result = 0;
		String stringNumber = Integer.toString(number);
		for (int i = 0; i < stringNumber.length(); i++) {
			result += number % 10;
			number /= 10;
			if (number != 0) {
				result *= 10;
			}
		}
		return result;
	}
}
