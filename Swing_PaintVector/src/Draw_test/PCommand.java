package Draw_test;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PCommand
{
	PData data = null;
	ActionColor aColor = null;
	ActionWidthLine aLine = null;
	Color c= null;
	public PCommand()
	{
		data= new PData();
		aColor= new ActionColor();
		aLine = new ActionWidthLine();
	}
	
  public class ActionColor implements ActionListener 
  {

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("ColorChooser"))
		{
			
		data.SetIntColor();
		}
	}
	}
  public class ActionWidthLine  implements ActionListener 
  {
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Width_2")) 
		{
			data.SetWidth("1");
		}
		if (e.getActionCommand().equals("Width_4"))
		{
			data.SetWidth("2");
		}
		if (e.getActionCommand().equals("Width_6")) 
		{
			data.SetWidth("3");
		}
	}
  }
}
