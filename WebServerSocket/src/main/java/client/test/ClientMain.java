package client.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain
{

	public static void main(String[] args)
	{
		try
		{
			Socket sock = new Socket("localhost",1234);
			Scanner cons = new Scanner(System.in);
			DataOutputStream out = new DataOutputStream(sock.getOutputStream());
			DataInputStream in = new DataInputStream(sock.getInputStream());
			while(true)
			{
				if(cons.hasNext())
				{
					out.writeUTF(cons.nextLine());
					out.flush();
				}
				System.out.println(in.readUTF());
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
