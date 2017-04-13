package view.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import command.PCommand;

public class PContextMenu extends JPopupMenu
{

	PCommand pCommand = null;
	public PContextMenu(PCommand pCommand) 
	{
		this.pCommand = pCommand;
		AddFileMenu(this);
		
		AddTypeMenu(this);
		
		AddColorMenu(this);
		
		AddWidthMenu(this);
		
	//	this.setVisible(true);
	}
	public void AddFileMenu(PContextMenu pMenu)
	{
		JMenu file = new JMenu("File");
		
		JMenuItem loadMenu = new JMenuItem("Load");
		loadMenu.addActionListener(pCommand.actionLoadListener);
		file.add(loadMenu);
		
		file.addSeparator();

		JMenuItem saveMenu = new JMenuItem("Save");
		saveMenu.addActionListener(pCommand.actionSaveListener);
		file.add(saveMenu);

		
		file.addSeparator();
		
		JMenuItem exitMenu = new JMenuItem("Exit");
		exitMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});

		file.add(exitMenu);

		pMenu.add(file);
	}
	
	public void AddTypeMenu(PContextMenu pMenu)
	{
		JMenu type = new JMenu("Type");
		type.setFocusable(false);
		JMenuItem line = new JMenuItem("Line");
		line.addActionListener(pCommand.typeListener);
		line.setFocusable(false);
		type.add(line);

		type.addSeparator();
		JMenuItem rect = new JMenuItem("Rect");
		rect.addActionListener(pCommand.typeListener);
		rect.setFocusable(false);
		type.add(rect);

		type.addSeparator();
		JMenuItem roundRect = new JMenuItem("RoundRect");
		roundRect.addActionListener(pCommand.typeListener);
		roundRect.setFocusable(false);
		type.add(roundRect);
		
		
		type.addSeparator();
		JMenuItem oval = new JMenuItem("Oval");
		oval.addActionListener(pCommand.typeListener);
		oval.setFocusable(false);
		type.add(oval);
		
		pMenu.add(type);
	}
	public void AddColorMenu(PContextMenu pMenu)
	{
		JMenu color = new JMenu("Color");
		color.setFocusable(false);
		JMenuItem clorChouser = new JMenuItem("ColorChouser");
		clorChouser.addActionListener(pCommand.colorListener);
		clorChouser.setFocusable(false);
		color.add(clorChouser);
		
		pMenu.add(color);
	}
	public void AddWidthMenu(PContextMenu pMenu)
	{
		JMenu width = new JMenu("Width");
		width.setFocusable(false);
		JMenuItem slaider = new JMenuItem("Slaider");
		slaider.addActionListener(pCommand.widthListener);
		slaider.setFocusable(false);
		width.add(slaider);
		
		pMenu.add(width);
	}
}
