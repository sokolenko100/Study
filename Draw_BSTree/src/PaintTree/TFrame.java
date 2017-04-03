package PaintTree;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class TFrame extends JFrame
{
	TCommand cmd= null;
	TPanel panelDraw = null;
	TButtonPanel tbuttonPanel = null;
	public TFrame() 
	{
		this.setBounds(200, 100, 800, 650);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		cmd  = new TCommand();
		panelDraw = new TPanel(cmd, this);
		cmd.setTPanelObject(panelDraw);
		tbuttonPanel =  new TButtonPanel(cmd, this);
		this.setVisible(true);
	}
}
