package Client_Socet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ChatConnection
{

	DataInputStream  in;
	DataOutputStream out;

	public ChatConnection()
	{
		int port = 5544;
		String adress = "127.0.0.1";
		InetAddress IP;
		try
		{
			IP = InetAddress.getByName(adress);
			@SuppressWarnings("resource")
			Socket sock = new Socket(IP, port);
			if (sock.isConnected())
			{
				System.out.println("Got the server");
			}

			InputStream sin = sock.getInputStream();
			OutputStream sout = sock.getOutputStream();

			in = new DataInputStream(sin);
			out = new DataOutputStream(sout);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
