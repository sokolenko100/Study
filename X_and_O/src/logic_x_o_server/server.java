package logic_x_o_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class server extends Thread
{
	public static void main(String [] str)
	{
		new server();
	}
	public volatile	List<SClient> sclients = null;
	Messager listener =null;
	public checkCliens checCliens = null;
	public server()
	{
		sclients = Collections.synchronizedList(new ArrayList<SClient>());
		listener = new Messager(sclients);
		checCliens = new checkCliens(sclients,listener);
		this.start();
	}
	@Override
	public void run()
	{
		try (ServerSocket ss = new ServerSocket(1234);)
		{
			while(true)
			{
				Socket sc = ss.accept();
				System.out.println("Start Server");
				SClient sclient = new SClient(sc,sclients,listener);
				sclients.add(sclient);

				System.out.println("Server started");
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
