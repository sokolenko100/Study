package test2;

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
	int x;
	int y;
	Color color= Color.BLACK;
	Random rnd = null;
	int hightGG;
	int widthGG; 
	public	int tempDX= -6;
	public	int tempDY =0;
	Boolean flag = false;
	public	int dx;
	public	int dy;
	int zero = 0;
	int dimensionsBall =30;
	Thread t =null;
	Color colors[] = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED, 
			Color.CYAN, Color.DARK_GRAY, Color.ORANGE, Color.YELLOW, Color.RED};
	BPanelDraw pDraw=null;
	public Ball(int x, int y,BPanelDraw pDraw,	ArrayList<Ball> pp) 
	{
		this.x = x;
		this.y = y;
		this.hightGG = pDraw.getHeight();
		this.widthGG = pDraw.getWidth()-100;
		//	this.pDraw =pDraw;
		rnd = new Random();

		//	this.setDimensions();
		//	this.setSpeed();
		//	this.setColor();

		this.pp = pp;
		//startThread();
		//	setDirection();
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
		dx =2 + rnd.nextInt(13 - 2);
		dy= 2 + rnd.nextInt(13 - 2);
		//	tempDX=dx;
		//tempDY=dy;
	}
	public void setDirection()
	{
		int dir_X = rnd.nextInt(2);
		int dir_Y = rnd.nextInt(2);
		if(dir_X==zero)
		{
			dx=-dx;
		}
		if(dir_Y==zero)
		{
			dy=-dy;
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
		for (Ball b2 : pp)
		{
			if( this != b2)
			{
				if(Ball.checkBall(this,b2))
				{
					if(flag&&b2.flag)
					{
						if(this.dx>=0)
						{
							this.dx =this.tempDX;
						}
						else if(this.dx<0)
						{
							this.dx =-this.tempDX;
						}
						if(this.dy>=0)
						{
							this.dy = this.tempDY;
						}
						else if(this.dy<0)
						{
							this.dy = - this.tempDY;
						}


						if(b2.dx>=0)
						{
							b2.dx =b2.tempDX;
						}
						else if(b2.dx<0)
						{
							b2.dx =-b2.tempDX;
						}
						if(b2.dy>=0)
						{
							b2.dy = b2.tempDY;
						}
						else if(b2.dy<0)
						{
							b2.dy = - b2.tempDY;
						}
						
						b2.x+=b2.dx;
						b2.y+=b2.dy;

						this.x +=this.dx;
						this.y +=this.dy;
						flag = false;
						b2.flag = false;
						return;
					}
					if(this.dx<0)
					{
						this.dx=-1;
					}
					else if(this.dx>0)
					{
						this.dx=1;
					}
					if(this.dy<0)
					{
						this.dy=-1;
					}
					else if(this.dy>0)
					{
						this.dy=1;
					}

					if(b2.dx<0)
					{
						b2.dx=-1;
					}
					else if(b2.dx>0)
					{
						b2.dx=1;
					}
					if(b2.dy<0)
					{
						b2.dy=-1;
					}
					else if(b2.dy>0)
					{
						b2.dy=1;
					}
					flag = true;
					b2.flag = true;
				}
			}
		}

		if(x>=hightGG||x<=zero)
		{
			if(x>=hightGG)
			{
				x=hightGG;	
			}
			if(x<=zero)
			{
				x=zero;	
			}
			this.dx=-dx;
		}
		if(y>=widthGG||y<=zero)
		{
			if(y>=widthGG)
			{
				y=widthGG;	
			}
			if(y<=zero)
			{
				y=zero;	
			}
			this.dy=-dy;
		}

		x +=dx;
		y +=dy;
	}
	public static boolean checkBall(Ball b,Ball b2)
	{
		int r1 = b.dimensionsBall/2;
		int r2 = b2.dimensionsBall/2;
		int bx1 = b.x+b.dx + r1;
		int by1 = b.y+b.dy + r1;
		int bx2 = b2.x +b2.dx+ r2;
		int by2 = b2.y+b2.dy + r2;
		return ( (Math.pow(r1 + r2, 2))>= (Math.pow(bx2 - bx1, 2) + Math.pow(by2 - by1, 2) )) ? true : false;
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
		}
	}

}
