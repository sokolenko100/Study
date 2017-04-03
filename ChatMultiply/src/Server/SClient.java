package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class SClient extends Thread
{
	DataOutputStream out;
	DataInputStream in;
	Socket sock;
	ArrayList<String> msg;
	String login = "";

	public SClient(Socket sock, ArrayList<String> msg) throws IOException
	{
		this.out = new DataOutputStream(sock.getOutputStream());
		this.in = new DataInputStream(sock.getInputStream());
		this.sock = sock;
		this.msg = msg;
		start();
	}

	@Override
	public void run()
	{
		String str = "";
		try
		{
			while(true)
			{
				str = in.readUTF();
				String[] arr = str.split(":");
				if(arr[0].equals("login"))
				{
					login = arr[1];
					str = login + " entered the chat";
					msg.add(str);
				}
				if(arr[0].equals("msg"))
				{
					if(arr.length > 1)
					{
						str = login + " wrote: " + arr[1];
					}
					else
					{
						str = login + " wrote: ";
					}
					msg.add(str);
				}
				if(arr[0].equals("exit"))
				{
					str = login + " left our chat";
					msg.add(str);
					break;
				}
			}
			in.close();
			out.close();
			this.stop();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
