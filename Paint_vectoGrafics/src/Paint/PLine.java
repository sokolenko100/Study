package Paint;

import java.awt.Graphics2D;
public class PLine
{
	int x1;
	int y1;
	int x2;
	int y2;

	public PLine(int x1, int y1, int x2, int y2)
	{
		//super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	public void paint(Graphics2D gg) 
	{
		gg.drawLine(x1, y1, x2, y2);
	}
}
