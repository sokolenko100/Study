package calc_simle_operation;

import java.awt.Dimension;

import javax.swing.JFrame;

public class CalcFrame extends JFrame {
	public CalcFrame() {
		setTitle("My Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 400, 260, 310);
		add(new CalcPanel());
		setVisible(true);
		setPreferredSize(new Dimension(400, 80));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
