package Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class ClientWriter 
{	
	DataOutputStream out;
	public ClientWriter(OutputStream ous) throws IOException
	{
		out = new DataOutputStream(ous);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Login => ");
		String login = sc.nextLine();
		out.writeUTF("login:" + login);
		
		
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("exit"))
			{
				out.writeUTF("exit");
				out.flush();
				out.close();
				break;
			}
			out.writeUTF("msg:" + str);
			out.flush();

		}
	}
}
