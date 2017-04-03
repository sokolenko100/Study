package Client_X_O;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import logic_x_o_client.client;

public class Cell extends JButton implements ActionListener
{
	public int id;
	Boolean isPush= true;
	client client = null;
	String nameGamer = "";
	X_O_MainFrame mainFraim = null;
	public Cell(int id,client client,String nameGamer, X_O_MainFrame mainFraim)
	{
		this.mainFraim = mainFraim;
		this.nameGamer=nameGamer;
		this.client= client;
		this.id = id;
		this.setPreferredSize(new Dimension(200, 200));

		Font BigFontTR = new Font("TimesRoman", Font.BOLD, 200);
		this.setFont(BigFontTR);
		this.addActionListener(this);
		this.setVisible(true);
	}
	public void set_X()
	{
		this.setText("X");
	}
	public void set_O()
	{
		this.setText("O");
	}
	public void setTextButt(String type)
	{
		if(type.toLowerCase().equals("x"))
		{
			this.set_X();
		}
		else
		{
			this.set_O();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.setTextButt(X_O_MainFrame.type);
		this.visible(false);
		String str =X_O_MainFrame.push+":"+ nameGamer+":"+this.id+":"+X_O_MainFrame.type;
		mainFraim.unvisible();
		client.query.add(str);
		System.out.println("Sent push");
	}
	public void visible(Boolean isPush)
	{
		this.setEnabled(isPush);
	}

}