package drawGraph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TButtonPanel  extends JPanel
{
	JTextField text= null;
	public TButtonPanel(TCommand cmd,TFrame frame)
	{
		setPreferredSize(new Dimension(160,600));
		this.setBackground(Color.gray);
		this.setLayout(null);
		
		JButton btn_print = new JButton("Draw");
		btn_print.setBounds( 30,60, 100, 50);
		btn_print.addActionListener(cmd.aDraw);
		this.add(btn_print);
		frame.add(this,BorderLayout.EAST);
	}
}
