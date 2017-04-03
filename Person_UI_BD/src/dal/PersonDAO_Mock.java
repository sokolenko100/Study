package dal;
import java.util.ArrayList;

import bligic.Person;

public class PersonDAO_Mock implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();

	public PersonDAO_Mock() 
	{
		pp.add( new Person(10, "Vasia", "Pupkin", 23) );
		pp.add( new Person(12, "Kasia", "Lupkin", 27) );
		pp.add( new Person(17, "Masia", "Gupkin", 20) );
		pp.add( new Person(19, "Gasia", "Fupkin", 21) );
		pp.add( new Person(21, "Hasia", "Popkin", 29) );
	}

	@Override
	public void create(Person p) 
	{
		pp.add(p);
	}

	@Override
	public ArrayList<Person> read() 
	{
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		for (Person person : pp) 
		{
			if (person.id==p.id) 
			{
				person.id=p.id;
				person.age=p.age;
				person.fname=p.fname;
				person.lname=p.lname;
				break;
			}
		}
	}

	@Override
	public void delete(Person p) 
	{
		for (Person person : pp) 
		{
			if (person.id==p.id) 
			{
				pp.remove(person);
				break;
			}
		}
	}
}
