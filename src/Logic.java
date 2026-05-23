import java.sql.Connection;

import java.sql.*;
public class Logic {
    private int process_number;
    public Logic(int procces_number) {
        this.process_number = procces_number;
    }

    public void choose_process() {
        Connection conn = null;
        ConnectDatabase connect = new ConnectDatabase();
        try {
            conn = connect.getConnection();
            System.out.println("接続成功");
            Dao dao = new Dao();

            if (this.process_number == 1) {
                dao.addData();
            } else if (this.process_number == 2) {
                dao.deleteData();
            } else if (this.process_number == 3) {
                dao.viewData();
            } else {
                dao.finish();
            }
        }
        catch(SQLException e) {
            e.printStackTrace();

        }
    }
}
