package ball_test_repulsion;

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
	int dx= 0;
	int dy= 0;
	int tempDX= 1;
	int tempDY= 1;
	int zero = 0;
	int dimensionsBall =30;
	Thread t =null;
	Color colors[] = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED, 
	Color.CYAN, Color.DARK_GRAY, Color.ORANGE, Color.YELLOW, Color.RED};
	public Ball(int x, int y,	ArrayList<Ball> pp) 
	{
		this.x = x;
		this.y = y;
		this.hightGG = 700;
		this.widthGG = 650;
	//	this.pDraw =pDraw;
	//	rnd = new Random();

	//	this.setDimensions();
	//	this.setSpeed();
	//	this.setColor();

		this.pp = pp;
	//	startThread();
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
		dx = 2 + rnd.nextInt(13 - 2);
		dy= dx;
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
					if(this.dx == -1 ||this.dx == 1)
						{
							this.dx = this.tempDX;
						}
						
						if(this.dy == -1 ||this.dy == 1)
						{
							this.dy = this.tempDY;
						}
						if(b2.dx == -1 ||b2.dx == 1)
						{
							b2.dx = b2.tempDX;
						}
						
						if(b2.dy == -1 ||b2.dy == 1)
						{
							b2.dy = b2.tempDY;
						}
						if((this.dx != -1 ||this.dx != 1)&&(this.dy != -1 ||this.dy != 1)&&(b2.dx != -1 ||b2.dx != 1)&&(b2.dy != -1 ||b2.dy != 1))
						{
	
							
							int tempX= this.dx;
							int tempY= this.dy;
							this.dx=b2.dx;
							this.dy=b2.dy;
							b2.dx=tempX;
							b2.dy=tempY;
							b2.dx=-b2.dx;
							b2.dy=-b2.dy;
							b2.x+=b2.dx;
							b2.y+=b2.dy;
	
							this.x +=this.dx;
							this.y +=this.dy;
							return;
						}
						if(this.dx<0)
						{
							this.dx=-1;
						}
						else
						{
							this.dx=1;
						}
						if(this.dy<0)
						{
							this.dy=-1;
						}
						else
						{
							this.dy=1;
						}
						if(b2.dx<0)
						{
							b2.dx=-1;
						}
						else
						{
							b2.dx=1;
						}
						if(b2.dy<0)
						{
							b2.dy=-1;
						}
						else
						{
							b2.dy=1;
						}
	
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
	public static boolean checkB(Ball b,Ball b2)
	{
		int r1 = b.dimensionsBall/2;
		int r2 = b2.dimensionsBall/2;
		int bx1 = b.x + r1;
		int by1 = b.y + r1;
		int bx2 = b2.x + r2;
		int by2 = b2.y + r2;
		double distance = Math.pow(bx2 - bx1, 2) + Math.pow(by2 - by1, 2) ;
		double R2= Math.pow(r1 + r2, 2);
		return R2 ==distance ? true : false;
		//return ((Math.pow(r1 + r2, 2)) == (Math.pow(bx2 - bx1, 2) + Math.pow(by2 - by1, 2) )) ? true : false;
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