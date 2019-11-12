package by.bsuir.tritpo.serverApp.service.impl;

import by.bsuir.tritpo.serverApp.Message;
import by.bsuir.tritpo.serverApp.MessageStory;
import by.bsuir.tritpo.serverApp.User;
import by.bsuir.tritpo.serverApp.dao.UserDAOImpl.UserDAOImpl;
import by.bsuir.tritpo.serverApp.dao.UsersDAO;
import by.bsuir.tritpo.serverApp.service.IChatService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ServiceImpl implements IChatService {
    private static volatile ServiceImpl instance;
    private UsersDAO userDAO = new UserDAOImpl();
    private MessageStory msgStory = new MessageStory();

    private ServiceImpl() throws SQLException, ClassNotFoundException {
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
    public static ServiceImpl getInstance() throws SQLException, ClassNotFoundException {
        if(instance==null){
            synchronized (ServiceImpl.class){
                if(instance==null){
                    instance = new ServiceImpl();
                }
            }
        }
        return instance;
    }

}
