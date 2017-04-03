package dal;

import java.util.ArrayList;

import logic_TPC_IP_client.client;
import bligic.Person;
public class PersonDAO_NetClient implements PersonDAO
{
	client  client = null;
	public PersonDAO_NetClient()
	{
		client = new client();
	}
	@Override
	public void create(Person p) 
	{
		client.create(p);
	}

	@Override
	public ArrayList<Person> read()
	{
		return client.read();
	}

	@Override
	public void update(Person p)
	{
		client.update(p);
	}

	@Override
	public void delete(Person p) 
	{
		client.delete(p);
	}
}
