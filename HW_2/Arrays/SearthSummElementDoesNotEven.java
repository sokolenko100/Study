package Arrays;

public class SearthSummElementDoesNotEven {
	public static int SummCountDoesNotEventElement(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		int result = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				result++;
			}
		}
		return result;
	}
}
