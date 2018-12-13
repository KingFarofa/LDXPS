
package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;



public class ConectaBD {
    
   private static final String url = "jdbc:mysql://localhost:3306/ldxps";
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection(url,"user","password");  
            } catch (ClassNotFoundException | SQLException ex) {
           throw new RuntimeException("Erro na Conexão", ex);
        }
    }
    
    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro " + ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro " + ex);
            }
        }
        closeConnection(con);
    }
    
     public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
               System.err.println("Erro " + ex);
            }
        }
        closeConnection(con, stmt);
    }
}
