package dispatcher;

import java.io.IOException;

import socket.server.accept.SClient;
import socket.server.accept.SingletonDBSocket;
import modules.IModule;
import modules.ModuleFactory;
import web.server.SessionClient;
import web.server.SingletonDBSession;

public class Dispatcher
{
	ModuleFactory moduleFactory 	  = null;
	SingletonDBSession singletonDBSession = null;
	public Dispatcher()
	{
		moduleFactory = new ModuleFactory();
		singletonDBSession = SingletonDBSession.getInstance();
	}

	public void parseCommand(String str)
	{
		String[] args = str.split(":");
		String from = args[0];
		String to = args[1];

		if (args[3].equals("login")) {
			int id = Integer.parseInt(from);
			System.out.println("args.length = " +args.length);
			System.out.println("args[3] = " +args[3]);
			SessionClient sc = singletonDBSession.getClient(id);
			System.out.println("login  = " + args[4] + ":" + str);
			System.out.println("sc = " + sc);
			if(sc !=null) {
				sc.login = args[4];
			}
			return;
		}
//		String [] args = strParse.split(":",3);
//		String from = args[0];
//		String to = args[1];
		IModule module = moduleFactory.CheckModule(to);

		if(module==null)
		{
			int id = Integer.parseInt(from);
			SessionClient sc = singletonDBSession.getClient(id);
			System.out.println("from  =  " + from +  " error:don`t search module");
			if(sc!=null) {
				try {
					sc.session.getRemote().sendString("from  = " + from + "error:don`t search module");
				} catch (IOException e) {

				}
			}
		}
		else
		{
			System.out.println("from  =  "+ from );

			module.runCommand(str);
		}
	}
	public static class Inner
	{
		public static  Dispatcher  dispatcher = new Dispatcher();
	}
	public static  Dispatcher getDispatcherObj()
	{
		return Inner.dispatcher;
	}
}
