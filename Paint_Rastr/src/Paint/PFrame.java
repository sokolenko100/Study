package Paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PFrame extends JFrame
{
	PToolBarMenu pToolBarMenu= null;
	PMainMenuBar pMainMenuBar = null;
	PContecstMenu pContecstMenu=null;
	PButtonPanel pButtonPanel= null;
	PPanel pPanel= null;
	public PFrame() 
	{
		this.setBounds(200, 100, 750, 650);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		PCommand cmd = new PCommand();
		pToolBarMenu= new PToolBarMenu(cmd,this);
		pMainMenuBar = new PMainMenuBar(cmd);
		pPanel= new PPanel(cmd, this);
		pContecstMenu = new PContecstMenu(cmd,this,pPanel);
		pButtonPanel = new PButtonPanel(cmd, this);
	
		this.setJMenuBar(pMainMenuBar);
		
		this.setVisible(true);
	}
}
