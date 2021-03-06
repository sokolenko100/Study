package modules;

import com.google.gson.Gson;
import data.SingletonDBModule;
import rooms.ChatModuleRoom;
import web.server.SessionClient;
import web.server.SingletonDBSession;

import java.io.IOException;
import java.util.ArrayList;

public class ChatModule extends Thread implements IModule {

    SingletonDBSession singletonDBSession    = null;
    ArrayList<ChatModuleRoom> chatModuleRoom = null;
    Gson gson                                = null;
    private static final String  allRooms    = "allRooms";
    private static final String  newRoom   = "newRoom";
    private static final String  sendMassege = "sendMessage";

    public ChatModule() {
        singletonDBSession = SingletonDBSession.getInstance();
        chatModuleRoom = new ArrayList<ChatModuleRoom>();
        gson = new Gson();
        start();
    }

    @Override
    public  String runCommand(String str)
    {
        String [] args = str.split(":");
        String from = args[0];
        String to = args[1];
        String command = args[2];
        int id = Integer.parseInt(from);
        SessionClient sc = singletonDBSession.getClient(id);
        if (args[2].equals("setLogin")) {
            if(sc !=null) {
                sc.login = args[3];
                try {
                    sc.session.getRemote().sendString(getAllRooms());
                } catch (IOException e) {}
            }
            return null;
        }
        if (args[2].equals(newRoom)) {
            ChatModuleRoom newR = new ChatModuleRoom(args[3]);
            chatModuleRoom.add(newR);
            String answerFromServer = newRoom + ":" + gson.toJson(newR);
            for (int i = 0;i < singletonDBSession.Size();i++) {
                SessionClient scl = singletonDBSession.getClients(i);
                try {
                    if(sc != scl) {
                        scl.session.getRemote().sendString(answerFromServer);
                    }
                }catch (IOException e){}
            }
        }
        if (args[2].equals(sendMassege)) {
            String nameRoom     = args[3];
            ChatModuleRoom room = null;
            for(ChatModuleRoom r : chatModuleRoom )
            {
                if(nameRoom.equals(r.roomsName))
                {
                    room =r;
                    break;
                }
            }
            if(room!= null)
            {
                room.story += sc.login + ": " + args[4] + "\n";
                String gsonRoom = sendMassege + ":" + gson.toJson(room);
                for (int i = 0;i < singletonDBSession.Size();i++) {
                    SessionClient scl = singletonDBSession.getClients(i);
                    try {
                            scl.session.getRemote().sendString(gsonRoom);
                    }catch (IOException e){}
                }
            }
        }
        return null;
    }
    public String getAllRooms()
    {
        String  result = allRooms+":";
        result += gson.toJson(chatModuleRoom);
        System.out.print("result = "+ result);
        return  result;
    }
    @Override
    public void run()
    {
        while (true)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
