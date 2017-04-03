package drawGraph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import drawGraph.graphLinked.Edge;
import drawGraph.graphLinked.Vertex;

public class TPanel extends JPanel implements  MouseListener,MouseMotionListener
{
	graphLinked graph = null;
	private int x =0;
	private int y =0;
	BufferedImage bi=null;
	Graphics2D gg = null;
	TCommand cmd=null;
	ArrayList<GOval> ovalArray = null;
	public TPanel(TCommand cmd, TFrame frame) 
	{
		bi = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		bi.getGraphics().fillRect(0, 0, 600, 600); // Рисование белого прямогуголника поверх BufferedImage 
		gg = (Graphics2D)bi.getGraphics();
		setPreferredSize(new Dimension(600, 600));
		setLayout(null);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.setBackground(Color.WHITE);
		frame.add(this,BorderLayout.WEST);
		this.cmd = cmd;
		graph= new graphLinked();
		ovalArray = new ArrayList<GOval>();
		graph.init();
		draw(gg);
		repaint();
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D graf2D= (Graphics2D)g;
		graf2D.drawImage(bi,0,0, null);
		for (GOval gOval : ovalArray)
		{
			gOval.paint(graf2D);
			for (GLine line : gOval.line)
			{
				line.drawLine(graf2D);
			}
		}
	}

	public void draw(Graphics2D gg)
	{
		Vertex v =graph.root;
		int x = 20;
		int y = 20;
		GOval ovalFrom= null;;
		while(v!= null)
		{
			if(!v.isVisit)
			{
				ovalFrom = new GOval(x, y, v.val);
				ovalArray.add(ovalFrom);
				v.isVisit=true;
				Edge e = v.root;
				while(e!= null)
				{
					x+=100;
					if(x+100>=600)
					{
						y+=100;
						x=20;
					}
					GOval ovalTo=null;
					if(e.link.isVisit==true)
					{
						for (GOval gOval : ovalArray) 
						{
							if(gOval.val==e.link.val)
							{
								ovalTo=gOval;
								break;
							}
						}
					}
					else
					{
						e.link.isVisit=true;
						ovalTo = new GOval(x, y, e.link.val);
					}
					
					GLine line = new GLine(ovalFrom, ovalTo, e.val);
					ovalFrom.line.add(line);
					e = e.next;
				}
			}
			if(x+100>=600)
			{
				y+=100;
				x=20;
			}
		    x+=100;
		    v= v.next;
		}
	}
	@Override
	public void mouseDragged(MouseEvent e)
	{
		int getX = e.getX()-25;
		int getY = e.getY()-25;
		if(tempOval!=null)
		{
			tempOval.setLocation(getX,getY);
		}
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e)
	{
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		
	}
	GOval tempOval = null;
	@Override
	public void mousePressed(MouseEvent e) 
	{
		int x = e.getX();
		int y = e.getY();
		for (GOval gOval : ovalArray) 
		{
			if(gOval.CheckPosition(x, y))
			{
				tempOval=gOval;
				break;
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
