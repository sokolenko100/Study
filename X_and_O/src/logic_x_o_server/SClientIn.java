package logic_x_o_server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SClientIn extends Thread
{
	DataInputStream in= null;
	volatile List<String> answerFromClient = null;
	public  SClientIn(InputStream inp) 
	{
		answerFromClient = Collections.synchronizedList(new ArrayList<String>());
		in = new DataInputStream(inp);
		start();
	}
	@Override
	public synchronized void run() 
	{
		while (true)
		{
			try {
				String readUTF= in.readUTF();
				if(!readUTF.equals(""))
				{
					answerFromClient.add(readUTF);
					readUTF="";
				}
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
