package logic_x_o_server;

import java.util.List;

public class checkCliens extends Thread
{
	public volatile	List<SClient> sclients = null;
	volatile 	Messager listener =null;
	public checkCliens(List<SClient> sclients,Messager listener) 
	{
		this.listener= listener;
		this.sclients = sclients;
		this.start();
	}
	@Override
	public synchronized void run() 
	{
		while(true)
		{
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			for (SClient sclient :sclients)
			{
				if((sclient.rdsrv.answerFromClient.size()>0)&&(client_1 ==null)&&(client_2 ==null))
				{
					String answer = sclient.rdsrv.answerFromClient.get(0);
					process(answer,sclient);
				}
			}
		
		}
	}
	String Player_1 ="";
	String Player_2="";
	SClient client_1 =null;
	SClient client_2 =null;
	public synchronized void process(String answer,SClient sclient )
	{
		String [] comand=answer.split(":");
		String name = "";
		if(comand.length>0)
		{
			switch (comand[0])
			{
			case "gamerName":
			{
				name=comand[1];
				sclients.get(sclients.size()-1).login =name;
				String gamNam = "gamerName:"+name;
				listener.sendMessage(gamNam);
				sclient.rdsrv.answerFromClient.clear();
				break;
			}
			case "play":
			{
				Player_1= comand[1];
				Player_2 =comand[2];
				this.setType( Player_1, Player_2);
				break;
			}
			}
		}
	}
	public void setType(String Player_1,String Player_2)
	{
		for (SClient client : sclients)
		{
			if(client.login.equals(Player_1))
			{
				client_1=client;
			}
			if(client.login.equals(Player_2))
			{
				client_2=client;
			}
		}
		String typePlayer_1="type:" +Player_1+":"+"x";
		client_1.wrtServ.sentResult(typePlayer_1);

		String typePlayer_2="type:" +Player_2+":"+"o";
		client_2.wrtServ.sentResult(typePlayer_2);

		if(!client_1.equals(null)&&!client_1.equals(null))
		{
			new Game(client_1,client_2);
		}
	}
}
