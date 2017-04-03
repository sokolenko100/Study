package logic_x_o_server;

public class Game extends  Thread
{
	static final int SIZE=3;
	String[] field;
	SClient client_1 =null;
	SClient client_2 =null;
	int x = 1;
	int O = 2;
	public Game(SClient client_1,SClient client_2) 
	{
		field=new String[SIZE*SIZE];
		for(int i=0;i<field.length;i++)
		{
			field[i]="";
		}
		this.client_1= client_1;
		this.client_2 =client_2;
		this.start();
	}

	@Override
	public void run() 
	{
		while (true)
		{
			if(client_1.rdsrv.answerFromClient.size()>0)
			{
				String str = client_1.rdsrv.answerFromClient.get(0);
				client_2.wrtServ.sentResult(str);
				client_1.rdsrv.answerFromClient.clear();

				chouse(str);
			}
			if(client_2.rdsrv.answerFromClient.size()>0)
			{
				String str = client_2.rdsrv.answerFromClient.get(0);
				client_1.wrtServ.sentResult(str);
				client_2.rdsrv.answerFromClient.clear();
				chouse(str);
			}
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public void chouse(String result)
	{
		String [] resultArray = result.split(":");

		switch (resultArray[0])
		{
		case "push":
		{
			String nameP = resultArray[1];
			String idButtonP = resultArray[2];
			String type_x_or_o = resultArray[3];

			if(!setFild( nameP, idButtonP, type_x_or_o ))
			{
				if(client_1.login.equals(nameP))
				{
					String play = "play:"+client_2.login;
					//String push ="push:"+client_2.login+":"+resultArray[2]+":"+resultArray[3];
					client_2.wrtServ.sentResult(play);
					String wait = "wait:"+client_1.login;
					client_1.wrtServ.sentResult(wait);
				}
				if(client_2.login.equals(nameP))
				{
					String play = "play:"+client_1.login;
					//	String push ="push:"+client_1.login+":"+resultArray[2]+":"+resultArray[3];
					client_1.wrtServ.sentResult(play);
					String wait = "wait:"+client_2.login;
					client_2.wrtServ.sentResult(wait);
				}
				break;
			}
		}
		}
	}
	public Boolean setFild(String nameP,String idButtonP,String type_x_or_o )
	{
		Boolean flag = true;
		int id = Integer.parseInt(idButtonP);
		if(type_x_or_o.equals("x"))
		{
			field[id]="X";
		}
		else
		{
			field[id]="O";
		}
		if(checkWin())
		{
			if(client_1.login.equals(nameP))
			{
				flag= false;
				String win = "win:"+client_1.login;
				client_1.wrtServ.sentResult(win);

				String lost = "lost:"+client_2.login;
				client_2.wrtServ.sentResult(lost);
			}
			if(client_2.login.equals(nameP))
			{
				flag= false;
				String win = "win:"+client_2.login;
				client_2.wrtServ.sentResult(win);

				String lost = "lost:"+client_1.login;
				client_1.wrtServ.sentResult(lost);
			}
		}
		else if(checkDraw())
		{
			flag= false;
			String draw = "draw:"+client_2.login;
			client_2.wrtServ.sentResult(draw);

			String draw2 = "draw:"+client_1.login;
			client_1.wrtServ.sentResult(draw2);
		}
		return flag;
	}
	public Boolean  checkDraw()
	{
		Boolean res = false;
		int iter = 0;
		for (int i = 0; i < field.length; i++) 
		{
			if(!field[i].equals(""))
			{
				iter++;
			}
		}
		if(iter==9)
		{
			res = true;
		}
		return res;
	}

	public Boolean checkWin()
	{
		Boolean res = false;
		if( (field[0] + field[1] + field[2]).compareTo("XXX") == 0 || (field[0] + field[1] + field[2]).compareTo("OOO") == 0 )
			res = true;
		if( (field[3] + field[4] + field[5]).compareTo("XXX") == 0 || (field[3] + field[4] + field[5]).compareTo("OOO") == 0 )
			res = true;
		if( (field[6] + field[7] + field[8]).compareTo("XXX") == 0 || (field[6] + field[7] + field[8]).compareTo("OOO") == 0 )
			res = true;
		if( (field[0] + field[3] + field[6]).compareTo("XXX") == 0 || (field[0] + field[3] + field[6]).compareTo("OOO") == 0 )
			res = true;
		if( (field[1] + field[4] + field[7]).compareTo("XXX") == 0 || (field[1] + field[4] + field[7]).compareTo("OOO") == 0 )
			res = true;
		if( (field[2] + field[5] + field[8]).compareTo("XXX") == 0 || (field[2] + field[5] + field[8]).compareTo("OOO") == 0 )
			res = true;
		if( (field[0] + field[4] + field[8]).compareTo("XXX") == 0 || (field[0] + field[4] + field[8]).compareTo("OOO") == 0 )
			res = true;
		if( (field[2] + field[4] + field[6]).compareTo("XXX") == 0 || (field[2] + field[4] + field[6]).compareTo("OOO") == 0 )
			res = true;
		return res;
	}
}
