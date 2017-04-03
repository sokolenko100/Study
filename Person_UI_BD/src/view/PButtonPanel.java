package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PButtonPanel  extends JPanel
{
	public PButtonPanel(PFrame frame,PersonDM personDM)
	{
		this.setPreferredSize(new Dimension(150,200));
		this.setLayout(null);
		this.setVisible(true);
		
		JComboBox formats = new JComboBox(personDM.aChosePerson.getFormats());
		formats.setBounds( 3, 10, 150, 30);
		
		formats.addActionListener(personDM.aChosePerson);
		this.add(formats);
		
		JButton btn1 = new JButton("Create");
		btn1.setBounds( 25, 80, 100, 50);
		btn1.addActionListener(personDM);
		this.add(btn1);
		JButton btn4 = new JButton("Read");
		btn4.setBounds( 25,140, 100, 50);
		btn4.addActionListener(personDM);
		this.add(btn4);
		JButton btn5 = new JButton("Update");
		btn5.setBounds(25, 200, 100, 50);
		btn5.addActionListener(personDM);
		this.add(btn5);
		JButton btn6 = new JButton("Delete");
		btn6.setBounds( 25, 260, 100, 50);
		btn6.addActionListener(personDM);
		this.add(btn6);
	
		JButton btn_load = new JButton("Open");
		btn_load.setBounds( 25, 320, 100, 50);
		btn_load.addActionListener(personDM.actionOpen);
		this.add(btn_load);
		
//		JLabel labla_save= new JLabel("Save As");
//		labla_save.setBounds( 25,370, 50, 35);
//		this.add(labla_save);
//		
//		
//		JComboBox formatsToserial = new JComboBox(personDM.actionSave.getFormats());
//		formatsToserial.setBounds( 80,370, 50, 35);
//		formatsToserial.addActionListener(personDM.actionSave);
//		this.add(formatsToserial);
//		
		
		frame.add(this,BorderLayout.EAST);
	}

}
