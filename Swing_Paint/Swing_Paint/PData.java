package Swing_Paint;

import java.awt.Color;


public class PData 
{

	public static  int  argb ;//= 16711680;
	private   int  Width = 10;
	public PData()
	{
		argb=SetIntColor("green");
	}
	public int SetIntColor(String str)
	{
		int result =0;
		switch (str)
		{
		case "red": result = Color.red.getRGB();break;
		case "yellow": result = Color.yellow.getRGB();break;
		case "green": result = Color.green.getRGB();break;
		}
		argb=result;
		return result;
	}
	
	public int SetWidth(String str)
	{
		int result =0;
		switch (str)
		{
		case "1": result = 2;break;
		case "2": result = 4;break;
		case "3": result = 6;break;
		}
		Width=result;
		return result;
	}
	public int sWidth()
	{
		return Width;
	}
	public Color SetColor()
	{
		Color result = Color.black;
		result = new Color (argb);
		return result;
		/*	int alpha = (argb >> 24) & 0xff;
		int red = (argb >> 16) & 0xff;
		int green = (argb >>  8) & 0xff;
		int blue = (argb ) & 0xff;
		 */
	}
}
