package ConditionsOperations;

public class TaskConditionsSearchCoordinate {
	public static int searchCoordinate(int x, int y) {
		if (x == 0 || y == 0) {
			throw new IllegalArgumentException();
		}
		int result = 0;
		int zero = 0;
		if (x > zero && y > zero) {
			result = 1;
		} else if (x > zero && y < zero) {
			result = 2;
		} else if (x < zero && y < zero) {
			result = 3;
		} else if (x < zero && y > zero) {
			result = 4;
		}
		return result;
	}
}
