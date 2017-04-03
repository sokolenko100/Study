package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketForConnection extends Thread
{

	Socket socketForConnection;
	ObjectOutputStream outStream;
	ObjectInputStream inStream;
	UserProfile profile;


	public SocketForConnection(ServerSocket servSocket)
	{
		try
		{
			socketForConnection = servSocket.accept();
			outStream = new ObjectOutputStream(socketForConnection.getOutputStream());
			inStream = new ObjectInputStream(socketForConnection.getInputStream());
		} 
		catch (IOException e) {  e.printStackTrace(); }

		start();
		System.out.println("socked created");
	}


	@Override
	public void run()
	{
		try
		{ 
			while (true)
			{

				Thread.sleep(100);
			}
		}
		catch (InterruptedException e)  { e.printStackTrace();  }
	}

	@Override
	protected void finalize() throws Throwable
	{
		inStream.close();
		outStream.close();
		socketForConnection.close();
		super.finalize();
	}
}
