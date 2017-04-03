package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
public class PFrame extends JFrame
{
	PButtonPanel pButtonPanel = null;
	PPanelTable pPanel=null; 
	PersonDM personDM = null;
	public PFrame() 
	{
		this.setBounds(200, 100, 800, 550);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		personDM = new PersonDM();
		pButtonPanel=new PButtonPanel(this,personDM);
		pPanel= new	PPanelTable(this,personDM);
		this.setVisible(true);
		
	}
}
