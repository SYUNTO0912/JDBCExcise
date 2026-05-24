import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

public class Logic {
    private int process_number;
    public Logic(int process_number) {
        this.process_number = process_number;
    }
    EmployeeEntity employee = new EmployeeEntity();

    public void choose_process() {
        Connection conn = null;
        ConnectDatabase connect = new ConnectDatabase();
        try {
            conn = connect.getConnection();
            System.out.println("接続成功");
            Dao dao = new Dao(conn);

            ArrayList<EmployeeEntity> list = null;
            if (this.process_number == 1) {
                list = dao.addData(employee);
            } else if (this.process_number == 2) {
                list = dao.deleteData();
            } else if (this.process_number == 3) {
                list = dao.viewData();
            } else {
                dao.finish();
                return;
            }

            if (list != null) {
                for (EmployeeEntity emp : list) {
                    System.out.println("ID: " + emp.getEmployee_id() + ", Name: " + emp.getEmployee_name() + ", Age: " + emp.getAge());
                }
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
