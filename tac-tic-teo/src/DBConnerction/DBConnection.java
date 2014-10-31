/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnerction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DBConnection {

    private static DBConnection dBConnection = null;
    private Connection connection;

    private  DBConnection() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/tacTicToe", "root", "123456789");
        
    }
    
    public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException{
    
        if(dBConnection==null)
            dBConnection = new DBConnection();
        
        return dBConnection;
    }
    
    public Connection getConnection(){
        System.out.println("okkkkkkkkkk");
        return connection;
    }
    
    
    
    
}
