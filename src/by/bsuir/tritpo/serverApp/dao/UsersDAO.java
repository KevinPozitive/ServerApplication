package by.bsuir.tritpo.serverApp.dao;

import by.bsuir.tritpo.serverApp.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UsersDAO {
    boolean add(User user) throws SQLException;
    boolean delete(String name) throws SQLException;
    ArrayList<User> getAll() throws SQLException;
    User getUser(String name) throws SQLException;
}
