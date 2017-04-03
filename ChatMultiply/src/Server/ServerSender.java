package Server;

import java.io.IOException;
import java.util.ArrayList;

public class ServerSender extends Thread
{
	ArrayList<SClient> clients;
	ArrayList<String> msg;
	ArrayList<SClient> removedClients;
	public ServerSender(ArrayList<SClient> clients, ArrayList<String> msg)
	{
		this.clients = clients;
		this.msg = msg;
		removedClients = new ArrayList<SClient>();
		start();
	}

	@Override
	public void run()
	{
		String removedLogins = "";
		try
		{
			while (true)
			{
				for (SClient client : clients)
				{
					if(msg.size() > 0)
					{
						for (String line : msg)
						{
							if(line.contains("left our chat"))
							{
								String[] arr = line.split(" ");
								removedLogins += arr[0];
							}
							if(removedLogins.contains(client.login))
							{
								removedClients.add(client);
								continue;
							}
							client.out.writeUTF(line);
							client.out.flush();
						}
					}
				}
				removeClients();
				msg.clear();
				sleep(100);
			}
		} 
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private void removeClients()
	{
		if(removedClients.size() > 0)
		{
			for (SClient removed : removedClients)
			{
				int index = clients.indexOf(removed);
				clients.remove(index);
			}
		}
		removedClients.clear();
	}
}
