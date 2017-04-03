package logic_TPC_IP_server;

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
	@Override
	public synchronized void run() 
	{
		while (true)
		{
			try {
				if(answer.size()>0)
				{
					String answerTemp = answer.get(0);
					out.writeUTF(answerTemp);
					out.flush();
					Thread.sleep(100);
					answer.clear();
				}

			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			//			if(server.answer.equals("exit"))
			//			{
			//				break;
			//			}
		}
	}
}
