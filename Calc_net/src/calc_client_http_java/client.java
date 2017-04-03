package calc_client_http_java;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class client 
{
	Socket sc = null;
	readClient readCl = null;
	writeClient wrtClnt = null;
	List<String> answerfromserver =null;;
	List<String> query = null;
	public client()
	{
		answerfromserver = Collections.synchronizedList(new ArrayList<String>());
		query = Collections.synchronizedList(new ArrayList<String>());
		try
		{
			sc = new Socket("127.0.0.1",1234);
			readCl = new readClient(sc.getInputStream(),answerfromserver);
			wrtClnt = new writeClient(sc.getOutputStream(),query);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
