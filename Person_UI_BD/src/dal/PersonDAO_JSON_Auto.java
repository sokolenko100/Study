package dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import bligic.Person;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PersonDAO_JSON_Auto implements PersonDAO
{
	Gson gg = new Gson();
	public	ArrayList<Person> pp =null;

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
		File saveFile = new File("person.json");
		res= gg.toJson(pp);
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
			File file = new File("person.json");
			BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));

			while ((s = in.readLine()) != null)
			{
				sb.append(s);
				sb.append("\n");
			}
			in.close();
			pp = gg.fromJson(sb.toString(), new TypeToken<ArrayList<Person>>() {}.getType());
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
