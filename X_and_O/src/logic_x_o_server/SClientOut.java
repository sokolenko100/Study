package logic_x_o_server;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SClientOut extends Thread
{
	DataOutputStream out = null;
	public volatile static	List<String> answer =null;
	public SClientOut(OutputStream outp)
	{
		answer = Collections.synchronizedList(new ArrayList<String>());
		out = new DataOutputStream(outp);
		start();
	}
	public synchronized  void sentResult(String result) 
	{
		try 
		{
			if(!result.equals(""))
			{
				out.writeUTF(result);
				out.flush();
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run() 
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
		}
	}
}
