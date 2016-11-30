package Arrays;

public class SummElemenWithDoesnotEvenIndex {
	public static int SearthSummElementDoesNotEven(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		int result = 0;

		for (int i = 1; i < array.length; i++) {
			if (i % 2 != 0) {
				result += array[i];
			}
		}
		return result;
	}
}
