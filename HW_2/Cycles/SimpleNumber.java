package Cycles;

public class SimpleNumber {
	public static Boolean checkSimpleNumber(int number) {
		Boolean result = false;
		int count = 0;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				count++;
			}
		}
		if (count > 0) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
}
