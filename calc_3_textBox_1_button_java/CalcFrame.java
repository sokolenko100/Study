package calc_3_textBox_1_button;

import java.awt.Dimension;

import javax.swing.JFrame;

public class CalcFrame extends JFrame {
	public CalcFrame() {
		setTitle("My Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 400, 230, 350);
		add(new CalcPanel());
		setVisible(true);
		setPreferredSize(new Dimension(400, 80));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
