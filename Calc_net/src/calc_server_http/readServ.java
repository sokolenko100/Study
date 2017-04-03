package calc_server_http;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class readServ extends Thread
{
	DataInputStream in= null;
	List<String> answerFromClient = null;
	writeServ wrt = null;
	public  readServ(InputStream inp, writeServ wrt)
	{
		answerFromClient = Collections.synchronizedList(new ArrayList<String>());
		in = new DataInputStream(inp);
		this.wrt=wrt;
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
					parse();
					answerFromClient.clear();
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public synchronized void parse()
	{
		String read = answerFromClient.get(0);
		String [] strArray =read.split(":");
		String oPer ="";
		int aNumb = 0;
		int bNumb = 0;
		int result = 0;
		if(strArray.length>1)
		{
			String aNumbstr =strArray[1];
			aNumb =Integer.parseInt(aNumbstr);
			 oPer =strArray[2];
			String bNumbstr =strArray[3];
			bNumb =Integer.parseInt(aNumbstr);

		}
		switch (oPer) 
		{
		case "+":
		{
			result =aNumb+bNumb;
			break;
		}
		case "-":
		{
			result =aNumb-bNumb;
			break;
		}
		case "*":
		{
			result =aNumb*bNumb;
			break;
		}
		case "/":
		{
			result =aNumb/bNumb;
		}
		default:
		{
			wrt.sendMessage(result);
			break;
		}
		}
	}
}
