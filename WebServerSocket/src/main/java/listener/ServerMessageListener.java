package listener;

import dispatcher.Dispatcher;
import messanger.SingletonMessager;

public class ServerMessageListener extends Thread
{
	SingletonMessager masseges = null;
	Dispatcher dispatcher = null;

	public ServerMessageListener()
	{
		this.masseges = SingletonMessager.getInstance();
		this.dispatcher = Dispatcher.getDispatcherObj();
		start();
	}

	@Override
	public void run() 
	{
		while(true)
		{
			if(masseges.Size()>0)
			{
				System.out.println("size "+ masseges.Size());

				String result = masseges.getMassege(0);
				masseges.removeMassege(0);
				System.out.println("masseges from client =  "+ result );
				dispatcher.parseCommand(result);
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}