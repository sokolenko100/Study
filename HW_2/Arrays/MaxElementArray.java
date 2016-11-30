package Arrays;

public class MaxElementArray {
	public static int SearthMaxElementArray(int... array) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		int result = 0;
		if (array.length > 0) {
			result = array[0];
		}

		for (int i = 1; i < array.length; i++) {
			if (result < array[i]) {
				result = array[i];
			}
		}
		return result;
	}
}
