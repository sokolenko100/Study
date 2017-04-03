package Draw_test;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PButtonPanel  extends JPanel
{
	public PButtonPanel(PCommand cmd,PFrame frame)
	{
		this.setPreferredSize(new Dimension(100,200));
		this.setLayout(null);
		this.setVisible(true);
		
		JButton btn1 = new JButton("ColorChooser");
		btn1.setBounds( 0, 40, 100, 50);
		btn1.addActionListener(cmd.aColor);
		this.add(btn1);
		JButton btn4 = new JButton("Width_2");
		btn4.setBounds( 0,100, 100, 50);
		btn4.addActionListener(cmd.aLine);
		this.add(btn4);
		JButton btn5 = new JButton("Width_4");
		btn5.setBounds( 0, 160, 100, 50);
		btn5.addActionListener(cmd.aLine);
		this.add(btn5);
		JButton btn6 = new JButton("Width_6");
		btn6.setBounds( 0, 220, 100, 50);
		btn6.addActionListener(cmd.aLine);
		this.add(btn6);
		
		frame.add(this,BorderLayout.EAST);
	}

}
