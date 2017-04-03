package Figure_vector;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
public class PData 
{
	private   int  Width = 10;
	public Color newColor= Color.BLACK;
	private PPanelDraw pPanelDraw = null;
	Serial_Deserialization serDerserial= null;
	private int type=1;
	public PData()
	{
		serDerserial = new Serial_Deserialization();
	}
	public  void setPPanelDraw(PPanelDraw pPanelDraw)
	{
		this.pPanelDraw=pPanelDraw;
	}
	private void setFigures_and_repeint( ArrayList<Figure> figArray)
	{
		pPanelDraw.pp =figArray;
		pPanelDraw.repaint();
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
	public int setFigure(Integer val)
	{
		int result =0;
		result=val;
		type= val;
		return result;
	}
	public void openFile()
	{
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
					String s="";
					StringBuilder sb = new StringBuilder();

					BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
					try {

						while ((s = in.readLine()) != null) {
							sb.append(s);
							sb.append("\n");
						}
					} finally {
						in.close();
						if(puth.endsWith(".json"))
						{
							pPanelDraw.pp = serDerserial.fromJson(sb.toString());
						}
						if (puth.endsWith(".xml"))
						{
							pPanelDraw.pp = serDerserial.fromXML(sb.toString());
						}
						if (puth.endsWith(".csv"))
						{
							pPanelDraw.pp = serDerserial.fromCSV(sb.toString());
						}
						if (puth.endsWith(".yaml"))
						{
							pPanelDraw.pp = serDerserial.fromYAML(sb.toString());
						}
						pPanelDraw.repaint();
					}
				} catch(IOException e) {
					throw new RuntimeException(e);
				}
			} 
		}
	}
	public void saveFile(String type,JComboBox cb)
	{
		String text = "";
		File saveFile = new File("image."+type);
		JFileChooser chooser = new JFileChooser();
		chooser.setSelectedFile(saveFile);
		if (type.equals("xml")) 
		{
			text=	serDerserial.toXML(pPanelDraw.pp);
		}
		if (type.equals("yaml")) 
		{
			text=	serDerserial.toYAML(pPanelDraw.pp);
		}
		if (type.equals("json")) 
		{
			text=	serDerserial.toJson(pPanelDraw.pp);
		}
		if (type.equals("csv")) 
		{
			text=serDerserial.toCSV(pPanelDraw.pp);
		}

		int rval = chooser.showSaveDialog(cb);
		if (rval == JFileChooser.APPROVE_OPTION) 
		{
			saveFile = chooser.getSelectedFile();
			try
			{
				if(!saveFile.exists())
				{
					saveFile.createNewFile();
				}

				PrintWriter out = new PrintWriter(saveFile.getAbsoluteFile());

				try
				{
					out.print(text);
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
		}
	}
	public int getTypeFigure()
	{
		return type;
	}
	public int sWidth()
	{
		return Width;
	}
}
