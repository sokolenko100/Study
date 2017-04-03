package Paint;

import java.awt.Color;

import javax.swing.JColorChooser;



public class PData 
{
	private   int  Width = 10;
	public Color newColor= Color.BLACK;
	public PData()
	{
	}
	public void SetIntColor()
	{
		newColor = JColorChooser.showDialog(null, "ColorChooser", null);
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

}
