package Figure_vector;

import java.awt.Color;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Serial_Deserialization 
{
	public ArrayList<Figure>  fromYAML(String yaml)
	{
		ArrayList<Figure> pp = new ArrayList<Figure>();
		try 
		{
			String regex = "\""+"|"+"[<>]"+"|"+":"+"|"+"[a-z]+"+"|"+"\n"+"|"+"\t";
			yaml = yaml.replaceAll(regex, "");
			yaml = yaml.replaceAll("   ", " ");
			String regex2 = "- ";

			String [] figures = yaml.split(regex2);
			for (int j = 1; j < figures.length; j++) 
			{
				String [] figure= figures[j].trim().split(" ");
				Figure f=	this.setFigure(figure);
				pp.add(f);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return pp;
	}

	public String toJson(ArrayList<Figure> pp)
	{		
		String res ="{ \"Figure\":[";
		for (int i = 0; i < pp.size(); i++)
		{
			Figure f = pp.get(i);
			res +="{\"x\":"+f.x +"," ;
			res +="\"y\":"+f.y +","  ;
			res +="\"w\":"+f.w  +"," ;
			res +="\"h\":"+f.h  +"," ;
			res +="\"color\":"+ f.col.getRGB() +"," ;
			res +="\"type\":"+ f.type +"," ;
			res +="\"th\":"+ f.th ;
			res +="}";
			if(i<pp.size()-1)
			{
				res +=",";
			}
		}

		return res+="]}";
	}

	public String toXML(ArrayList<Figure> pp)
	{		
		String res ="<string> <list>";
		for (Figure f : pp) 
		{
			res+="<figures>";
			res +="<x>"+f.x +"</x>" ;
			res +="<y>"+f.y +"</y>"  ;
			res +="<w>"+f.w  +"</w>" ;
			res +="<h>"+f.h  +"</h>" ;
			res +="<col>"+ f.col.getRGB() +"</col>" ;
			res +="<type>"+ f.type +"</type>" ;
			res +="<th>"+ f.th +"</th>" ;
			res+="</figures>";
		}
		return res+="</list> </string>";
	}
	public String toCSV(ArrayList<Figure> pp)
	{		
		String res ="x,y,w,h,color,type,th"+"\n";
		for (Figure f : pp) 
		{
			res += f.x    +",";
			res += f.y    +",";
			res += f.w    +",";
			res += f.h    +",";
			res += f.col.getRGB()  +",";
			res += f.type +",";
			res += f.th;
			res += "\n";
		}
		return res;
	}
	public String toYAML(ArrayList<Figure> pp)
	{		
		String res ="";
		for (Figure f : pp) 
		{
			res +="- \n  x: "     + f.x ;
			res +=	"\n  y: "     + f.y ;
			res +=	"\n  w: "     + f.w ;
			res +=	"\n  h: " 	  + f.h ;
			res +=	"\n  color: " + f.col.getRGB();
			res +=	"\n  type: "  + f.type;
			res +=	"\n  th: "    + f.th+"\n";
		}
		return res;
	}
	public ArrayList<Figure>  fromCSV(String csv)
	{
		ArrayList<Figure> pp = new ArrayList<Figure>();
		try 
		{
			String regex = "\n";
			String [] figures = csv.split(regex);
			for (int j = 1; j < figures.length; j++) 
			{
				String[] figure =figures[j].split(",");
				Figure f=	this.setFigure(figure);
				pp.add(f);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return pp;
	}
	public Figure setFigure (String [] figure)
	{
		int x =Integer.parseInt(figure[0]);
		int y = Integer.parseInt(figure[1]);
		int w = Integer.parseInt(figure[2]);
		int h = Integer.parseInt(figure[3]);
		int col = Integer.parseInt(figure[4]);
		int type = Integer.parseInt(figure[5]);
		int th= Integer.parseInt(figure[6]);
		Color color = new Color(col);
		Figure f = new Figure(x, y, w, h, color, type, th);
		return f;
	}
	public ArrayList<Figure>  fromJson(String json)
	{
		ArrayList<Figure> pp = new ArrayList<Figure>();
		try 
		{
			String regex = "\""+"|"+"[{]"+"|"+":"+"|"+"[a-z]+"+"|"+"]"+"|"+"\\[";
			String str2 = json.toLowerCase().replaceAll(regex, "");
			str2=str2.substring(1, str2.length()-1);
			StringTokenizer strTok = new StringTokenizer(str2,"}");
			String [] strarr = new String[strTok.countTokens()];
			int i =0;
			while (strTok.hasMoreElements()) 
			{
				strarr[i] = (String) strTok.nextElement();
				if (strarr[i].startsWith(","))
				{
					strarr[i]=strarr[i].replaceFirst(",","");
				}
				String[] figure =strarr[i].split(",");
				Figure f=	this.setFigure(figure);
				pp.add(f);
				i++;
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return pp;
	}
	public ArrayList<Figure>  fromXML(String json)
	{
		ArrayList<Figure> pp = new ArrayList<Figure>();

		try 
		{
			String regex = "\""+"|"+"[<>]"+"|"+":"+"|"+"[a-z]+"+"|"+"]";
			String str2 = json.replaceAll(regex, "");
			str2 = str2.replaceAll("//", "w");
			str2=str2.substring(1, str2.length()-4).trim();
			StringTokenizer strTok = new StringTokenizer(str2,"w");
			String [] strarr = new String[strTok.countTokens()];
			int i=0;
			while (strTok.hasMoreElements()) 
			{
				strarr[i] = (String) strTok.nextElement();
				String[] figure =strarr[i].split("/");
				Figure f=	this.setFigure(figure);
				pp.add(f);
				i++;
			}


		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return pp;
	}
}