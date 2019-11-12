package by.bsuir.tritpo.serverApp.connection;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

public class ServerConnect extends Thread{
    private Socket socket;
    private BufferedReader in;
    private Logic logic;
    public ServerConnect(Socket socket) throws IOException {
        logic = new Logic(socket);
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        start();
    }

    @Override
    public void run(){
        String message;
        try {
            while (true){
                message = in.readLine();
//                if(message == "stop"){
//                    break;
//                }
                logic.processCommand(message);

            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                socket.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
