package Client_X_O;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic_x_o_client.client;

public class SelectPlaer extends JFrame 
{
	String selected= "";
	selectedAction selectAct = null;
	String  gamerName = null;
	client client = null;
	DefaultListModel listModel =null;
	JList< String > list= null;
	public SelectPlaer(X_O_MainFrame parent,String  gamerName,client client )
	{
		this.client = client;
		this.gamerName=gamerName;
		this.setBounds(0, 0, 400, 400);
		this.setResizable(false);
		this.setLayout(null);
		listModel = new DefaultListModel();
		selectAct = new selectedAction();
		list = new JList<String>(listModel);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(0, 0,400, 300);
		list.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if(!e.getValueIsAdjusting()) 
				{
					selected = 	list.getSelectedValue();
					System.out.println(selected);
				}
			}
		});
		this.add( list);
		JButton button = new JButton("SELECT");
		button.setBounds(0, 300, 400, 70);
		button.addActionListener(selectAct);
		this.add(button);
		this.setVisible(true);
	}
	public class selectedAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			selected = 	list.getSelectedValue();
			System.out.println("Select Player  "+selected );
			if(!selected.equals(""))
			{
				String quer = X_O_MainFrame.play+":"+gamerName+":"+selected;
				client.query.add(quer);
				selected="";
			}
		}
	}
}
