package logic_x_o_server;

import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Messager extends Thread
{

	volatile List<SClient> sockets = new ArrayList<>();
	DataOutputStream out1 =null;
	public Messager(List<SClient> sockets)
	{
		this.sockets = sockets;
		this.start();
	}

	public synchronized void sendMessage(String name)
	{
		String [] select = name.split(":");
		for (SClient socket : sockets)
		{
			if (!socket.sc.isClosed()&&!socket.login.equals(select[1]))
			{
				try
				{
					out1= new DataOutputStream(socket.sc.getOutputStream());
					out1.writeUTF(name);
					out1.flush();
				//	out1.close();

				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
