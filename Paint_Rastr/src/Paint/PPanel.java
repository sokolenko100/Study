package Paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PPanel extends JPanel implements  MouseListener, MouseMotionListener
{
	private int x =0;
	private int y =0;
	BufferedImage bi=null;
	Graphics2D gg = null;
	PCommand cmd=null;
	public PPanel(PCommand cmd, PFrame frame) 
	{
		bi = new BufferedImage(700, 650, BufferedImage.TYPE_INT_RGB);
		bi.getGraphics().fillRect(0, 0, 700, 650); // Рисование белого прямогуголника поверх BufferedImage 
		setPreferredSize(new Dimension(700, 650));
		frame.add(this);
		this.cmd = cmd;
		cmd.pp=this;
		this.setBackground(Color.green);
    	addMouseListener(this);
    	addMouseMotionListener(this);
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D graf2D= (Graphics2D)g;
		graf2D.drawImage(bi,0,0, null);
	}
	
	private void Draw(MouseEvent arg0)
	{
		gg = (Graphics2D)bi.getGraphics();
		gg.setColor(cmd.data.newColor);
		gg.setStroke(new BasicStroke(cmd.data.sWidth()));
		gg.drawLine(x,y,arg0.getX(),arg0.getY());
		x=arg0.getX();
		y=arg0.getY();
	}
	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		Draw(arg0);
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		Draw(arg0);
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent arg0) 
	{
		x=arg0.getX();
		y=arg0.getY();
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

}
