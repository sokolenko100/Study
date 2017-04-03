package PaintAVLTree;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TButtonPanel  extends JPanel
{
	JTextField text= null;
	public TButtonPanel(TCommand cmd,TFrame frame)
	{
		setPreferredSize(new Dimension(160,600));
		this.setBackground(Color.gray);
		this.setLayout(null);
		
		text = new JTextField("");
		text.setBounds( 1,10, 157, 30);
		
		this.add(text);
		
		cmd.painter.text=text;//set fild painter JTextField text
		
		JButton btn_print = new JButton("Draw");
		btn_print.setBounds( 30,60, 100, 50);
		btn_print.addActionListener(cmd.aDraw);
		
		
		JButton btn_add = new JButton("Add");
		btn_add.setBounds( 30,110, 100, 50);
		btn_add.addActionListener(cmd.aDraw);

		this.add(btn_add);

		JButton btn_size = new JButton("Size");
		btn_size.setBounds( 30,160, 100, 50);
		btn_size.addActionListener(cmd.aDraw);
		this.add(btn_size);
		
		JButton btn_nodes = new JButton("Nodes");
		btn_nodes.setBounds( 30,210, 100, 50);
		btn_nodes.addActionListener(cmd.aDraw);

		this.add(btn_nodes);
		
		JButton btn_Leavs = new JButton("Leavs");
		btn_Leavs.setBounds( 30,260, 100, 50);
		btn_Leavs.addActionListener(cmd.aDraw);

		this.add(btn_Leavs);
		
		JButton btn_Height = new JButton("Height");
		btn_Height.setBounds( 30,310, 100, 50);
		btn_Height.addActionListener(cmd.aDraw);

		this.add(btn_Height);
		
		JButton btn_Weight = new JButton("Weight");
		btn_Weight.setBounds( 30,360, 100, 50);
		btn_Weight.addActionListener(cmd.aDraw);

		this.add(btn_Weight);
		
		JButton btn_Revers = new JButton("Revers");
		btn_Revers.setBounds( 30,410, 100, 50);
		btn_Revers.addActionListener(cmd.aDraw);

		this.add(btn_Revers);
		
		JButton btn_Delete = new JButton("Delete");
		btn_Delete.setBounds( 30,460, 100, 50);
		btn_Delete.addActionListener(cmd.aDraw);

		this.add(btn_Delete);
		
		JButton btn_ToArray = new JButton("toString");
		btn_ToArray.setBounds(30,510, 100, 50);
		btn_ToArray.addActionListener(cmd.aDraw);

		this.add(btn_ToArray);
		
		
		this.add(btn_print);
		frame.add(this);
	}
}
