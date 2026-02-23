package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gibson
 */
public class ConnectionDAO {
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver PostgreSQL não encontrado", e);
        }
    }

    private  final String DB_URL = "jdbc:postgresql://ep-dry-math-aignfga8.c-4.us-east-1.aws.neon.tech/medlab?sslmode=require";
    private  final String USER = "neondb_owner";
    private  final String PASSWORD = "npg_zjF3slfrhQN7";
  
   

    public Connection connect() throws SQLException {
    return DriverManager.getConnection(DB_URL, USER, PASSWORD);
}
}
