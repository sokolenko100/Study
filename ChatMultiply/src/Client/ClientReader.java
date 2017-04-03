package Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientReader extends Thread
{
	DataInputStream in;
	public ClientReader(InputStream is)
	{
		in = new DataInputStream(is);
		start();
	}
	
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				String line = in.readUTF();
				System.out.println(line);
				sleep(100);
			}
		} 
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
