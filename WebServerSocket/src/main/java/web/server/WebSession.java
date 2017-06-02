package web.server;

import messanger.SingletonMessager;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class WebSession
{
    SingletonDBSession singletonDBSession = null;
    SingletonMessager messages = null;
    int id = 0;
    public WebSession()
    {
        this.messages = SingletonMessager.getInstance();
        this.singletonDBSession = SingletonDBSession.getInstance();
    }
    @OnWebSocketConnect
    public void onConnect(Session session)
    {
        System.out.println("onConnect new Client");
        id = session.hashCode();
        singletonDBSession.addClient( new SessionClient(session,id));
    }
    @OnWebSocketMessage
    public void onTextMessage(String str)
    {
        messages.addMassege( id+":" + str);
        System.out.println("messages  = " + id + ":" + str);
    }
    @OnWebSocketClose
    public void onClose(int statusCode, String reason)
    {
        System.out.println("Connection closed, statusCode=" + statusCode + " reason: " + reason);
    }
}
