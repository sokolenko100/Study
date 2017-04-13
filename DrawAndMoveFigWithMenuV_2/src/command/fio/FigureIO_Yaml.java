package command.fio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import model.MFigure;

import org.apache.commons.io.FileUtils;
import org.yaml.snakeyaml.Yaml;

import view.Figure;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class FigureIO_Yaml implements FigureIO {

	File file = null;
	public FigureIO_Yaml(File file) {
		this.file=file;
	}

	@Override
	public void save(ArrayList<MFigure> pp) 
	{
		Yaml yaml = new Yaml();
		try 
		{
			FileUtils.writeStringToFile(file, yaml.dump(pp), "UTF-8");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MFigure> load() 
	{
		Yaml yaml= new Yaml();
		ArrayList<MFigure> pp = null;
		try 
		{
			String YAMLString = FileUtils.readFileToString(file, "UTF-8");
			pp=(ArrayList<MFigure> )yaml.load(YAMLString);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}
}
