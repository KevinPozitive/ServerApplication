package by.bsuir.tritpo.serverApp.dao.dBConnection;

import by.bsuir.tritpo.serverApp.dao.dBConnection.dbConfigs.Configs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("settings.properties");
        String setDB=String.format("jdbc:mysql://"+ Configs.dbHost +":"+Configs.dbPort +"/"+Configs.dbName+"+?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(setDB,Configs.dbUser,Configs.dbPass);
        System.out.println(connection);
        return connection;
    }
}
