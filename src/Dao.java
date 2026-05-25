import java.sql.*;
import java.util.ArrayList;

public class Dao {
    Connection conn;
    public Dao(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<EmployeeEntity> addData(EmployeeEntity employee) {
        String sql = "insert into employee (employee_name,age,department_id) values (?,?,?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int changeNum = 0;

        try{
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,"高村");
            stmt.setInt(2,24);
            stmt.setInt(3,2);
            stmt.executeUpdate();




        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return viewData();
    }

    public ArrayList<EmployeeEntity> deleteData() throws SQLException {
        String sql = "delete from employee where employee_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,3);
        stmt.executeUpdate();

        return viewData();
    }

    public ArrayList<EmployeeEntity> viewData() {
        ArrayList<EmployeeEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(); // 検索なので executeQuery

            // 以前練習した「矢印を1行ずつ進めるループ」で箱に詰めていく
            while (rs.next()) {
                EmployeeEntity emp = new EmployeeEntity();
                emp.setEmployee_id(rs.getInt("employee_id"));
                emp.setEmployee_name(rs.getString("employee_name"));
                emp.setAge(rs.getInt("age"));
                emp.setDepartment_id(rs.getInt("department_id"));

                // リストにどんどん追加
                list.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        }

        return list; // 全件入ったリストを返す
    }

    public void finish() {

    }


}
