package ball_repulsion;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class BFrame extends JFrame
{
	BPanelDraw pPanelDraw= null;
	public BFrame() 
	{
		this.setBounds(200, 0, 750, 720);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		pPanelDraw= new BPanelDraw( this);
		this.setVisible(true);
	}
}
