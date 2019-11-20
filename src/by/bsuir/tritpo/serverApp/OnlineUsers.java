package by.bsuir.tritpo.serverApp;

import java.util.LinkedList;
import java.util.List;

public class OnlineUsers {
    private static LinkedList<String> names = new LinkedList<>();

    public void setName(String name){
        names.add(name);
    }

    public void removeName(String name){
        names.remove(name);
    }

    public String getOnlineUsers(){
        String str = "";
        for(String user:names){
           str+=user+"~";
        }
        str.substring(0,names.size()-1);

        return str;
    }
}
