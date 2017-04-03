package drawGraph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class GOval
{
	ArrayList<GLine> line = null;
	int x;
	int y;
	final int radius=50;
	Color col = Color.black;
	int th = 3;
	String val = "";
	public GOval(int x, int y,String val) 
	{
		this.line =  new ArrayList<GLine>();
		this.val  = val;
		this.x    = x;
		this.y    = y;
	}
	public void  setLocation(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
	public void paint(Graphics2D gg) 
	{
		gg.setStroke( new BasicStroke( th ) );
		gg.drawOval(x, y, radius, radius);
		gg.drawString(val,x+(radius/4), y+30);
	}
	public Boolean CheckPosition(int posX, int posY)
	{
		Boolean result = false;
		if(((this.x<=posX)&&(posX<=this.x+radius))&&((this.y<=posY)&&(posY<=this.y+radius)))
		{
			result= true;
		}
		return result;
	}
}

