package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class MainServer extends Thread
{
	ServerSocket servSocket;
	ArrayList<SocketForConnection> ar = new ArrayList<>();

	public MainServer() throws IOException
	{
		servSocket = new ServerSocket(9999, 5);
		System.out.println("server sterted");
	}

	public static void main(String[] args) throws IOException
	{
		new Thread( new MainServer() ).start();
	}
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				SocketForConnection s1 = new SocketForConnection(servSocket);
				ar.add(s1);

				Thread.sleep(100);
			}
		}
		catch (Exception e)  { }
	}

	@Override
	protected void finalize() throws Throwable
	{
		servSocket.close();
		super.finalize();
	}
}
