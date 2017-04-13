package command.fio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.MFigure;
import view.Figure;

public class FigureIO_Json implements FigureIO 
{
	File file = null;
	public FigureIO_Json(File file) 
	{
		this.file = file;
	}

	@Override
	public void save(ArrayList<MFigure> pp) 
	{
		Gson gs = new Gson();
		try 
		{
			FileUtils.writeStringToFile(file, gs.toJson(pp), "UTF-8");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MFigure> load() 
	{
		Gson gs = new Gson();
		ArrayList<MFigure> pp = null;
		try 
		{
			String str = FileUtils.readFileToString(file, "UTF-8");
			pp = gs.fromJson(str, new TypeToken<ArrayList<MFigure>>() {}.getType() );
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return pp;
	}

}
