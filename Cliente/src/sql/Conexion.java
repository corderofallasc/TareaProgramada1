package sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public int Registrar(String user, String password) {
        try {
            Connection sql = getConnection();

            // Llamada al procedimiento almacenado
            CallableStatement callableStatement = sql.prepareCall("{call Registrar (?,?)}");

            // Parametro 1 del procedimiento almacenado
            callableStatement.setString(1, user);
            callableStatement.setString(2, password);

            // Ejecuta el procedimiento almacenado
            callableStatement.execute();
            sql.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return 0;
        }
    }
    
    public int IniciarSesion(String user, String password) {
        try {
            Connection sql = getConnection();

            // Llamada al procedimiento almacenado
            CallableStatement callableStatement = sql.prepareCall("{call LoginUser (?,?)}");

            // Parametro 1 del procedimiento almacenado
            callableStatement.setString(1, user);
            callableStatement.setString(2, password);

            // Ejecuta el procedimiento almacenado
            callableStatement.execute();
            sql.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return 0;
        }
    }

    public static Connection getConnection() {
        try {
            //llamar el driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionString = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=ProyectoRedes1;"
                    + "user=corde;"
                    + "password=criscf02012000;";
            Connection con = DriverManager.getConnection(connectionString);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
