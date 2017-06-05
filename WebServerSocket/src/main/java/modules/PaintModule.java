package modules;

import com.google.gson.Gson;
import rooms.ChatModuleRoom;
import rooms.PaintModuleRoom;
import web.server.SessionClient;
import web.server.SingletonDBSession;

import java.io.IOException;
import java.util.ArrayList;

public class PaintModule extends Thread implements IModule {

    SingletonDBSession singletonDBSession    = null;
    ArrayList<PaintModuleRoom> paintModuleRoom = null;
    Gson gson                                = null;
    private static final String  allRooms    = "allRooms";
    private static final String  newRoom   = "newRoom";
    private static final String  draw = "draw";

    public PaintModule() {
        singletonDBSession = SingletonDBSession.getInstance();
        paintModuleRoom = new ArrayList<PaintModuleRoom>();
        gson = new Gson();
        start();
    }

    @Override
    public  String runCommand(String str)
    {
        System.out.println("str = "+ str);
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
            PaintModuleRoom newR = new PaintModuleRoom(args[3]);
            paintModuleRoom.add(newR);
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
        if (args[2].equals(draw)) {
            String nameRoom      = args[3];
            PaintModuleRoom room = null;
            for(PaintModuleRoom r : paintModuleRoom )
            {
                if(nameRoom.equals(r.roomsName))
                {
                    room =r;
                    break;
                }
            }
            if(room!= null)
            {
                System.out.println(" sc.indexOf = "+  str.indexOf("{") );
                System.out.println(" subscrin = "+  str.substring(str.indexOf("{")) );
                room.story += str.substring(str.indexOf("{")) + ";";
                System.out.println("  room.story = "+   room.story);
                String gsonRoom = draw + ":" + gson.toJson(room);
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
        result += gson.toJson(paintModuleRoom);
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
