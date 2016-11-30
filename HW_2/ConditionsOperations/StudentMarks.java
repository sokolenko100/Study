package ConditionsOperations;

public class StudentMarks {
	public static String ShowResaltTaskFifth(int mark) {
		if (mark < 0 || mark > 100) {
			throw new IllegalArgumentException();
		}
		String markString = "";
		if (mark >= 0 && mark <= 19) {
			markString = "F";
		}
		if (20 <= mark && mark <= 39) {
			markString = "E";
		}
		if (40 <= mark && mark <= 59) {
			markString = "D";
		}
		if (60 <= mark && mark <= 74) {
			markString = "C";
		}
		if (75 <= mark && mark <= 89) {
			markString = "B";
		}
		if (90 <= mark && mark <= 100) {
			markString = "A";
		}
		return markString;
	}
}
