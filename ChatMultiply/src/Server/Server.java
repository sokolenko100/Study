package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(7888);
		System.out.println("Waiting for a new client");
		ArrayList<SClient> clients = new ArrayList<SClient>();
		ArrayList<String> msg = new ArrayList<String>();
		new ServerSender(clients, msg);
		while(true)
		{
			Socket sock = ss.accept();
			System.out.println("we've got a new client");
			clients.add(new SClient(sock, msg));
		}
	}
}
