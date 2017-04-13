package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import command.fio.FigureFact;
import view.FPanelDraw;

public class PCommand
{
	public ActionWidthListener widthListener = null;
	public ActionTypeListener typeListener = null;
	public ActionColorListener colorListener = null;
	
	public ActionSaveListener actionSaveListener = null;
	public ActionLoadListener actionLoadListener = null;
	
	public PData pdata = null;
	FPanelDraw fPanelDraw = null;
	
	public PCommand(FPanelDraw fPanelDraw)
	{
		this.fPanelDraw = fPanelDraw;
		
		pdata = new PData();
		widthListener = new ActionWidthListener();
		typeListener = new ActionTypeListener();
		colorListener = new ActionColorListener();
		actionSaveListener= new ActionSaveListener();
		actionLoadListener = new ActionLoadListener();
	}
	class ActionWidthListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			pdata.SetWidth();
		}
	}
	class ActionTypeListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand()=="Line")
			{
				pdata.SetType(1);
			}
			if(e.getActionCommand()=="Rect")
			{
				pdata.SetType(2);
			}
			if(e.getActionCommand()=="RoundRect")
			{
				pdata.SetType(3);
			}
			if(e.getActionCommand()=="Oval")
			{
				pdata.SetType(4);
			}
		}
	}

	class ActionColorListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			pdata.SetColor();
		}
	}
	public class ActionSaveListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser fileOpen = new JFileChooser();
			int result = fileOpen.showSaveDialog(null); 
			if (result == JFileChooser.APPROVE_OPTION)
			{
				FigureFact.getI(fileOpen.getSelectedFile()).save( fPanelDraw.getMemento() );				
			}
		}
	}
	class ActionLoadListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser fileOpen = new JFileChooser();
			int result = fileOpen.showOpenDialog(null); 
			if (result == JFileChooser.APPROVE_OPTION)
			{
				fPanelDraw.setMemento( FigureFact.getI(fileOpen.getSelectedFile()).load() );				
			}
		}
	}
}
