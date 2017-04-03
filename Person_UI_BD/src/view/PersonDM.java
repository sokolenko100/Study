package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import bligic.Person;
import dal.PersonDAO;
import dal.PersonDAO_JSON_Auto;
import dal.PersonDAO_Mock;

public class PersonDM extends AbstractTableModel implements ActionListener
{
	JTextField id =null;
	JTextField fname =null;
	JTextField lname =null;
	JTextField age=null;
	PersonDAO pd=null;
	ArrayList<Person> pp= null;
	ActionChosePersonDAO aChosePerson = null;
	SelectedDB selectedDB=null;
	PersonDAO_JSON_Auto personDAO_Gson_Avto = null;
//	ActionSave actionSave = null;
	ActionOpen actionOpen = null;
	public PersonDM()
	{
		aChosePerson = new ActionChosePersonDAO();
		pd = new  PersonDAO_Mock();
		pp =new ArrayList<Person>();
		selectedDB = new SelectedDB();
		personDAO_Gson_Avto = new PersonDAO_JSON_Auto();
//		actionSave = new ActionSave();
		actionOpen = new ActionOpen();
	}

	@Override
	public int getColumnCount()
	{
		return 4;
	}

	@Override
	public int getRowCount() 
	{
		return pp.size();
	}

	@Override
	public Object getValueAt(int row, int column)
	{
		Person p = pp.get(row);
		Object  result = null;
		switch (column) 
		{
		case 0:result=p.id;break;
		case 1:result=p.fname;break;
		case 2:result=p.lname;break;
		case 3:result=p.age;break;
		}

		return result;
	}
	@Override
	public String getColumnName(int column) 
	{
		String [] str ={"id","Name","SerName","Age"};
		return str[column];
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Read"))
		{
			pp = pd.read();
			this.fireTableDataChanged();
		}
		if (e.getActionCommand().equals("Create"))
		{
			Person p =setPerson();
			if (p!=null)
			{
				pd.create(p);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pp = pd.read();
			}

			System.out.println("Create");
			this.fireTableDataChanged();
		}
		if (e.getActionCommand().equals("Update"))
		{
			Person p =setPerson();
			if (p!=null)
			{
				pd.update(p);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pp = pd.read();
			}

			System.out.println("Update");
			this.fireTableDataChanged();
		}
		if (e.getActionCommand().equals("Delete"))
		{
			Person p =setPerson();
			if (p!=null)
			{
				pd.delete(p);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pp = pd.read();
			}
			System.out.println("Delete");
			this.fireTableDataChanged();
		}
	}
	private Person setPerson()
	{
		Person p = null;
		int id =Integer.parseInt( this.id.getText());
		String fname = this.fname.getText();
		String lname = this.lname.getText();
		int age=0;
		if (this.age.getText()=="") 
		{
			age=0;
		}
		else
		{
			age =Integer.parseInt( this.age.getText());
		}
		p= new Person(id,fname,lname, age);
		return p;
	}
	class ActionChosePersonDAO implements ActionListener
	{
		public String[] getFormats()
		{
			String[] formats = {"Mock","H2","MySQL","MsSQL", "MongoDB","YAML", "JSON", "CSV","NetClient",
		"XML"};
			return  formats;
		}
		public void actionPerformed(ActionEvent e) 
		{
			JComboBox cb = (JComboBox)e.getSource();
			if (cb.getSelectedItem().equals("Mock")) 
			{
				pd = selectedDB.getDB("Mock");
			}
			if (cb.getSelectedItem().equals("NetClient")) 
			{
				pd = selectedDB.getDB("NetClient");
			}
			if (cb.getSelectedItem().equals("H2")) 
			{
				pd = selectedDB.getDB("H2");
			}
			if (cb.getSelectedItem().equals("MySQL")) 
			{
				pd = selectedDB.getDB("MySQL");	     
			}
			if (cb.getSelectedItem().equals("YAML")) 
			{
				pd = selectedDB.getDB("YAML");	     
			}
			if (cb.getSelectedItem().equals("JSON")) 
			{
				pd = selectedDB.getDB("JSON");	     
			}
			if (cb.getSelectedItem().equals("CSV")) 
			{
				pd = selectedDB.getDB("CSV");	     
			}
			if (cb.getSelectedItem().equals("XML")) 
			{
				pd = selectedDB.getDB("XML");	     
			}
			if (cb.getSelectedItem().equals("MsSQL")) 
			{
				pd = selectedDB.getDB("MsSQL");	     
			}
			if (cb.getSelectedItem().equals("MongoDB")) 
			{
				pd = selectedDB.getDB("MongoDB");	     
			}
		};
	}
	class ActionOpen implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
		
		}
	}
//	public	class ActionSave implements ActionListener
//	{
//		public String[] getFormats()
//		{
//			String[] formats ={"xml","yaml","json","csv"};
//			return  formats;
//		}
//
//		public void actionPerformed(ActionEvent e)
//		{
//			JComboBox cb = (JComboBox)e.getSource();
//			if (cb.getSelectedItem().equals("xml")) 
//			{
//
//			}
//			if (cb.getSelectedItem().equals("yaml")) 
//			{
//			}
//			if (cb.getSelectedItem().equals("json")) 
//			{
//				//personDAO_Gson_Avto.toJson(pp,cb);
//			}
//			if (cb.getSelectedItem().equals("csv")) 
//			{
//			}
//		};
//	}
}
