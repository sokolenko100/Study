package ConditionsOperations;

public class CalculateSimpleOperation {

	public static int calc(int a, int b, char op) {
		int res = 0;

		if ((op == '+' || op == '-' || op == '*' || op == '/') && b != 0) {

			if (op == '+') {
				res = a + b;
			} else if (op == '-') {
				res = a - b;
			} else if (op == '*') {
				res = a * b;
			} else if (op == '/') {
				res = a / b;
			}
		} else {
			throw new IllegalArgumentException();
		}
		return res;
	}

}
