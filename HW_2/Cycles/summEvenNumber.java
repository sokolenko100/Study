package Cycles;

public class summEvenNumber {
	public static int[] SummAndCountEventNumberMethod() {
		int[] result = new int[2];
		int countNumber = 0;
		int summ = 0;
		for (int i = 1; i < 100; i++) {
			if (i % 2 == 0) {
				summ += i;
				countNumber++;
			}
		}
		result[0] = summ;
		result[1] = countNumber;
		return result;
	}
}
