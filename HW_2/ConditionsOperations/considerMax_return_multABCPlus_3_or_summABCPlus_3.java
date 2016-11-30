package ConditionsOperations;

public class considerMax_return_multABCPlus_3_or_summABCPlus_3 {
	public static int showResaltTaskThird(int a, int b, int c) {
		int result = 0;
		int three = 3;
		int multABC = a * b * c;
		int summABC = a + b + c;
		if (multABC > summABC) {
			result = multABC + three;
		} else {
			result = summABC + three;
		}
		return result;
	}
}