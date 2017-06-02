package modules;

import web.server.SessionClient;
import web.server.SingletonDBSession;

import java.io.IOException;
import java.util.ArrayList;

public class ChatModule implements IModule {

    SingletonDBSession singletonDBSession = null;
    public ChatModule() {
        singletonDBSession = SingletonDBSession.getInstance();
    }
    ArrayList<String> listMasseges = new ArrayList<String>();
    public String answerFromServer= "";
    @Override
    public  String runCommand(String str)
    {
        String [] args = str.split(":");
        String from = args[0];
        String to = args[1];
        String command = args[2];
        String arguments = args[3];
        answerFromServer+=arguments+"\n";

			for (int i = 0;i< singletonDBSession.Size();i++) {
				SessionClient sc = singletonDBSession.getClients(i);
                try {
                    sc.session.getRemote().sendString("from  = " + sc.login +" "+ answerFromServer);
                }catch (IOException e)
                {

                }
		}
        return null;
    }
}
