package socket.server.accept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingletonDBSocket {
	
	private volatile static	List<SClient> clients = Collections.synchronizedList(new ArrayList<SClient>());

	public static class InnerClass
	{
		public static SingletonDBSocket dbSocets = new SingletonDBSocket();
	}
	public static SingletonDBSocket getInstance()
	{
		return InnerClass.dbSocets;
	}
	
	public synchronized void addClient(SClient clint)
	{
		clients.add(clint);
	}
	public synchronized SClient getClient(int id)
	{
		System.out.println("Size clientsArr = "+ clients.size());
		SClient client = null;
		for(SClient cl : clients)
		{
			if(cl.id==id)
			{
				client = cl;
				break;
			}
		}	
		return client;
	}
	public synchronized void removeClient(int index)
	{
		clients.remove(index);
	}
}
