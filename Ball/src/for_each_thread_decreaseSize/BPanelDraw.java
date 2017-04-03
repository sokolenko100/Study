package for_each_thread_decreaseSize;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BPanelDraw extends JPanel implements  MouseListener, MouseMotionListener
{
	private int x =0;
	private int y =0;
	private int x2 =0;
	private int y2 =0;
	int id =0;
	public BPanelDraw( BFrame frame) 
	{
		setPreferredSize(new Dimension(frame.getHeight()-120, frame.getWidth()-150));
		frame.add(this,BorderLayout.CENTER);	
		addMouseListener(this);
		addMouseMotionListener(this);
		setLayout(null);
		setBackground(Color.WHITE);

		setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
	}	

	@Override
	public void mousePressed(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
		Ball p  = new Ball(x, y, 30, 30,Color.BLACK, 5,this,id++);
		this.add(p);
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e){}
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
