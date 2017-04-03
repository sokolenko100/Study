package MoveFigure;


import java.awt.BorderLayout;

import javax.swing.JFrame;


public class PFrame  extends JFrame
{
	public static void main(String [] arg)
	{
		new PFrame();
	}
	PdrawFigure pDawFigure = null;
	public PFrame() 
	{
		this.setBounds(300, 100, 700, 700);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		pDawFigure = new PdrawFigure(this);
		this.setVisible(true);
	}
}
