package drawGraph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class GLine 
{
	GOval ovalFrom=null;
	GOval ovalTo=null;
	int x;
	int y;
	int x2;
	int y2;
	Color col = Color.black;
	int th = 3;
	String val= "";
	public GLine(GOval ovalFrom,GOval ovalTo,int val) 
	{
		this.ovalFrom = ovalFrom;
		this.ovalTo = ovalTo;
		this.val =Integer.toString(val);
	}
	public void  setLocationFrom(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
	public void  setLocationTo( int x2, int y2) 
	{
		this.x2= x2;
		this.y2 = y2;
	}
	public void drawLine(Graphics2D gg) 
	{
		this.x = ovalFrom.x+25;
		this.y = ovalFrom.y+25;
		this.x2 = ovalTo.x+25;
		this.y2 = ovalTo.y+25;
		gg.setStroke( new BasicStroke( th ) );
		gg.drawLine(x, y, x2, y2);
		gg.drawString(val, x2, y2);
	}
}
