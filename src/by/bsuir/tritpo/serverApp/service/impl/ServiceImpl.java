package by.bsuir.tritpo.serverApp.service.impl;

import by.bsuir.tritpo.serverApp.MessageStory;
import by.bsuir.tritpo.serverApp.User;
import by.bsuir.tritpo.serverApp.dao.UserDAOImpl.UserDAOImpl;
import by.bsuir.tritpo.serverApp.dao.UsersDAO;
import by.bsuir.tritpo.serverApp.service.IChatService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ServiceImpl implements IChatService {
    private UsersDAO userDAO = new UserDAOImpl();
    private MessageStory msgStory = new MessageStory();

    public ServiceImpl() throws SQLException, ClassNotFoundException {
    }


    @Override
    public boolean addNewUser(User user) throws SQLException {
        return userDAO.add(user);
    }

    @Override
    public boolean checkUser(String name, String password) throws SQLException {
        User user = userDAO.getUser(name);
        if(user==null){
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public boolean isLoginReserved(String name) throws SQLException {
        User user = userDAO.getUser(name);
        if(user==null){
            return false;
        }
        return user.getUsername().equals(name);
    }

    @Override
    public ArrayList<User> getUsers() throws SQLException {
        ArrayList<User> users = userDAO.getAll();
        return users;
    }

    @Override
    public LinkedList<String> getMessages() {
        LinkedList<String> storyMsg = msgStory.getStory();
        return storyMsg;
    }

    @Override
    public String getLastMsg() {
        String lastMsg = msgStory.getLastMsg();
        return lastMsg;
    }

    public void setMsgStory(String msg) {
        msgStory.addStoryMsg(msg);
    }
}
