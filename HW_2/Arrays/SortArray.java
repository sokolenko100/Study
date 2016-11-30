package Arrays;

//Отсортировать массив (пузырьком (Bubble), выбором (Select), вставками (Insert)) 
//Отсортировать массив (Quick, Merge, Shell, Heap)
public class SortArray {

	public static void BubleSort(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void SelectSort(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}

	public static void InsertSort(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] < array[j]) {
					while (j >= 0 && array[i] < array[j]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						j--;
					}
				}
			}
		}
	}
}
