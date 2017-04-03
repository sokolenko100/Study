package logic_x_o_client;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

public class client 
{
	public	Socket sc = null;
	public volatile	readClient readCl = null;
	public volatile	writeClient wrtClnt = null;
	public volatile	List<String> answerfromserver = null;;
	public  volatile List<String> query = null;
	Gson json = null;
	String  gamerName = null;
	public client(String  gamerName)
	{
		this.gamerName= gamerName;
		json = new Gson();
		answerfromserver = Collections.synchronizedList(new ArrayList<String>());
		query = Collections.synchronizedList(new ArrayList<String>());
		
		try {
			sc = new Socket("127.0.0.1",1234);
			readCl = new readClient(sc.getInputStream(),answerfromserver);
			wrtClnt = new writeClient(sc.getOutputStream(),query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		query.add(gamerName);
	}
	public void exitAndClouse()
	{
		try {
			readCl.in.close();
			wrtClnt.out.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}