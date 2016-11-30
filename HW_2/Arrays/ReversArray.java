package Arrays;

public class ReversArray {
	public static void Revers(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		int half = 0;
		int arrLeght = array.length;
		if (arrLeght % 2 == 0) {
			half = arrLeght / 2;
		} else {
			half = (arrLeght / 2) + 1;
		}
		for (int i = 0; i < arrLeght / 2; i++) {
			int temp = array[i];
			array[i] = array[arrLeght - (i + 1)];
			array[arrLeght - (i + 1)] = temp;
		}
	}
}
