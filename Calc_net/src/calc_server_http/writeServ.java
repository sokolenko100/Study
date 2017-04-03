package calc_server_http;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class writeServ extends Thread
{
	DataOutputStream out = null;
	public static	List<String> answer =null;
	public writeServ(OutputStream outp)
	{
		answer = Collections.synchronizedList(new ArrayList<String>());
		out = new DataOutputStream(outp);
		start();
	}


	public synchronized void sendMessage(int result)
	{
		try
		{
			out.writeDouble(result);
			out.flush();

		} catch (Exception e)
		{
			e.printStackTrace();
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
