package Figure_vector;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PFrame extends JFrame
{
	PToolBarMenu pToolBarMenu= null;
	PMainMenuBar pMainMenuBar = null;
	PContecstMenu pContecstMenu=null;
	PButtonPanel pButtonPanel= null;
	PPanelDraw pPanelDraw= null;
	public PFrame() 
	{
		this.setBounds(200, 100, 750, 650);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		PCommand cmd = new PCommand();
		pToolBarMenu= new PToolBarMenu(cmd,this);
		pMainMenuBar = new PMainMenuBar(cmd);
		pPanelDraw= new PPanelDraw(cmd, this);
		pContecstMenu = new PContecstMenu(cmd,this,pPanelDraw);
		pButtonPanel = new PButtonPanel(cmd, this);
	
		this.setJMenuBar(pMainMenuBar);
		
		this.setVisible(true);
	}
}
