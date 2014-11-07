package ro.teamnet.z2h.dao;

import ro.teamnet.z2h.domain.Employee;
import ro.teamnet.z2h.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by liviu.spiroiu on 11/3/14.
 */
public class EmployeeDao {

    public List<Employee> getAllEmployees(){
        List<Employee> ret=new ArrayList<Employee>();
        for(int i=0;i<50;i++){
            Employee employee=new Employee();
            employee.setId((long)i+1);
            employee.setFirstName("First Name"+i);
            employee.setLastName("Last Name"+i);
            employee.setSalary(2000d);
            employee.setPhoneNumber("02122334455");
            employee.setHireDate(new Date());
            employee.setEmail("email_"+i+"@z2h.ro");
            employee.setCommissionPoints(2004d);
            ret.add(employee);
        }

        return ret;
    }

    public Employee getById(Long id){
            Employee employee=new Employee();
            employee.setId((long)id+1);
            employee.setFirstName("First Name"+id);
            employee.setLastName("Last Name"+id);
            employee.setSalary(2000d);
            employee.setPhoneNumber("02122334455");
            employee.setHireDate(new Date());
            employee.setEmail("email_"+id+"@z2h.ro");
            employee.setCommissionPoints(2004d);

        return employee;
    }

    public ArrayList<Employee> getAllEmployees(Connection con) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Employee> employees = new ArrayList<Employee>();
        String selectAllFromTableString = "SELECT employee_id,first_name,last_name,salary,email,hire_date,phone_number,commission_pct FROM Employees";
        try {

            stmt = con.prepareStatement(selectAllFromTableString);

            rs = stmt.executeQuery(selectAllFromTableString);

            while (rs.next()) {
                Employee employee = new Employee();


                employee.setId(rs.getLong("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setHireDate(rs.getDate("hire_date"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setCommissionPoints(rs.getDouble("commission_pct"));

                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return employees;
    }

    public Employee getEmployeeById(Connection con, Long id){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Employee> employees = new ArrayList<Employee>();

        String selectAllFromTableString = "SELECT employee_id,first_name,last_name,salary,email,hire_date,phone_number,commission_pct FROM Employees" +
                                          " WHERE employee_id = " + id;
        try {

            stmt = con.prepareStatement(selectAllFromTableString);

            rs = stmt.executeQuery(selectAllFromTableString);

            while (rs.next()) {
                Employee employee = new Employee();


                employee.setId(rs.getLong("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setHireDate(rs.getDate("hire_date"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setCommissionPoints(rs.getDouble("commission_pct"));

                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return employees.size() > 0 ? employees.get(0) : null;
    }
	
	private Connection getConnection(String username, String password) {

        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@demo.teamnet.ro:1521:orcl",
                    username,
                    password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
	
}
