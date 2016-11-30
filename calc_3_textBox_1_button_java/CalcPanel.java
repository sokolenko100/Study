package calc_3_textBox_1_button;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcPanel extends JPanel {

	public CalcPanel() {
		// setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setLayout(null);
		JTextField firstNumbTextBox = new JTextField();
		firstNumbTextBox.setBounds(10, 20, 200, 40);

		JLabel lableFirstNumb = new JLabel("");

		JTextField operationTextBox = new JTextField();
		operationTextBox.setBounds(10, 70, 200, 40);

		JTextField secondNumbTextBox = new JTextField();
		secondNumbTextBox.setBounds(10, 140, 200, 40);

		JTextField resaltTextBox = new JTextField();
		resaltTextBox.setBounds(10, 210, 200, 40);
		resaltTextBox.setEditable(false);
		JButton btn = new JButton("Click");
		btn.setBounds(10, 280, 200, 40);

		btn.addActionListener(new ActionListener() {
			int firstNumb = 0;
			int secondNumb = 0;
			char operation = ' ';

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				firstNumb = Integer.parseInt(firstNumbTextBox.getText());
				secondNumb = Integer.parseInt(secondNumbTextBox.getText());
				operation = operationTextBox.getText().charAt(0);
				result = calc(firstNumb, secondNumb, operation);
				resaltTextBox.setText(Integer.toString(result));
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(firstNumbTextBox, BorderLayout.NORTH);
		this.add(operationTextBox, BorderLayout.AFTER_LINE_ENDS);
		this.add(secondNumbTextBox);
		this.add(resaltTextBox);
		this.add(btn);
		setVisible(true);
	}

	public static int calc(int a, int b, char op) {
		int res = 0;

		if ((op == '+' || op == '-' || op == '*' || op == '/') && b != 0) {

			if (op == '+') {
				res = a + b;
			} else if (op == '-') {
				res = a - b;
			} else if (op == '*') {
				res = a * b;
			} else if (op == '/') {
				res = a / b;
			}
		} else {
			throw new IllegalArgumentException();
		}
		return res;
	}
}