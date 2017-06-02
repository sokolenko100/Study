package web.server;

import listener.ServerMessageListener;

public class Main
{
    public static void main(String [] args)
    {
       new ServerAcceptWeb();
       new ServerMessageListener();
    }
}
