package Paint;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class PCommand
{
	PData data = null;
	ActionColor aColor = null;
	ActionWidthLine aLine = null;
	ActionSave aSave =null;
	ActionLoad aLoad = null;
	PPanel pp = null;
	Color c= null;
	public PCommand()
	{
		data= new PData();
		aColor= new ActionColor();
		aLine = new ActionWidthLine();
		aSave = new ActionSave();
		aLoad = new ActionLoad();

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
	class ActionSave implements ActionListener
	{
		
		 /* Return the formats sorted alphabetically and in lower case */
	    public String[] getFormats() {
	        String[] formats = ImageIO.getWriterFormatNames();
	        TreeSet<String> formatSet = new TreeSet<String>();
	        for (String s : formats) {
	            formatSet.add(s.toLowerCase());
	        }
	        return  formatSet.toArray(new String[0]);
	    }
	 
	 
	     public void actionPerformed(ActionEvent e) {
	         JComboBox cb = (JComboBox)e.getSource();
	        if (cb.getActionCommand().equals("Formats")) 
	        {
	             /* Save the filtered image in the selected format.
	              * The selected item will be the name of the format to use
	              */
	             String format = (String)cb.getSelectedItem();
	             /* Use the format name to initialise the file suffix.
	              * Format names typically correspond to suffixes
	              */
	             File saveFile = new File("image."+format);
	             JFileChooser chooser = new JFileChooser();
	             chooser.setSelectedFile(saveFile);
	             int rval = chooser.showSaveDialog(cb);
	             if (rval == JFileChooser.APPROVE_OPTION) {
	                 saveFile = chooser.getSelectedFile();
	                 /* Write the filtered image in the selected format,
	                  * to the file chosen by the user.
	                  */
	                 try {
	                     ImageIO.write(pp.bi, format, saveFile);
	                 } catch (IOException ex) {
	                 }
	             }
	         }
	    };
	}

	class ActionLoad implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) 
				{
					pp.bi = ImageIO.read( chooser.getSelectedFile() );
					pp.repaint();
				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}
