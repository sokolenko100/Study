package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain
{

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Socket sock = new Socket("127.0.0.1", 7888);
		ClientReader read = new ClientReader(sock.getInputStream());	
		new ClientWriter(sock.getOutputStream());
		read.stop();
		read.in.close();
		
	}

}
