package Swing_Paint;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PButtonPanel  extends JPanel
{

	public PButtonPanel(PCommand cmd,PFrame frame)
	{
		setPreferredSize(new Dimension(200,400));
		this.setBackground(Color.blue);
		this.setLayout(null);
		JButton btn1 = new JButton("Red");
		btn1.setBounds( 50, 10, 100, 50);
		btn1.addActionListener(cmd.aColor);
		this.add(btn1);
		JButton btn2 = new JButton("Yellow");
		btn2.setBounds( 50, 60, 100, 50);
		btn2.addActionListener(cmd.aColor);
		this.add(btn2);
		JButton btn3 = new JButton("Green");
		btn3.setBounds( 50, 110, 100, 50);
		btn3.addActionListener(cmd.aColor);
		this.add(btn3);
		JButton btn4 = new JButton("Line_W_1");
		btn4.setBounds( 50, 170, 100, 50);
		btn4.addActionListener(cmd.aLine);
		this.add(btn4);
		JButton btn5 = new JButton("Line_W_2");
		btn5.setBounds( 50, 220, 100, 50);
		btn5.addActionListener(cmd.aLine);
		this.add(btn5);
		JButton btn6 = new JButton("Line_W_3");
		btn6.setBounds( 50,270, 100, 50);
		btn6.addActionListener(cmd.aLine);
		this.add(btn6);
		frame.add(this);
	}

}
