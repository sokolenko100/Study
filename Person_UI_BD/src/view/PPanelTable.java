package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PPanelTable extends JPanel
{
	JTextField id =null;
	JTextField fname =null;
	JTextField lname =null;
	JTextField age=null;
	JTable tb=null;
	public PPanelTable(PFrame pFrame,PersonDM personDM)
	{
		this.setPreferredSize(new Dimension(650,450));
		this.setLayout(null);
		
		id = new JTextField();
		id.setBounds( 10, 10, 150, 30);
		this.add(id);
		
		personDM.id=this.id;
		
		fname = new JTextField();
		fname.setBounds( 165, 10, 150, 30);
		this.add(fname);
		
		personDM.fname=this.fname;
		
		lname = new JTextField();
		lname.setBounds( 325,  10, 150, 30);
		this.add(lname);
		
		personDM.lname=this.lname;
		
		age = new JTextField();
		age.setBounds( 485, 10, 150, 30);
		this.add(age);
		
		personDM.age=this.age;
		
		tb = new JTable(personDM);
		JScrollPane pane = new JScrollPane(tb);
		pane.setBounds( 0,50, 650, 450);
		this.add(pane);
		
		pFrame.add(this,BorderLayout.CENTER);
	}
}
