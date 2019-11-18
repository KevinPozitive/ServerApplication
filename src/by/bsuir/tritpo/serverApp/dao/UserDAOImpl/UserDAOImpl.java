package by.bsuir.tritpo.serverApp.dao.UserDAOImpl;

import by.bsuir.tritpo.serverApp.User;
import by.bsuir.tritpo.serverApp.dao.UsersDAO;
import by.bsuir.tritpo.serverApp.dao.dBConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UsersDAO {
    private Connection connection;
    private PreparedStatement stm;

    public UserDAOImpl() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }

    @Override
    public boolean add(User user) throws SQLException{
        String sql="INSERT INTO users ( nickname, password ) VALUES (?,?)";
        stm=connection.prepareStatement(sql);
        stm.setString(1,user.getUsername());
        stm.setString(2,user.getPassword());
        stm.addBatch();
        return stm.executeUpdate()>0;
    }
    @Override
    public boolean delete(String name) throws SQLException{
        String sql="DELETE FROM users WHERE username=?";
        stm=connection.prepareStatement(sql);
        stm.setObject(1,name);
        return stm.executeUpdate()>0;
    }
    @Override
    public ArrayList<User> getAll() throws SQLException{
        ArrayList<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM users";
        stm = connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        while (rst.next()){
            users.add(
                    new User(
                            rst.getString(1), rst.getString(2)
                    )
            );
        }
        return users;
    }

    @Override
    public User getUser(String name) throws SQLException {
        String sql="SELECT * FROM users WHERE nickname = '"+ name+"'";
        System.out.println(sql);
        stm = connection.prepareStatement(sql);
        ResultSet resultSet = stm.executeQuery();

        resultSet.beforeFirst();

        return resultSet.next() ? new User(resultSet.getString(1),resultSet.getString(2))
                : null;
    }
}
