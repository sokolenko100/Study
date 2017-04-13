package command.fio;

import java.util.ArrayList;

import model.MFigure;

public interface FigureIO 
{
	public void save(ArrayList<MFigure> pp);	
	public ArrayList<MFigure> load();
}
