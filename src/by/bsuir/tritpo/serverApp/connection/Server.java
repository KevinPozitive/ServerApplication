package by.bsuir.tritpo.serverApp.connection;

import by.bsuir.tritpo.serverApp.connection.configs.Configs;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.LinkedList;

public class Server {
    public static LinkedList<ServerConnect> serverList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Configs.PORT);
        try {
            while (true){
                System.out.println("Server Started");
                Socket socket = serverSocket.accept();
                try {
                    serverList.add(new ServerConnect(socket));
                }catch (IOException e){
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } finally {

            serverSocket.close();
            System.out.println("Error");
        }
    }
}
