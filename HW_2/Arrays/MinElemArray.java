package Arrays;

public class MinElemArray {

	public static int SearthMinElementArray(int... array) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		int result = 0;
		if (array.length > 0) {
			result = array[0];
		}

		for (int i = 1; i < array.length; i++) {
			if (result > array[i]) {
				result = array[i];
			}
		}
		return result;
	}
}
