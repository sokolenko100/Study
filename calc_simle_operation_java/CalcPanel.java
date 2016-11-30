package calc_simle_operation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcPanel extends JPanel {

	private String _firstNumbString = "";
	private String _secondNumbString = "";
	private Character _operation = ' ';

	public CalcPanel() {
		// setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setLayout(null);
		JTextField resultTextBox = new JTextField();
		resultTextBox.setBounds(10, 20, 230, 50);
		resultTextBox.setEditable(false);
		this.add(resultTextBox);

		JButton btn_7 = new JButton("7");
		btn_7.setBounds(10, 80, 50, 40);

		btn_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_operation == ' ') {
					_firstNumbString += "7";
					resultTextBox.setText(_firstNumbString);
				} else {
					_secondNumbString += "7";
					resultTextBox.setText(_secondNumbString);
				}
			}
		});
		this.add(btn_7);

		JButton btn_8 = new JButton("8");
		btn_8.setBounds(70, 80, 50, 40);

		btn_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_operation == ' ') {
					_firstNumbString += "8";
					resultTextBox.setText(_firstNumbString);
				} else {
					_secondNumbString += "8";
					resultTextBox.setText(_secondNumbString);
				}
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_8);

		JButton btn_9 = new JButton("9");
		btn_9.setBounds(130, 80, 50, 40);

		btn_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_operation == ' ') {
					_firstNumbString += "9";
					resultTextBox.setText(_firstNumbString);
				} else {
					_secondNumbString += "9";
					resultTextBox.setText(_secondNumbString);
				}
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_9);

		JButton btn_Mult = new JButton("*");
		btn_Mult.setBounds(190, 80, 50, 40);

		btn_Mult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_operation = '*';
				resultTextBox.setText(Character.toString(_operation));
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_Mult);

		JButton btn_4 = new JButton("4");
		btn_4.setBounds(10, 130, 50, 40);

		btn_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_operation == ' ') {
					_firstNumbString += "4";
					resultTextBox.setText(_firstNumbString);
				} else {
					_secondNumbString += "4";
					resultTextBox.setText(_secondNumbString);
				}
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_4);

		JButton btn_5 = new JButton("5");
		btn_5.setBounds(70, 130, 50, 40);

		btn_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_operation == ' ') {
					_firstNumbString += "5";
					resultTextBox.setText(_firstNumbString);
				} else {
					_secondNumbString += "5";
					resultTextBox.setText(_secondNumbString);
				}
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_5);

		JButton btn_6 = new JButton("6");
		btn_6.setBounds(130, 130, 50, 40);

		btn_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_operation == ' ') {
					_firstNumbString += "6";
					resultTextBox.setText(_firstNumbString);
				} else {
					_secondNumbString += "6";
					resultTextBox.setText(_secondNumbString);
				}
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_6);

		JButton btn_Minus = new JButton("-");
		btn_Minus.setBounds(190, 130, 50, 40);

		btn_Minus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_operation = '-';
				resultTextBox.setText(Character.toString(_operation));
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_Minus);

		JButton btn_1 = new JButton("1");
		btn_1.setBounds(10, 180, 50, 40);

		btn_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_operation == ' ') {
					_firstNumbString += "1";
					resultTextBox.setText(_firstNumbString);
				} else {
					_secondNumbString += "1";
					resultTextBox.setText(_secondNumbString);
				}
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_1);

		JButton btn_2 = new JButton("2");
		btn_2.setBounds(70, 180, 50, 40);

		btn_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_operation == ' ') {
					_firstNumbString += "2";
					resultTextBox.setText(_firstNumbString);
				} else {
					_secondNumbString += "2";
					resultTextBox.setText(_secondNumbString);
				}
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_2);

		JButton btn_3 = new JButton("3");
		btn_3.setBounds(130, 180, 50, 40);

		btn_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_operation == ' ') {
					_firstNumbString += "3";
					resultTextBox.setText(_firstNumbString);
				} else {
					_secondNumbString += "3";
					resultTextBox.setText(_secondNumbString);
				}
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_3);

		JButton btn_Div = new JButton("/");
		btn_Div.setBounds(190, 180, 50, 40);

		btn_Div.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_operation = '/';
				resultTextBox.setText(Character.toString(_operation));
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_Div);

		JButton btn_0 = new JButton("0");
		btn_0.setBounds(10, 230, 50, 40);

		btn_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_operation == ' ') {
					_firstNumbString += "0";
					resultTextBox.setText(_firstNumbString);
				} else {
					_secondNumbString += "0";
					resultTextBox.setText(_secondNumbString);
				}
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_0);

		JButton btn_Plus = new JButton("+");
		btn_Plus.setBounds(70, 230, 110, 40);

		btn_Plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_operation = '+';
				resultTextBox.setText(Character.toString(_operation));
				// JOptionPane.showMessageDialog(null, resaltTextBox.getText());
			}
		});
		this.add(btn_Plus);

		JButton btn_Equel = new JButton("=");
		btn_Equel.setBounds(190, 230, 50, 40);

		btn_Equel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				int firstNumb = 0;
				int secondNumb = 0;
				resultTextBox.setText("firstNumb do not valid");
				firstNumb = Integer.parseInt(_firstNumbString);
				secondNumb = Integer.parseInt(_secondNumbString);
				result = calc(firstNumb, secondNumb, _operation);
				resultTextBox.setText(Integer.toString(result));
				_firstNumbString = "";
				_secondNumbString = "";
				_operation = ' ';
			}
		});
		this.add(btn_Equel);

		setVisible(true);
	}

	private static Boolean doMatch(String word) {
		Boolean result = false;
		Pattern pattern = Pattern.compile("//d");
		Matcher matcher = pattern.matcher(word);
		result = matcher.matches();
		return result;
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