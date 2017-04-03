package Server;

import java.util.ArrayList;

public class GlobalControlRoom extends Thread
{
	ArrayList<UserProfile> globalUsersList = new ArrayList<>();
	ArrayList<ChatRoom> chatRoomsList = new ArrayList<>();

	@Override
	public void run()
	{ 
		while(true)
		{
			try
			{

				Thread.sleep(100);

			} 
			catch (InterruptedException e) { e.printStackTrace();  }
		}
	}
}
