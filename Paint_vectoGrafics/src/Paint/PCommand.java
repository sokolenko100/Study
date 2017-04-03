package Paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PCommand
{
	PData data = null;
	ActionColor aColor = null;
	ActionWidthLine aLine = null;
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
		if (e.getActionCommand().equals("Red")) {
			data.SetIntColor("red");
		}
		if (e.getActionCommand().equals("Yellow")) {
			data.SetIntColor("yellow");
		}
		if (e.getActionCommand().equals("Green")) {
			data.SetIntColor("green");
		}
	}
	}
  public class ActionWidthLine  implements ActionListener 
  {
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Line_W_1")) 
		{
			data.SetWidth("1");
		}
		if (e.getActionCommand().equals("Line_W_2"))
		{
			data.SetWidth("2");
		}
		if (e.getActionCommand().equals("Line_W_3")) 
		{
			data.SetWidth("3");
		}
	}
  }
}
