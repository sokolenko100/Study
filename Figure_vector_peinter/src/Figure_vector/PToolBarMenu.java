package Figure_vector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
	
		

		JButton btn_load = new JButton("Open");
		btn_load.setBounds( 1,1, 50, 35);
		btn_load.addActionListener(cmd.actionOpen);
		this.add(btn_load);
		
		JLabel labla_save= new JLabel("Save As");
		labla_save.setBounds( 52,1, 50, 35);
		this.add(labla_save);
		
		
		JComboBox formats = new JComboBox(cmd.actionSave.getFormats());
		formats.setBounds( 100,1, 50, 35);
		formats.addActionListener(cmd.actionSave);
		this.add(formats);
		
		// add Color 
		this.addSeparator();

		JButton btn_ColorChooser= new JButton("ColorChooser");
		btn_ColorChooser.setBounds( 153,1, 50, 35);
		btn_ColorChooser.addActionListener(cmd.aColor);

		// add Width 
		this.addSeparator();
		JButton btn_Line_W_1 = new JButton("Width_2");
		btn_Line_W_1.setBounds( 206,1, 50, 35);
		btn_Line_W_1.addActionListener(cmd.aLine);
		
		JButton btn_Line_W_2= new JButton("Width_4");
		btn_Line_W_2.setBounds( 259,1, 50, 35);
		btn_Line_W_2.addActionListener(cmd.aLine);
		
		JButton btn_Line_W_3 = new JButton("Width_6");
		btn_Line_W_3.setBounds( 312,1, 50, 35);
		btn_Line_W_3.addActionListener(cmd.aLine);
		
		this.add(btn_ColorChooser);
		this.add(btn_Line_W_1);
		this.add(btn_Line_W_2);
		this.add(btn_Line_W_3);
		
		
	
		frame.add(this,BorderLayout.NORTH);
	}
}
