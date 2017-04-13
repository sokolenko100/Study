package view.control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import command.PCommand;
import view.FFrame;
import view.FMain;

public class PToolBar extends JToolBar
{
	PCommand pCommand = null;

	public PToolBar(PCommand pCommand,FFrame fFrame) 
	{
		this.setPreferredSize(new Dimension(800,38));

		this.setBackground(Color.cyan);
		this.setLayout(null);
		this.pCommand = pCommand;
		this.setVisible(true);
		this.SetFunction(this);
		fFrame.add(this,BorderLayout.NORTH);
	}
	public void SetFunction(PToolBar pToolBarMenu)
	{
		JButton loadButton = new JButton("Load");
		loadButton.setBounds(1, 1, 50, 35);
		loadButton.addActionListener(pCommand.actionLoadListener);
		loadButton.setFocusable(false);
		pToolBarMenu.add(loadButton);
		
		
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(52, 1, 50, 35);
		saveButton.addActionListener(pCommand.actionSaveListener);
		saveButton.setFocusable(false);
		pToolBarMenu.add(saveButton);

		
		JButton colorButton = new JButton("Color");
		colorButton.setBounds(151, 1, 50, 35);
		colorButton.addActionListener(pCommand.colorListener);
		colorButton.setFocusable(false);
		pToolBarMenu.add(colorButton);
		
		JButton widthButton = new JButton("Width");
		widthButton.setBounds(202, 1, 50, 35);
		widthButton.addActionListener(pCommand.widthListener);
		widthButton.setFocusable(false);
		pToolBarMenu.add(widthButton);
	}
}
