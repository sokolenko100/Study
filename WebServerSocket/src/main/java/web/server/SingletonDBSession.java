package web.server;

import org.eclipse.jetty.websocket.api.Session;
import socket.server.accept.SClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingletonDBSession {

    private volatile static List<SessionClient> clients = Collections.synchronizedList(new ArrayList<SessionClient >());

    public static class InnerClass
    {
        public static SingletonDBSession dbSession = new SingletonDBSession();
    }

    public static SingletonDBSession getInstance()
    {
        return InnerClass.dbSession;
    }

    public synchronized int Size()
    {
        return  clients.size();
    }
    public synchronized void addClient(SessionClient clint)
    {
        System.out.print("addClient new Client");
        clients.add(clint);
    }
    public synchronized SessionClient  getClients(int i)
    {
        return clients.get(i);
    }

    public synchronized SessionClient  getClient(int id)
    {
        SessionClient  client = null;

        for(SessionClient  cl : clients)
        {
            if(cl.id==id)
            {
                client = cl;
                break;
            }
        }
        return client;
    }

    public synchronized void removeClient(int index)
    {
        clients.remove(index);
    }
}
