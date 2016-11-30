package Cycles;

public class Factorial {

	public static int SearthFactorial(int number) {
		if (number < 0) {
			throw new IllegalArgumentException();
		}
		int result = 1;
		for (int i = 2; i <= number; i++) {
			result *= i;
		}
		return result;
	}
}
