package socket.server.accept;

public class ServerAcceptSocet  extends Thread
{
	SingletonDBSocket dbSocet = null;
	public ServerAcceptSocet()
	{
		dbSocet =  SingletonDBSocket.getInstance();
		start();
	}
	@Override
	public void run() 
	{
//		try(ServerSocket ss  = new ServerSocket(1234))
//		{
//			while(true)
//			{
//				Socket sc = ss.accept();
//				System.out.println("Client add");
//				dbSocet.addClient(new SClient(sc,sc.hashCode()));
//			}
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
