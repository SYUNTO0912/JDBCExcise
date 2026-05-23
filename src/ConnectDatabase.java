import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    String url = "jdbc:mariadb://localhost:3306/employees";
    String username = "root";
    String password = "syunto0912";

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn= DriverManager.getConnection(this.url,this.username,this.password);

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
        return conn;

    }
}
