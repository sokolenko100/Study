package logic_TPC_IP_server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bligic.Person;

import com.google.gson.Gson;

import dal.PersonDAO_Mock;

public class readServ extends Thread
{
	DataInputStream in= null;
	Gson json = null;
	PersonDAO_Mock  pMock = null;
	List<String> answerFromClient = null;
	public  readServ(InputStream inp,PersonDAO_Mock  pMock ) 
	{
		this.pMock = pMock ;
		answerFromClient = Collections.synchronizedList(new ArrayList<String>());
		in = new DataInputStream(inp);
		json = new Gson();
		start();
	}
	@Override
	public synchronized void run() 
	{
		while (true)
		{
			try {
				String readUTF= in.readUTF();
				if(!readUTF.equals(""))
				{
					answerFromClient.add(readUTF);
					parse();
					answerFromClient.clear();
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public synchronized void parse()
	{
		Person p= null;
		String read = answerFromClient.get(0);
		String [] strArray =read.split("-");
		String queri =strArray[0];
		String person ="";
		if(strArray.length>1)
		{
			person = strArray[1];
		}
		switch (queri) 
		{
		case "create":
		{
			p = json.fromJson(person, Person.class);
			pMock.create(p);
			break;
		}
		case "update":
		{
			p = json.fromJson(person, Person.class);
			pMock.update(p);
			break;
		}
		case "delete":
		{
			p = json.fromJson(person, Person.class);
			pMock.delete(p);
			break;
		}
		case "read":
		{
			String  answer=readDB(pMock.read());
			if(!answer.equals(""))
			{
				writeServ.answer.add(answer);
			}
			break;
		}
		}
	}
	public String readDB(ArrayList<Person> people)
	{
		String ppls ="";
		ppls = json.toJson(people);
		return ppls;
	}
}
