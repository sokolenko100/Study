package for_each_thread_decreaseSize;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;
public class Ball  extends JPanel
{
	ArrayList<Ball> pp= null;
	int id;
	int x;
	int y;
	int h;
	int w;
	Color color;
	int thickness;
	Random rnd = null;
	Integer hightGG;
	Integer widthGG;
	int pos_x= 0;
	int pos_y= 0;
	int zero = 0;
	int min_1 = -1;
	int speed=0;
	int dimensionsBall =0;
	private BallsThread bThread = null;

	Color colors[] = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED, 
			Color.CYAN, Color.DARK_GRAY, Color.ORANGE, Color.YELLOW, Color.RED};
	Timer timer= null;
	public Ball(int x, int y, int h, int w, Color color, int thickness,BPanelDraw pDraw, int id) 
	{
		this.id = id;
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		rnd = new Random();
		dimensionsBall = 20 + rnd.nextInt(51 - 20); 
		speed = 2 + rnd.nextInt(13 - 2);
		pos_x=speed;
		pos_y= speed;
		int col = rnd.nextInt(9);
		this.color = colors[col];

		this.thickness = thickness;
		this.hightGG = pDraw.getHeight()-h;
		this.widthGG = pDraw.getWidth()-w;

		this.pp = pp;
		bThread = new BallsThread();
		bThread.start();
		timer=new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dimensionsBall+= (-1);
			}
		});
		timer.start();
		setDirection(); 
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
		gg.setStroke( new BasicStroke( thickness ) );
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
	private class BallsThread extends Thread
	{
		@Override
		public void run() 
		{
			while(true)
			{
				try {
					BallsThread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				move();
			}
		}
	}
}
