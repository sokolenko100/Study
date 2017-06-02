package web.server;


import org.eclipse.jetty.websocket.api.Session;

public class SessionClient {

    public int id;
    public String login = "";
    public Session session = null;
    public SessionClient(Session session,int id)
    {
        this.session = session;
        this.id = id;
    }
}
