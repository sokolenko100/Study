package Figure_vector;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class PCommand
{
	PData data = null;
	ActionColor aColor = null;
	ActionWidthLine aLine = null;
	ActionSetFigure setFigure = null;
	ActionSave actionSave= null;
	ActionOpen actionOpen = null;
	Color c= null;
	public PCommand()
	{
		data= new PData();
		aColor= new ActionColor();
		aLine = new ActionWidthLine();
		setFigure= new ActionSetFigure();
		actionSave = new ActionSave();
		actionOpen = new ActionOpen();
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
	public class ActionSetFigure  implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getActionCommand().equals("Line")) 
			{
				data.setFigure(0);
			}
			if (e.getActionCommand().equals("Rectangle")) 
			{
				data.setFigure(1);
			}
			if (e.getActionCommand().equals("RoundRect"))
			{
				data.setFigure(2);
			}
			if (e.getActionCommand().equals("Oval"))
			{
				data.setFigure(3);
			}
		}
	}
	class ActionOpen implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			data.openFile();
		}
	}
	class ActionSave implements ActionListener
	{
		public String[] getFormats()
		{
			String[] formats ={"xml","yaml","json","csv"};
			return  formats;
		}

		public void actionPerformed(ActionEvent e)
		{
			JComboBox cb = (JComboBox)e.getSource();
			if (cb.getSelectedItem().equals("xml")) 
			{
				data.saveFile("xml",cb );
			}
			if (cb.getSelectedItem().equals("yaml")) 
			{
				data.saveFile("yaml",cb );
			}
			if (cb.getSelectedItem().equals("json")) 
			{
				data.saveFile("json",cb );
			}
			if (cb.getSelectedItem().equals("csv")) 
			{
				data.saveFile("csv",cb );
			}
		};
	}
}
