package logic_TPC_IP_client;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import view.Serial_Deserialization;
import bligic.Person;

import com.google.gson.Gson;

public class client 
{
	Socket sc = null;
	readClient readCl = null;
	writeClient wrtClnt = null;
	List<String> answerfromserver =null;;
	List<String> query = null;
	Gson json = null;
	Serial_Deserialization deserial = null;
	public client()
	{
		json = new Gson();
		deserial= new Serial_Deserialization();
		answerfromserver = Collections.synchronizedList(new ArrayList<String>());
		query = Collections.synchronizedList(new ArrayList<String>());
		try {
			sc = new Socket("127.0.0.1",1234);
			readCl = new readClient(sc.getInputStream(),answerfromserver);
			wrtClnt = new writeClient(sc.getOutputStream(),query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized void create (Person p)
	{
		query.clear();
		String create = "create-";
		create+=json.toJson(p);
		query.add(create);
	}
	public synchronized void update (Person p)
	{
		query.clear();
		String update = "update-";
		update+=json.toJson(p);
		query.add(update);
	}
	public synchronized void delete (Person p)
	{
		query.clear();
		String delete = "delete-";
		delete+=json.toJson(p);
		query.add(delete);
	}
	public synchronized ArrayList<Person> read ()
	{
		query.clear();
		ArrayList<Person> pp= new ArrayList<Person>();
	
		String read = "read-";
		query.add(read);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		if(answerfromserver.size()>0)
		{
			String answerresult = answerfromserver.get(0);
		//	pp=deserial.fromJson_auto(answerresult);
		List<Person> pp2 =  Arrays.asList(json.fromJson(answerresult, Person[].class));
		for (int i =0;i<pp2.size();i++) 
		{
			Object obj = pp2.get(i);
			Person p =(Person) obj;
			pp.add( p);
		}
			answerfromserver.clear();
		}
		return pp;
	}
}
