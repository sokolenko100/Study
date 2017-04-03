package Figure_vector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PPanelDraw extends JPanel implements  MouseListener, MouseMotionListener
{
	private int x =0;
	private int y =0;
	private int x2 =0;
	private int y2 =0;
	ArrayList<Figure> pp = new ArrayList<Figure>();

	PCommand cmd=null;
	public PPanelDraw(PCommand cmd, PFrame frame) 
	{
		setPreferredSize(new Dimension(600, 600));
		frame.add(this,BorderLayout.CENTER);	
		this.cmd=cmd;
		addMouseListener(this);
		addMouseMotionListener(this);
		setLayout(null);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		cmd.data.setPPanelDraw(this);
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		for (Figure x : pp)
		{
			x.paint(gg);
		}	
	}	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		Figure p = new  Figure( x,  y, e.getX()-x, e.getY()-y  , cmd.data.newColor,cmd.data.getTypeFigure(),cmd.data.sWidth()); 

		x = e.getX();
		y = e.getY();

		pp.add(p);
		
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e)
	{}
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{}

	@Override
	public void mouseExited(MouseEvent arg0)
	{}

	@Override
	public void mouseMoved(MouseEvent e) {}
}




