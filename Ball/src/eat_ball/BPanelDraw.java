package eat_ball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BPanelDraw extends JPanel implements  MouseListener
{
	private int x =0;
	private int y =0;
	private int x2 =0;
	private int y2 =0;
	int id =0;
	ArrayList<Ball> pp = new ArrayList<Ball>();
	BPanelDraw pDraw = null;
	public BPanelDraw( BFrame frame) 
	{
		setPreferredSize(new Dimension(frame.getHeight()-120, frame.getWidth()-150));
		frame.add(this,BorderLayout.CENTER);	
		addMouseListener(this);
		setLayout(null);
		setBackground(Color.WHITE);
		pDraw = this;
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
		Ball p  = new Ball(x, y,this,id++,pp);
		this.add(p);
		pp.add(p);
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
}
