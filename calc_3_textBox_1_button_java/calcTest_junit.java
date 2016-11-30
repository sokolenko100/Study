package calc_3_textBox_1_button;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class calcTest_junit {
	@Test
	public void testCalc_Plus() {
		int rez = CalcPanel.calc(5, 5, '+');
		assertEquals(10, rez);
	}

	@Test
	public void testCalc_Minus() {
		int rez = CalcPanel.calc(15, 5, '-');
		assertEquals(10, rez);
	}

	@Test
	public void testCalc_Mult() {
		int rez = CalcPanel.calc(5, 2, '*');
		assertEquals(10, rez);
	}

	@Test
	public void testCalc_Div() {
		int rez = CalcPanel.calc(50, 5, '/');
		assertEquals(10, rez);
	}
}
