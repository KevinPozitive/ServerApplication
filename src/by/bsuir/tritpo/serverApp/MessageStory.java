package by.bsuir.tritpo.serverApp;

import by.bsuir.tritpo.serverApp.Message;

import java.util.LinkedList;

public class MessageStory {
    private static LinkedList<Message> story = new LinkedList<>();

    public void addStoryMsg(Message msg){
        story.add(msg);
    }
    public String toStringFromIndex(int index){
        String str = "";
        if(story.size()==0){
            return "";
        }
        for(int i = index;i<story.size();i++){
            str += story.get(i).toString() + "~";
        }
        //str.substring(0,str.length()-1);
        return str;
    }
}
