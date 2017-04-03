package eat_ball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
public class Ball  extends JPanel implements Runnable
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
	int dimensionsBall =0;
	Thread t =null;
	Color colors[] = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED, 
	Color.CYAN, Color.DARK_GRAY, Color.ORANGE, Color.YELLOW, Color.RED};
	BPanelDraw pDraw=null;
	public Ball(int x, int y,BPanelDraw pDraw, int id,	ArrayList<Ball> pp) 
	{
		this.id = id;
		this.x = x;
		this.y = y;
		this.hightGG = pDraw.getHeight();
		this.widthGG = pDraw.getWidth()-100;
		this.pDraw =pDraw;
		rnd = new Random();

		this.setDimensions();
		this.setSpeed();
		this.setColor();

		this.pp = pp;
		startThread();
		setDirection();
	}
	public void startThread()
	{
		t = new Thread(this);
		t.start();
	}
	public void setColor()
	{
		int col = rnd.nextInt(9);
		this.color = colors[col];
	}
	public void setDimensions()
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
	public void EatBall()
	{
		for (Ball b : pp)
				{
					if(id !=b.id)
					{
						if(x==b.x)//||b.x==x+30)
						{
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							pos_x*=min_1;
						}
						if(y==b.y)//||b.y==y+30)
						{
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							pos_y*=min_1;
						}
					}
				}

	}
	public void aPerformed2() 
	{
		//EatBall();
		if(x>=hightGG||x<=zero)
		{
			if(x>=hightGG)
			{
				x=hightGG;	
			}
			pos_x*=min_1;
		}
		if(y>=widthGG||y<=zero)
		{
			if(y>=widthGG)
			{
				y=widthGG;	
			}
			pos_y*=min_1;
		}
		x +=pos_x;
		y +=pos_y;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			move();
			for (Ball b2 : pp)
			{
				if( this != b2)
				{
					if(this.checkBall(b2))
					{
						this.eat(b2);
					}
				}
			}
		}
	}
	public boolean checkBall(Ball b)
	{
		int r1 = dimensionsBall/2;
		int r2 = b.dimensionsBall/2;
		int bx1 = x + r1;
		int by1 = y + r1;
		int bx2 = b.x + r2;
		int by2 = b.y + r2;
		return ( (Math.abs(r1 + r2)) > (Math.abs(bx1 - bx2) + Math.abs(by1 - by2) )) ? true : false;
	}
	
	public void eat(Ball b)
	{
		if( dimensionsBall > b.dimensionsBall)
		{
			dimensionsBall += b.dimensionsBall;
			b.kill();
		}
	}
	public void kill()
	{
		this.x=0;
		this.y=0;
		this.dimensionsBall=0;
	}
}
