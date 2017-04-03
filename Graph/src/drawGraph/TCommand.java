package drawGraph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TCommand
{
	ActionDraw aDraw = null;
	TPanel panelDraw = null;
	JTextField text= null;
	public TCommand()
	{
		aDraw= new ActionDraw();
	}
	public void setTPanelObject(TPanel panelDraw)
	{
		this.panelDraw=panelDraw;
	}
	public class ActionDraw implements ActionListener 
	{
		public void drawTree()
		{
			panelDraw.repaint();
		}
		@Override
		public void actionPerformed(ActionEvent e)
		{

			if (e.getActionCommand().equals("Draw")) 
			{
				this.drawTree();
			}
		}
	}
}
