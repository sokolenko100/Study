package PersonDB;

import java.util.ArrayList;

public class PMain 
{
	public static void main(String[] args) 
	{
		PersonDAO  pd = new PersonDAO_H2();
		
		Person person = new Person(5,"Motya","Motkina",34); 
		pd.create(person);
		ArrayList<Person> pp = pd.read();
	//	Person per = pp.get(0);
		//per.fname="Lusay";
	//	pd.delete(per);
	//	ArrayList<Person> pp2 = pd.read();
		for (Person p : pp)
		{
			System.out.println( p );
		}
	}
}
