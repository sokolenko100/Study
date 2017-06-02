package web.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class ServerAcceptWeb extends Thread
{
    public ServerAcceptWeb()
    {
        this.start();
    }

    public void run()
    {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(4567);
        server.addConnector(connector);
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase(".");
        HandlerList handList = new HandlerList();
        handList.setHandlers(new Handler[]{new SessionHandler(),resourceHandler});
        server.setHandler(handList);
        try {
            server.start();
            server.join();
        }catch (Exception e)
        {
            e.printStackTrace(System.err);
        }
    }
    public class SessionHandler extends WebSocketHandler
    {

        @Override
        public void configure(WebSocketServletFactory webSocketServletFactory) {
            webSocketServletFactory.register(WebSession.class);
        }
    }
}
