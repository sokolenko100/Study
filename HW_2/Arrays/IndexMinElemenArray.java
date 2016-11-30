package Arrays;

public class IndexMinElemenArray {
	public static int SearthMinElementIndex(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		int result = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[result] > array[i]) {
				result = i;
			}
		}
		return result;
	}
}
