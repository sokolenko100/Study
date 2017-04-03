package dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import view.Serial_Deserialization;
import bligic.Person;

public class save_open 
{
//	Serial_Deserialization
	public void save(String str,String type)//,JComboBox cb)
	{		
		String res ="";
//		File saveFile = new File("person.json");
//		JFileChooser chooser = new JFileChooser();
//		int rval = chooser.showSaveDialog(cb);
//		if (rval == JFileChooser.APPROVE_OPTION) 
//		{
	    	File saveFile = new File("person."+type);
			try
			{
				if(!saveFile.exists())
				{
					saveFile.createNewFile();
				}

				PrintWriter out = new PrintWriter(saveFile.getAbsoluteFile());

				try
				{
					out.print(res);
				} 
				finally 
				{
					out.close();
				}
			}
			catch(IOException e)
			{
				throw new RuntimeException(e);
			}
//		}
	}
	public ArrayList<Person>  open() throws IOException
	{		
		ArrayList<Person> pp = new ArrayList<Person>();
		File file = null;

		JFileChooser fileOpen = new JFileChooser();

		int result = fileOpen.showOpenDialog(null); 
		if (result == JFileChooser.APPROVE_OPTION)
		{
			file = fileOpen.getSelectedFile();
			String puth = file.getPath();

			if (file.exists()) 
			{
				try 
				{
					String s;
					StringBuilder sb = new StringBuilder();

					BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));

					while ((s = in.readLine()) != null)
					{
						sb.append(s);
						sb.append("\n");
					}
					
					if(puth.endsWith(".json"))
					{
						pp =Serial_Deserialization.fromJson_hend(sb.toString());
					}
					else if(puth.endsWith(".xml"))
					{
						pp =Serial_Deserialization.fromXML_hend(sb.toString());
					}
					else if(puth.endsWith(".yaml"))
					{
						pp =Serial_Deserialization.fromYAML_hend(sb.toString());
					}
					else if(puth.endsWith(".csv"))
					{
						pp =Serial_Deserialization.fromCSV_hend(sb.toString());
					}
				} catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		}
		return pp;
	}
}
