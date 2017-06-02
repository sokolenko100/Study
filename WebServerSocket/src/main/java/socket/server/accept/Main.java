package socket.server.accept;

import listener.ServerMessageListener;

public class Main {

	public static void main(String[] args)
	{
		new ServerAcceptSocet();
		new ServerMessageListener();
	}
}
