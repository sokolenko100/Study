package Function;

//import java.math.*;

public class SearchDistanceBetwinTwoPoins {
	// AB = √(xb - xa)2 + (yb - ya)2 + (zb - za)2
	public static int DistanceBetwinTwoPoins(int x0, int y0, int x1, int y1,
			int z0, int z1) {
		int result = 0;
		result = SqrtMethod(MathPow(x1 - x0) + MathPow(y1 - y0)
				+ MathPow(z1 - z0));
		return result;
	}

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

	public static int MathPow(int x) {
		int rezult = 0;
		if (x != 0) {
			rezult = x *= x;
		}
		return rezult;
	}
}
