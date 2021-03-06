package dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import view.Serial_Deserialization;
import bligic.Person;

public class PersonDAO_CSV_Auto implements PersonDAO
{
	public	ArrayList<Person> pp ;
	Serial_Deserialization serial_Deserialization = null;
	public PersonDAO_CSV_Auto()
	{
		pp =null;
		serial_Deserialization = new Serial_Deserialization();
	}
	@Override
	public void create(Person p)
	{
		pp = read();
		pp.add(p);
		save(pp);
	}
	public void save(ArrayList<Person> pp) 
	{
		String res="";
		File saveFile = new File("person.csv");
		res = serial_Deserialization.toCSV_hend(pp);
		try
		{
			if(!saveFile.exists())
			{
				saveFile.createNewFile();
			}

			PrintWriter out = new PrintWriter(saveFile.getAbsoluteFile());

			try
			{
				out.write(res);
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
	@Override
	public ArrayList<Person> read() 
	{
		pp=null;
		try 
		{
			String s;
			StringBuilder sb = new StringBuilder();
			File file = new File("person.csv");
			BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
			while ((s = in.readLine()) != null)
			{
				sb.append(s);
				sb.append("\n");
			}
			in.close();
			pp = serial_Deserialization.fromCSV_hend(sb.toString());
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}
	@Override
	public void update(Person p)
	{
		for (Person person : pp) 
		{
			if (person.id==p.id) 
			{
				person.fname=p.fname;
				person.lname=p.lname;
				person.age=p.age;
			}
		}
		save(pp);
	}
	@Override
	public void delete(Person p)
	{
		for (Person person : pp) 
		{
			if (person.id==p.id) 
			{
				pp.remove(person);
			}
		}
		save(pp);
	}
}
