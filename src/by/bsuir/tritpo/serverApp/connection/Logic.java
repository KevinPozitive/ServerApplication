package by.bsuir.tritpo.serverApp.connection;

import by.bsuir.tritpo.serverApp.Message;
import by.bsuir.tritpo.serverApp.MessageStory;
import by.bsuir.tritpo.serverApp.User;
import by.bsuir.tritpo.serverApp.service.impl.ServiceImpl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

public class Logic {
    private BufferedWriter out;
    private ServiceImpl service;
    private MessageStory messageStory;
    private String login = "";
    private Socket socket;

    public Logic(Socket socket) throws IOException, SQLException, ClassNotFoundException {
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.socket = socket;
        service = new ServiceImpl();
    }

    public void processCommand(String message) throws SQLException, IOException {
        String[] msg = message.split("~");
        for(String msgUnit: msg){
            System.out.println(msgUnit);
        }
        switch (msg[0]){
            case "msg":
                messageStory.addStoryMsg(new Message(login,msg[1]));
                break;
            case "log":
                System.out.println(msg[1]+"}{"+msg[2]);
                if(!(service.checkUser(msg[1], msg[2]))) {
                    System.out.println("true?");
                    out.write("true\n");
                    out.flush();
                    login = msg[1];
                    System.out.println("con");
                }
                else {
                    out.write("false\n");
                    out.flush();
                }
                break;
            case "reg":
                if(service.isLoginReserved(msg[1])==false) {
                    User user = new User(msg[1],msg[2]);
                    service.addNewUser(user);
                    out.write("true\n");
                    out.flush();
                    login = msg[1];
                }
                else {
                    out.write("false\n");
                    out.flush();
                }
                break;
            case "msgHistory":
                out.write("msgHistory~" + service.getMessages(Integer.parseInt(msg[1])));
                break;
            case "exit":
                //socket.close();
                //out.close();
                break;
            case "onlineUsers":
                for(User user: service.getUsers())
                    out.write(user.getUsername()+"~");
                break;
        }
    }

    private void send(String message){
        try {
            out.write(login + "~" + message +"\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
