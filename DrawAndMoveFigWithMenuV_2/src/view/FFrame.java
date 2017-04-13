package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import command.PCommand;
import view.control.PContextMenu;
import view.control.PMainMenu;
import view.control.PToolBar;
import view.control.PToolBox;

public class FFrame extends JFrame
{
	PMainMenu pMenu = null;
	PContextMenu pContextMenu= null;
	PCommand pCommand = null;
	FPanelDraw fPanelDraw=null;
	PToolBar pToolBarMenu= null;
	PToolBox pToolBox = null;
	
	public FFrame()
	{
		this.setLayout(new BorderLayout());
		this.setBounds(250, 50, 800, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fPanelDraw= new FPanelDraw( this );
		
		pCommand = new PCommand(fPanelDraw);
		
		pMenu = new PMainMenu(pCommand);
		pContextMenu = new  PContextMenu(pCommand);
		fPanelDraw.SetPContextMenuObject(pContextMenu);
		pToolBox = new PToolBox(pCommand);
		pToolBarMenu =  new PToolBar(pCommand, this);
		
		
		add(pToolBox,BorderLayout.WEST);
		
		this.setJMenuBar(pMenu);
		this.setVisible(true);
	}
}
