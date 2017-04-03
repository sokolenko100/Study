package Draw_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JToolBar;

public class PToolBarMenu extends JToolBar
{
	PMainMenuBar pContecstMenu=null;
	JMenu viewMenu =null;
	PCommand cmd = null;
	public	PToolBarMenu(PCommand cmd,PFrame frame)
	{

		this.setPreferredSize(new Dimension(750,38));

		this.setBackground(Color.cyan);
		this.setLayout(null);
		this.setVisible(true);
		this.cmd= cmd;
	
		JButton btn_load = new JButton("Load");
		btn_load.setBounds( 1,1, 50, 35);
	//	btn_load.addActionListener(cmd.aColor);
		
		
		
		JButton btn_save = new JButton("Save");
		btn_save.setBounds( 52,1, 50, 35);
	//	btn_save.addActionListener(cmd.aColor);
		this.add(btn_load);
		this.add(btn_save);
		
		// add Color 
		this.addSeparator();

		JButton btn_ColorChooser= new JButton("ColorChooser");
		btn_ColorChooser.setBounds( 104,1, 50, 35);
		btn_ColorChooser.addActionListener(cmd.aColor);

		// add Width 
		this.addSeparator();
		JButton btn_Line_W_1 = new JButton("Width_2");
		btn_Line_W_1.setBounds( 156,1, 50, 35);
		btn_Line_W_1.addActionListener(cmd.aLine);
		
		JButton btn_Line_W_2= new JButton("Width_4");
		btn_Line_W_2.setBounds( 208,1, 50, 35);
		btn_Line_W_2.addActionListener(cmd.aLine);
		
		JButton btn_Line_W_3 = new JButton("Width_6");
		btn_Line_W_3.setBounds( 260,1, 50, 35);
		btn_Line_W_3.addActionListener(cmd.aLine);
		
		this.add(btn_ColorChooser);
		this.add(btn_Line_W_1);
		this.add(btn_Line_W_2);
		this.add(btn_Line_W_3);

		
		
	
		frame.add(this,BorderLayout.NORTH);
	}
}
