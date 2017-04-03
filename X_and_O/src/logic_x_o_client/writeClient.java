package logic_x_o_client;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;


public class writeClient extends Thread
{
 public	DataOutputStream out = null;
	List<String> query = null;
	public writeClient(OutputStream outp,List<String> query) 
	{
		this.query=query;
		out = new DataOutputStream(outp);
		start();
	}
	@Override
	public synchronized void run() 
	{
		while (true)
		{
			try {
				if (query.size()>0) 
				{
					String temp = query.get(0);
					out.writeUTF(temp);
					out.flush();
					Thread.sleep(10);
					query.clear();
				
				}
				Thread.sleep(10);
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
