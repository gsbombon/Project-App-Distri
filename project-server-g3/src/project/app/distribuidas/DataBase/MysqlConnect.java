package project.app.distribuidas.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MysqlConnect {
    Connection con = null;
    public static Connection ConnectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lgh","","");
            /*
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lgh","root","100114");
            */
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}