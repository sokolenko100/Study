package logic_x_o_client;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.List;

public class readClient extends Thread
{
	DataInputStream in = null;
	List<String> answerfromserver =null;;
	public readClient(InputStream input,List<String> answerfromserver ) 
	{
		this.answerfromserver =answerfromserver;
		in = new DataInputStream(input);
		start();
	}
	@Override
	public  void run() 
	{
		while (true)
		{
			try {
				String answer = in.readUTF();
				if(!answer.equals(""))
				{
					answerfromserver.add(answer);
					Thread.sleep(100);
					answer="";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
