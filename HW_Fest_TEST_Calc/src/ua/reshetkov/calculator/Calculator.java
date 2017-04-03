package ua.reshetkov.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new MyFrame() ;
		
	}
}


class MyFrame extends JFrame {
	
MyFrame() {
	
	setTitle("My Test") ;
	setBounds(200, 200, 270, 400);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	add (new MyPanel());
	setVisible(true);
}
}	


class MyPanel extends JPanel {
	
	int a, b ;
	String operator = "";
	String inputDisplay = "";
	
	MyPanel () {
		setLayout(null);

//		final JTextField display = new JTextField ();
//		display.setBounds(10, 10, 200, 20);
//		display.setText("0");
//		add(display);

		final JLabel display = new JLabel ();
		display.setBounds(10, 30, 200, 20);
		display.setText("0");
		display.setName("displayLabel");
		add(display);


// =======================================================		
				JButton btnC = new JButton ("C") ;
				btnC.setBounds(200, 40, 50, 50);
				add(btnC);
				btnC.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) 
					{
			
					System.out.println("C") ;
					display.setText("0");
					inputDisplay = "" ;
					}
				});		
// =======================================================		
		JButton btn7 = new JButton ("7") ;
		btn7.setBounds(10, 100, 50, 50);
		add(btn7);
		btn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("7") ;
			display.setText(digitsIndication("7"));
			}
		});
// =======================================================
		JButton btn8 = new JButton ("8") ;
		btn8.setBounds(70, 100, 50, 50);
		add(btn8);
		btn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("8") ;
			display.setText(digitsIndication("8"));
			}
		});
// =======================================================
		JButton btn9 = new JButton ("9") ;
		btn9.setBounds(130, 100, 50, 50);
		add(btn9);
		btn9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("9") ;
			display.setText(digitsIndication("9"));
			}
		});
// =======================================================
		JButton btn4 = new JButton ("4") ;
		btn4.setBounds(10, 160, 50, 50);
		add(btn4);
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("4") ;
			display.setText(digitsIndication("4"));
			}
		});		
// =======================================================		
		JButton btn5 = new JButton ("5") ;
		btn5.setBounds(70, 160, 50, 50);
		add(btn5);
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("5") ;
			display.setText(digitsIndication("5"));
			}
		});
// =======================================================
		JButton btn6 = new JButton ("6") ;
		btn6.setBounds(130, 160, 50, 50);
		add(btn6);
		btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("6") ;
			display.setText(digitsIndication("6"));
			}
		});
// =======================================================
		JButton btn0 = new JButton ("0") ;
		btn0.setBounds(10, 280, 50, 50);
		add(btn0);
		btn0.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) 
				{
		
				System.out.println("0") ;
				display.setText(digitsIndication("0"));
				}
				});
		
// =======================================================
		JButton btn1 = new JButton ("1") ;
		btn1.setBounds(10, 220, 50, 50);
		add(btn1);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("1") ;
			display.setText(digitsIndication("1"));
			}
		});
// =======================================================
		JButton btn2 = new JButton ("2") ;
		btn2.setBounds(70, 220, 50, 50);
		add(btn2);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("2") ;
			display.setText(digitsIndication("2"));
			}
		});
// =======================================================
		JButton btn3 = new JButton ("3") ;
		btn3.setBounds(130, 220, 50, 50);
		add(btn3);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("3") ;
			display.setText(digitsIndication("3"));
			}
		});
// =======================================================		
		JButton btnEQ = new JButton ("=") ;
		btnEQ.setBounds(70, 280, 110, 50);
		add(btnEQ);
		btnEQ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("=") ;
			display.setText(operatorEQ());
			}
		});
// =======================================================		
		JButton btnPlus = new JButton ("+") ;
		btnPlus.setBounds(200, 100, 50, 50);
		add(btnPlus);
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("+") ;
			operatorPress("+");
			}
		});
// =======================================================
		JButton btnMinus = new JButton ("-") ;
		btnMinus.setBounds(200, 160, 50, 50);
		add(btnMinus);
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("-") ;
			operatorPress("-");
			}
		});
// =======================================================
		JButton btnMul = new JButton ("*") ;
		btnMul.setBounds(200, 220, 50, 50);
		add(btnMul);
		btnMul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("*") ;
			operatorPress("*");
			}
		});
// =======================================================	
		JButton btnDiv = new JButton ("/") ;
		btnDiv.setBounds(200, 280, 50, 50);
		add(btnDiv);
		btnDiv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
			System.out.println("/") ;
			operatorPress("/");
			}
		});
// =======================================================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	} 
	
	
	String digitsIndication (String digit) {
		
		inputDisplay = inputDisplay + digit ;
		
		return inputDisplay ;
				}
	
	void operatorPress (String op) {
		if ( ! inputDisplay.equals("") )
		{
		a = Integer.valueOf(inputDisplay);
		inputDisplay = "" ;
		}
		operator = op ;
				}	

	String operatorEQ () {
	
		b = Integer.valueOf(inputDisplay);

		
		if (operator.equals("+")) a = a+b;
		if (operator.equals("-")) a = a-b;
		if (operator.equals("/")) a = a/b;
		if (operator.equals("*")) a = a*b;
		
		return Integer.toString(a) ;
	
		
	}
	
}

	



