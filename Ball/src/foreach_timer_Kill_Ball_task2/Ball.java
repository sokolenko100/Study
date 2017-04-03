package foreach_timer_Kill_Ball_task2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
public class Ball  extends JPanel implements MouseListener
{
	ArrayList<Ball> pp= null;
	int id;
	int x;
	int y;
	Color color;
	Random rnd = null;
	int hightGG;
	int widthGG;
	int pos_x= 0;
	int pos_y= 0;
	int zero = 0;
	int min_1 = -1;
	int dimensionsBall =10;
	Color colors[] = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED, 
	Color.CYAN, Color.DARK_GRAY, Color.ORANGE, Color.YELLOW, Color.RED};
	BPanelDraw pDraw=null;
	public Ball(int x, int y,BPanelDraw pDraw, int id,	ArrayList<Ball> pp,Boolean demention) 
	{
		this.id = id;
		this.x = x;
		this.y = y;
		this.hightGG = pDraw.getHeight();
		this.widthGG = pDraw.getWidth()-100;
		this.pDraw =pDraw;
	
		rnd = new Random();

		this.setDimensions(demention);
		this.setSpeed();
		this.setColor();

		this.pp = pp;
		setDirection();
		addMouseListener(this);
	}
	public void setColor()
	{
		int col = rnd.nextInt(9);
		this.color = colors[col];
	}
	public void setDimensions(Boolean demention)
	{
		dimensionsBall = 20 + rnd.nextInt(51 - 20); 
	}
	public void setSpeed()
	{
		pos_x = 2 + rnd.nextInt(13 - 2);
		pos_y= pos_x;
	}
	public void setDirection()
	{
		int dir_X = rnd.nextInt(2);
		int dir_Y = rnd.nextInt(2);
		if(dir_X==zero)
		{
			pos_x=-pos_x;
		}
		if(dir_Y==zero)
		{
			pos_y=-pos_y;
		}
	}
	@Override
	public void paint(Graphics g) 
	{
		Graphics2D gg = (Graphics2D) g;
		gg.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
		gg.setColor(color);
		gg.fillOval(0,0, dimensionsBall, dimensionsBall);
	}
	public void move() 
	{
		aPerformed2();
		this.setBounds(x, y, dimensionsBall, dimensionsBall);
	}
	public void aPerformed2() 
	{
		if(x>=hightGG)
		{
			if(x>=hightGG)
			{
				x=hightGG;	
			}
			pos_x*=min_1;
		}
		if(x<=zero)
		{
			pos_x*=min_1;
		}
		if(y>=widthGG)
		{
			if(y>=widthGG)
			{
				y=widthGG;	
			}
			pos_y*=min_1;
		}
		if(y<=zero)
		{
			pos_y*=min_1;
		}
		x +=pos_x;
		y +=pos_y;
	}
	@Override
	public void mouseClicked(MouseEvent e)
	{

	}
	@Override
	public void mouseEntered(MouseEvent e)
	{

	}
	@Override
	public void mouseExited(MouseEvent e)
	{

	}
	public void kill()
	{
		this.x=0;
		this.y=0;
		this.dimensionsBall=0;
		
	}
	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			kill();
			pp.remove(this);
		}	    
		else if(e.getButton() == MouseEvent.BUTTON3)
		{
			pDraw.Create_8_Ball(x,y,this.dimensionsBall);
			this.kill();
			pp.remove(this);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
	}
}
