package by.bsuir.tritpo.serverApp;

import by.bsuir.tritpo.serverApp.Message;

import java.util.LinkedList;

public class MessageStory {
    private LinkedList<Message> story = new LinkedList<>();

    public void addStoryMsg(Message msg){
        if(story.size()>=10){
            story.removeFirst();
            story.add(msg);
        }else{
            story.add(msg);
        }
    }

    public LinkedList<Message> getStory(){
        if(story.size()>0){
            return story;
        }
        return null;
    }

    public Message getLastMsg(){
        if(story.size()>0){
            return story.getLast();
        }
        return null;
    }

    @Override
    public String toString() {
        String msg = "";
        for(Message unit: story){
            msg +=unit + "~";
        }
        msg.subSequence(0,msg.length()-1);
        return msg;
    }
}
