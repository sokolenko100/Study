package view;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.yaml.snakeyaml.Yaml;

import bligic.Person;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Serial_Deserialization 
{
//	public static void main(String[] args) 
//	{
//		ArrayList<Person> pp= new ArrayList<Person>();
//		pp.add( new Person(10, "Vasia", "Pupkin", 23) );
//		pp.add( new Person(12, "Kasia", "Lupkin", 27) );
//		pp.add( new Person(10, "Vasia", "Pupkin", 23) );
//		pp.add( new Person(12, "Kasia", "Lupkin", 27) );
//		Serial_Deserialization ser = new Serial_Deserialization();
//		String str = ser.toCSV_auto(pp);
//		System.out.println(str);
//		pp=null;
//		pp=  ser.fromCSV_auto(str);
//		System.out.println(pp.size());
//
//	}

	
	public String toCSV_auto(ArrayList<Person> pp)
	{
		String res ="";
//	    CSVParser parser = new CSVParser();
//
//
//		final String csv = mapper.writer(pp);
//		System.out.println(csv);
		return res;
	}
	public ArrayList<Person>  fromCSV_auto(String CSVtring)
	{
		ArrayList<Person> pp=null;
		String puth = "C:\\";
		try {
			FileWriter fw = new FileWriter(puth);
			fw.write(CSVtring);
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  String csvFile = "person.csv";

	        CSVReader reader = null;
	        try {
	            reader = new CSVReader(new FileReader(csvFile));
	            String[] line;
	            while ((line = reader.readNext()) != null) {
	                System.out.println("Country [id= " + line[0] + ", code= " + line[1] + " , name=" + line[2] + "]");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		return pp;
	}
	
	public String toYAML_auto(ArrayList<Person> pp)
	{
		String res ="";
		Yaml yaml= new Yaml();
		res=yaml.dump(pp);
		return res;
	}
	public static ArrayList<Person>  fromYAML_auto(String YAMLString)
	{
		Yaml yaml= new Yaml();
		ArrayList<Person> pp=(ArrayList<Person> )yaml.load(YAMLString);
		return pp;
	}

	public String toXML_auto(ArrayList<Person> pp)
	{
		String res ="";
		XStream xstream = new XStream(new DomDriver());
		res= xstream.toXML(pp);
		return res;
	}
	public ArrayList<Person>  fromXML_auto(String XMLString)
	{
		XStream xstream = new XStream(new DomDriver());
		ArrayList<Person> pp =(ArrayList<Person>) xstream.fromXML(XMLString);
		return pp;
	}

	public String toJson_auto(ArrayList<Person> pp)
	{
		String res ="";
		Gson json = new Gson();
		res= json.toJson(pp);
		return res;
	}
	public ArrayList<Person>  fromJson_auto(String jsonString)
	{
		ArrayList<Person> pp= new ArrayList<Person>();
		Gson json = new Gson();
		pp = (ArrayList<Person>) Arrays.asList(json.fromJson(jsonString, Person[].class));
		return pp;
	}
	public static ArrayList<Person>  fromXML_hend(String xml)
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		String [] pattern = {"id","fname","lname","age"};
		try 
		{
			String regex = "Persons";
			String []	xmlstr = xml.split(regex);
			System.out.println();
			String [] str2=null;
			String [] str3=null;
			String pstr ="";
			int counter=0;
			for (int i = 1; i < xmlstr.length-1; i++) 
			{
				counter=0;
				if(xmlstr[i].length()<3)
				{
					continue;
				}
				regex = "\\>"+"|"+"\\<";
				xmlstr[i]=xmlstr[i].replaceAll(regex," ");
				str2=xmlstr[i].split(" ");
				for (int j = 1; j < str2.length; j++) 
				{
					if (str2[j-1].equals(pattern[counter]) )
					{
						pstr+=str2[j]+" ";
						counter++;
						if (counter ==4) 
						{
							break;
						}
					}
				}
				if (pstr!="") 
				{
					String [] person =pstr.split(" ");
					Person p=	setPerson(person);
					pp.add(p);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return pp;
	}
	public static  ArrayList<Person>  fromJson_hend(String json)
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		String regex = "\""+"|"+"[{]"+"|"+"]"+"|"+"\\[";
		json = json.substring(13, json.length()-1);
		json = json.replaceAll(regex, "");

		String [] Persons = json.split("\\}");
		String [] str2=null;
		String [] str3=null;
		String pstr ="";
		int count =1;
		for (int i = 0; i < Persons.length; i++) 
		{
			pstr ="";
			if (Persons[i].startsWith(",")) 
			{
				str2=Persons[i].substring(1, Persons[i].length()-1).split(",");
			}
			else
			{
				str2=Persons[i].trim().split(",");
			}
			for (int j = 0; j < str2.length; j++)
			{
				str3=str2[j].split(":");

				pstr+=	str3[count]+" ";
			}
			if (pstr!="") 
			{
				String [] person =pstr.split(" ");
				Person p=	setPerson(person);
				pp.add(p);
			}
		}
		return pp;
	}
	public String toJson_hend(ArrayList<Person> pp)
	{		
		String res ="{ \"Person\":[";
		for (int i = 0; i < pp.size(); i++)
		{
			Person p = pp.get(i);
			res +="{\"id\":"+"\""+p.id +"\""+"," ;
			res +="\"fname\":"+"\""+p.fname +"\""+","  ;
			res +="\"lname\":"+"\""+p.lname  +"\""+"," ;
			res +="\"age\":"+"\""+p.age +"\"";
			res +="}";
			if(i<pp.size()-1)
			{
				res +=",";
			}
		}

		return res+="]}";
	}
	public String toXML_hend(ArrayList<Person> pp)
	{		
		String res ="<string> <list>";
		for (Person p : pp) 
		{
			res+="<Persons>";
			res +="<id>"+p.id +"</id>" ;
			res +="<fname>"+p.fname +"</fname>"  ;
			res +="<lname>"+p.lname  +"</lname>" ;
			res +="<age>"+p.age  +"</age>" ;
			res+="</Persons>";
		}
		return res+="</list> </string>";
	}

	public String toCSV_hend(ArrayList<Person> pp)
	{		
		String res ="id,fname,lname,age"+"\n";
		for (Person p : pp) 
		{
			res += 		p.id    	 +",";
			res +="\""+ p.fname +"\""+",";
			res +="\""+ p.lname +"\""+",";
			res +=		p.age  		 +",";
			res += "\n";
		}
		return res;
	}
	public static String toYAML_hend(ArrayList<Person> pp)
	{		
		String res ="";
		for (Person p : pp) 
		{
			res +="- \n  id: "     + p.id ;
			res +=	"\n  fname: "  + p.fname ;
			res +=	"\n  lname: "  + p.lname ;
			res +=	"\n  age: "    + p.age+"\n";
		}
		return res;
	}
	public static ArrayList<Person>  fromCSV_hend(String csv)
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		try 
		{
			String regex = "\n";
			String [] Persons = csv.split(regex);
			for (int j = 1; j < Persons.length; j++) 
			{
				String[] Person =Persons[j].replaceAll("\"", "").split(",");
				Person p=	setPerson(Person);
				pp.add(p);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return pp;
	}
	public static ArrayList<Person>  fromYAML_hend(String yaml)
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		String regex2 = "- ";

		String [] Persons = yaml.split(regex2);
		String [] str2=null;
		String [] str3=null;
		String pstr ="";
		for (int i = 0; i < Persons.length; i++) 
		{

			str2=Persons[i].split("\n");
			for (int j = 1; j < str2.length; j++)
			{
				str3=str2[j].trim().split(" ");
				pstr+=	str3[1]+" ";
			}
			if (pstr!="") 
			{
				pstr=pstr.trim();
				String [] person =pstr.split(" ");
				Person p=	setPerson(person);
				pp.add(p);
				pstr="";
			}
		}

		return pp;
	}
	public static Person setPerson (String [] Person)
	{
		int id =Integer.parseInt(Person[0]);
		String fname = Person[1];
		String lname = Person[2];
		int age = Integer.parseInt(Person[3]);

		Person p = new Person(id, fname, lname,age);
		return p;
	}
}