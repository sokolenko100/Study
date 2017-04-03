package Draw_test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class PLine
{

	int x1;
	int y1;
	int x2;
	int y2;
	Color color;
	int width;
	

	public PLine(int x1, int y1, int x2, int y2, Color color, int width) 
	{
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.width = width;
	}
	public void paint(Graphics2D gg) 
	{
		gg.setStroke( new BasicStroke( width ) );
		gg.setColor(color);
		gg.drawLine(x1, y1, x2, y2);		
	}
}
