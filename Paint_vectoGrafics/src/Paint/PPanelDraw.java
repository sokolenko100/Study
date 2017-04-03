package Paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PPanelDraw extends JPanel implements  MouseListener, MouseMotionListener
{
	private int x =0;
	private int y =0;
	private int x2 =0;
	private int y2 =0;
	
	Graphics graf2D = null;
	PCommand cmd=null;
	public PPanelDraw(PCommand cmd, PFrame frame) 
	{
		setPreferredSize(new Dimension(500, 400));
		frame.add(this);
		this.cmd = cmd;
		this.setBackground(Color.white);
    	addMouseListener(this);
    	addMouseMotionListener(this);
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
	    graf2D= (Graphics2D)g;
		graf2D.setColor(cmd.data.SetColor());
	//	graf2D.setStroke(new BasicStroke(cmd.data.sWidth()));
		graf2D.drawLine(x,y,x2,y2);
	}
	

		public void mousePressed(MouseEvent e) 
	    {
	        x= e.getX();
	        y = e.getY();

	        graf2D = getGraphics();

	        x2 = x;
	        y2 = y;
	    }

	    public void mouseDragged(MouseEvent e) 
	    {
	        x = e.getX();
	        y = e.getY();

	        graf2D.drawLine(x, y, x2, y2);

	        x2 = x;
	        y2 = y;
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
	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
