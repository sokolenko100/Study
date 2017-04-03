package format;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Figure implements Serializable
{
	int x;
	int y;
	int w;
	int h;
	int col = 0;
	int type = 1;
	int th = 3;
	public Figure(int x, int y, int w, int h, Color color, int type,int th) 
	{
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.col = color.getRGB();
		this.type = type;
		this.th= th;
	}
	public void paint(Graphics2D gg) 
	{
		gg.setStroke( new BasicStroke( th ) );
		gg.setColor(new Color(col));
		switch (type)
		{
			case 0: gg.drawLine(x, y, x+w, y+h);break;
			case 1: gg.drawRect(x, y, w, h); break;
			case 2: gg.drawRoundRect(x, y, w, h, 50,50); break;
			case 3: gg.drawOval(x, y, w, h); break;
			case 4: break;
		}		
	}
}
