package logic_x_o_server;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class SClient extends Thread
{
	public volatile String login ="";
	volatile List<SClient> sclients = null;
	Socket sc = null;
	SClientIn  rdsrv  = null;
	SClientOut wrtServ = null;
	Messager listener = null;
	public SClient(Socket sc,List<SClient> sclients,Messager listener )
	{
		this.sc=sc;
		this.listener= listener;
		this.sclients=sclients;
		try {
			rdsrv = new SClientIn(sc.getInputStream());
			wrtServ = new SClientOut(sc.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	this.start();
	}
	@Override
	public void run() 
	{
		
	}
}
