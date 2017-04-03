package PaintTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TCommand
{
	TPainter painter = null;
	ActionDraw aDraw = null;
	TPanel panelDraw = null;
	JTextField text= null;
	public TCommand()
	{
		painter= new TPainter();
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
			panelDraw.bi.getGraphics().fillRect(0, 0, 600, 600); // Рисование белого прямогуголника поверх BufferedImage 
			painter.draw(panelDraw.gg, panelDraw.getWidth()/2);
			panelDraw.repaint();
		}
		@Override
		public void actionPerformed(ActionEvent e)
		{

			if (e.getActionCommand().equals("Draw")) 
			{
				this.drawTree();
			}
			else if (e.getActionCommand().equals("Add"))
			{
				painter.addNodetoTree();
				this.drawTree();
			}
			else if (e.getActionCommand().equals("Size"))
			{
				painter.sizeTree();
				this.drawTree();
			}
			else if (e.getActionCommand().equals("Nodes"))
			{
				painter.nodesTree();
				this.drawTree();
			}
			else if (e.getActionCommand().equals("Leavs"))
			{
				painter.leavsTree();
				this.drawTree();
			}
			else if (e.getActionCommand().equals("Height"))
			{
				painter.heightTree();
				this.drawTree();
			}
			else if (e.getActionCommand().equals("Weight"))
			{
				painter.weightTree();
				this.drawTree();
			}
			else if (e.getActionCommand().equals("Revers"))
			{
				painter.reversTree();
				this.drawTree();
			}
			else if (e.getActionCommand().equals("Delete"))
			{
				painter.deletefromTree();
				this.drawTree();
			}
			else if (e.getActionCommand().equals("toString"))
			{
				painter.toStringTree();
				this.drawTree();
			}
		}
	}
}
