package nl.veltman.hrdbase;

import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class DatabaseManager {

    private static Connection conn=null;

    private static Connection getConnection() throws SQLException{
        if(conn==null){
            conn=DriverManager.getConnection(Application.HOST_NAME, Application.USER_NAME, Application.PASSWORD);
        }
        return conn;
    }

    protected static ArrayList<Department> getDepartments() throws SQLException{
        ArrayList<Department> department = new ArrayList<>();
        String sql = "SELECT d.department_id, d.department_name, d.manager_id, concat(e.first_name,' ',e.last_name) as manager_name FROM departments d join employees e on d.manager_id=e.employee_id;";

        try(PreparedStatement stmt = getConnection().prepareStatement(sql)) {

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3)+" "+res.getString(4));
                Department d = new Department();
                d.department_id = res.getInt(1);
                d.department_name = res.getString(2);
                d.manager_id = res.getInt(3);
                d.manager_name = res.getString(4);
                department.add(d);
            }
        }
        return department;
    }

    //ArrayList<Employees> employees = new ArrayList<>();
    //ArrayList<Department> department = new ArrayList<>();


//    public void select() {
//        String sql="SELECT employee_id, last_name, first_name, salary from employees order by employee_id";
//
//        try (   //dit is het resource gedeelte uit de foutafhandeling try/catch with resources
//                java.sql.Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
//                PreparedStatement stmt = conn.prepareStatement(sql)){
//            //stmt.setInt(1, departmentId);
//
//            try (ResultSet rs = stmt.executeQuery()) {//de preparedStatement wordt uitgevoerd en de output wordt in een resultSet gezet
//
//                while (rs.next()) {
//                    System.out.println(rs.getInt("employee_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name")+" "+rs.getInt("salary")+
//                            " "+rs.getInt("department_id"));
//
//                    //Door een Employees object aan te maken kan de output van de resultSet aan de velden worden toegewezen. Deze Employees objecten kunnen dan in een ArrayList worden opgeslagen
//                    Employees e = new Employees();
//                    e.employee_id=rs.getInt("employee_id");
//                    e.first_name = rs.getString("first_name");
//                    e.last_name = rs.getString("last_name");
//                    e.salary=rs.getInt("salary");
//                    e.department_id=rs.getInt("department_id");
//                    employees.add(e);
//                }
//                System.out.println("----------------------------------------------------");
//                System.out.println("The number of added employees to the arraylist: "+employees.size());
//            }
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());//getMessage() is een methode van de foutmeldingingen klasse en geeft een boodschap weer als er een SQLException optreed
//
//        }
//    }
//
//    protected static int updateOrCreateEmployee(Employees newData, boolean create) throws SQLException {
//        String sql = "";
//        int rv = -1;
//        if (create) {
//            sql = "INSERT INTO employees "+
//                    "(first_name, last_name, salary, department_id)" +
//                    "VALUES (?,?,?,?,?,?,?,?,?)";
//        } else {
//            sql = "UPDATE employees SET " +
//                    "first_name = ?, last_name = ?, salary = ?, department_id = ?";
//        }
//
//        try(java.sql.Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
//            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//            stmt.setString(1, newData.first_name);
//            stmt.setString(2, newData.last_name);
////            stmt.setString(3, newData.email);
////            stmt.setString(4, newData.phone_number);
////            stmt.setString(5, newData.hire_date);
////            stmt.setString(6, newData.job_id);
//            stmt.setInt(3, newData.salary);
////            stmt.setInt(8, newData.manager_id);
//            stmt.setInt(4, newData.department_id);
//            if (create) {
//                stmt.execute();
//                ResultSet keys = stmt.getGeneratedKeys();
//                if (keys.next()) rv = keys.getInt(1);
//            } else {
//                stmt.setInt(5, newData.employee_id);
//                stmt.execute();
//                rv =  stmt.getUpdateCount();
//            }
//        }
//        return rv;
//    }
//
//    public void getDepartments(){
//
//        String sql = "SELECT d.department_id, d.department_name, d.manager_id, concat(e.first_name,' ',e.last_name) as manager_name FROM departments d join employees e on d.manager_id=e.employee_id;";
//
//        try(
//                java.sql.Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            try (ResultSet res = stmt.executeQuery()) {
//
//                while (res.next()) {
//                    System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3)+" "+res.getString(4));
//                    Department d = new Department();
//                    d.department_id = res.getInt(1);
//                    d.department_name = res.getString(2);
//                    d.manager_id = res.getInt(3);
//                    d.manager_name = res.getString(4);
//                    department.add(d);
//                }
//            }
//            } catch(SQLException e){
//                    System.err.println(e.getMessage());
//                }
//
//            }


}