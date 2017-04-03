package Paint;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class PFrame extends JFrame
{
	PCommand cmd= null;
	PPanelDraw panelDraw = null;
	PButtonPanel buttonPanel = null;
	public PFrame() 
	{
		this.setBounds(200, 100, 750, 450);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		cmd  = new PCommand();
		panelDraw = new PPanelDraw(cmd, this);
		buttonPanel = new PButtonPanel(cmd, this);
		this.setVisible(true);
	}
}
