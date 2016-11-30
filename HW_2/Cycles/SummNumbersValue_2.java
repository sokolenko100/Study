package Cycles;

public class SummNumbersValue_2 {

	public static int considerSuumNumbersValue(int number) {
		Boolean mNumb = false;
		if (number < 0) {
			mNumb = true;
			number *= -1;
		}
		int result = 0;
		while (number > 0) {

			result += number % 10;
			number /= 10;
		}
		if (mNumb) {
			result *= -1;
		}
		return result;
	}
}
