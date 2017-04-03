package calc_server_http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class server
{
	readServ  rdsrv  = null;
	writeServ wrtServ = null;
	public server()
	{
		setServer();
	}
	public void setServer()
	{
		try (ServerSocket ss = new ServerSocket(7888);)
		{
			while(true)
			{
				Socket sc = ss.accept();
			
				wrtServ = new writeServ(sc.getOutputStream());
				rdsrv = new readServ(sc.getInputStream(),wrtServ);
				System.out.println("Server started");
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String [] str)
	{
		new server();
	}
}
