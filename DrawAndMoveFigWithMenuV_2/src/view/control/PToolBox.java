package view.control;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import command.PCommand;



public class PToolBox extends JPanel
{
	public PToolBox(PCommand cmd)
	{
		this.setPreferredSize(new Dimension(200,200));
		this.setLayout(null);
		this.setVisible(true);

		JButton btnColor = new JButton("ColorChooser");
		btnColor.setBounds( 50, 40, 100, 50);
		btnColor.addActionListener(cmd.colorListener);
		btnColor.setFocusable(false);
		this.add(btnColor);
		
		
		JButton btn_Width = new JButton("Width");
		btn_Width.setBounds(50,100, 100, 50);
		btn_Width.addActionListener(cmd.widthListener);
		btn_Width.setFocusable(false);
		this.add(btn_Width);
		
		
		JButton btn_Line = new JButton("Line");
		btn_Line.setBounds( 50, 200, 100, 50);
		btn_Line.addActionListener(cmd.typeListener);
		btn_Line.setFocusable(false);
		this.add(btn_Line);
		
		JButton btn_rect = new JButton("Rect");
		btn_rect.setBounds( 50,260, 100, 50);
		btn_rect.addActionListener(cmd.typeListener);
		btn_rect.setFocusable(false);
		this.add(btn_rect);
		
		JButton btn_rectOval = new JButton("RoundRect");
		btn_rectOval.setBounds( 50, 320, 100, 50);
		btn_rectOval.addActionListener(cmd.typeListener);
		btn_rectOval.setFocusable(false);
		this.add(btn_rectOval);
		
		JButton btn_oval = new JButton("Oval");
		btn_oval.setBounds( 50, 380, 100, 50);
		btn_oval.addActionListener(cmd.typeListener);
		btn_oval.setFocusable(false);
		this.add(btn_oval);
		
		
	}
}
