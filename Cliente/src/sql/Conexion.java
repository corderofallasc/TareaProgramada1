package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    
    public static Connection getConnection(){
        String connectionString="jdbo:sqlserver://localhost:1433;"
            +"database:master;"
            +"user:sa;"
            +"password:1234;"
            +"loginTimeout:30";
        
        try {
            Connection con = DriverManager.getConnection(connectionString);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
