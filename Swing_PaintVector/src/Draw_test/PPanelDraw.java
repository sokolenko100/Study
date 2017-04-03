package Draw_test;

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
	ArrayList<PLine> pp = new ArrayList<PLine>();
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
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		for (PLine x : pp)
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
	public void mouseDragged(MouseEvent e)
	{
		PLine p = new PLine(x, y, e.getX(), e.getY(), cmd.data.newColor, cmd.data.sWidth());
			
		x = e.getX();
		y = e.getY();
						
		pp.add(p);
		repaint();
	}
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
	public void mouseReleased(MouseEvent arg0) 
	{}
	@Override
	public void mouseMoved(MouseEvent e) {}
}
