package by.bsuir.tritpo.serverApp;

import by.bsuir.tritpo.serverApp.Message;

import java.util.LinkedList;

public class MessageStory {
    private static LinkedList<Message> story = new LinkedList<>();

    public void addStoryMsg(Message msg){
        System.out.println(msg+"add");
        story.add(msg);
    }
    public String toStringFromIndex(int index){
        System.out.println(story.size()+"Size Story");
        String str = "";
        if(story.size()==0){
            return "";
        }
        for(int i = index;i<story.size();i++){
            str += story.get(i).toString() + "~";
            System.out.println(str+"create");
        }
        //str.substring(0,str.length()-1);
        return str;
    }
}
