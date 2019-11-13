/* @Author : Amrit Raj
 Student Id : 1001723851
*/
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnect {
    
    public static Connection createConnection() throws ClassNotFoundException,SQLException
    {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String dburl = "jdbc:oracle:thin:@//acaddbprod-1.uta.edu:1523/pcse1p.data.uta.edu";
            String username="axl3851";
            String password="Ninetells1234";
            Connection con =DriverManager.getConnection(dburl, username, password);
            
             if (con!=null) {
			System.out.println("connected");
                        
		}
		else {
			System.out.println(" not connected");
		}
        return con;
    }
}
