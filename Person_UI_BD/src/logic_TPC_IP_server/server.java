package logic_TPC_IP_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import dal.PersonDAO_Mock;

public class server
{
	readServ  rdsrv  = null;
	writeServ wrtServ = null;
	PersonDAO_Mock  pMock = null;
	public server()
	{
		pMock = new PersonDAO_Mock();
		setServer();
	}
	public void setServer()
	{
		try (ServerSocket ss = new ServerSocket(1234);)
		{
			while(true)
			{
				Socket sc = ss.accept();
				rdsrv = new readServ(sc.getInputStream(),pMock);
				wrtServ = new writeServ(sc.getOutputStream());
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
