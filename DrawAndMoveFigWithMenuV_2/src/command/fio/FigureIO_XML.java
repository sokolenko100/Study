package command.fio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.MFigure;

public class FigureIO_XML implements FigureIO {

	File file = null;
	public FigureIO_XML(File file) {
	this.file=file;
	}

	@Override
	public void save(ArrayList<MFigure> pp) 
	{
		XStream xstream = new XStream(new DomDriver());
		try 
		{
			FileUtils.writeStringToFile(file, xstream.toXML(pp), "UTF-8");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MFigure> load() 
	{
		XStream xstream = new XStream(new DomDriver());
		ArrayList<MFigure> pp = null;
		try 
		{
			String str = FileUtils.readFileToString(file, "UTF-8");
			pp =(ArrayList<MFigure>) xstream.fromXML(str);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

}
