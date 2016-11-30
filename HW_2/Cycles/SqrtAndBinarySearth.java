package Cycles;

public class SqrtAndBinarySearth {

	public static int SqrtMethod(int x) {
		int temp = 0;
		int rezult = 0;
		while (x > 0) {
			x -= temp;
			temp += 2;
			if (x > 0) {
				rezult += 1;
			}
		}
		return rezult;
	}

	public static int BinarySearth(int searchNumb) {
		int[] array = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int centre = 0;
		int result = 0;
		int endArr = array.length - 1;
		int start = 0;
		while (array[centre] != searchNumb && start < endArr) {
			centre = (endArr + start) / 2;
			if (searchNumb > array[centre]) {
				start = centre + 1;
			}
			if (searchNumb < array[centre]) {
				endArr = centre - 1;
			}
			if (array[centre] == searchNumb) {
				result = array[centre];
			}
		}
		return result;
	}

	public static int sequentialSelection(int searchNumb) {
		int result = 0;
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 0; i < array.length; i++) {
			if (searchNumb == array[i]) {
				result = searchNumb;
			}
		}
		return result;
	}
}
