package ConditionsOperations;

public class TaskConditionsFirst {
	public static int ShowResaltTaskIf_1(int a, int b) {
		int result = 0;
		if (a % 2 == 0) {
			result = a * b;
		} else {
			result = a + b;
		}
		return result;
	}
}
