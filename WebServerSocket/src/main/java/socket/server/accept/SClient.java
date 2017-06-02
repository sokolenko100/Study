package socket.server.accept;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import messanger.SingletonMessager;

public class SClient extends Thread
{
	SingletonMessager masseges = null;
	public Socket sc;
	public volatile	int id;
	public  DataOutputStream out = null;
	DataInputStream in = null;
	public SClient(Socket sc, int id)
	{
		System.out.println("Client id = " +id);
		this.masseges = SingletonMessager.getInstance();
		this.id = id;
		this.sc = sc;
		try {
			out = new DataOutputStream(sc.getOutputStream());
			in = new DataInputStream(sc.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		start();
	}
	@Override
	public void run() {
		while(true)
		{
			try {
				String str = in.readUTF();
				if(!str.equals(""))
				{
					masseges.addMassege(id+":"+str);
					System.out.println("Massege from id = "+ id+":"+str);
					str = "";
				}
				sleep(100);
			} catch (IOException e) {
			}
			catch (InterruptedException e)
			{

			}

		}
	}
}
