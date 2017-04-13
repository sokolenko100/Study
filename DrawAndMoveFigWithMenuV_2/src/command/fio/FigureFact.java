package command.fio;

import java.io.File;

public class FigureFact 
{
	public static FigureIO getI(File file)
	{
		FigureIO ret = null;
		String str = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".")+1);
		System.out.println( str );
		switch (str.toLowerCase())
		{
		case "json": ret = new FigureIO_Json(file); break;
		case "xml":  ret = new FigureIO_XML(file); break;
		case "csv":  ret = new FigureIO_CSV(file); break;
		case "yaml": ret = new FigureIO_Yaml(file); break;
		}
		return ret;
	}
}
