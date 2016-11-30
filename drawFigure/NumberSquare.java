package drawFigure;

public class NumberSquare {

	public static void main(String[] args) {
	//	conclusionForm_123_horizontal();
	//	conclusionForm_321_horizontal();
		conclusionForm_123_vertical();
		conclusionForm_321_vertical();
	}

	public static void conclusionForm_123_horizontal() 
	{
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void conclusionForm_321_horizontal() {
		for (int i = 7; i >0; i--) {
			for (int j = 0; j < 7; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void conclusionForm_123_vertical() {
		for (int i = 1; i <=7; i++) {
			for (int j = 1; j <=7; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void conclusionForm_321_vertical() {
		for (int i = 0; i < 7; i++) {
			for (int j = 7; j >0; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();
	}
}
