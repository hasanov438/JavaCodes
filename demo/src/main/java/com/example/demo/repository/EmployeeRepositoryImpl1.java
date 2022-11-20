package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class EmployeeRepositoryImpl1 implements EmployeeRepository {

    @Value("${db.host.url}")
    private String dbHostUrl;
    @Value("${db.host.user}")
    private String dbUser;
    @Value("${db.host.password}")
    private String dbPassword;

    @Override
    public void departmentList() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");


        Connection connection = DriverManager.getConnection(dbHostUrl, dbUser, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select department_id,department_name,street_address,postal_code,city,state_province from departments inner join locations on departments.location_id=locations.location_id");
        while (resultSet.next()) {
            System.out.println(((("ID: " + resultSet.getInt("department_id"))
                    +
                    ("\tDepartment name: " + resultSet.getString("department_name"))
                    +
                    ("\tStreet address :" + resultSet.getString("street_address"))
                    +
                    ("\tPostal code :" + resultSet.getString("postal_code"))
                    +
                    ("\tCity :" + resultSet.getString("city"))
                    +
                    ("\tState province :" + resultSet.getString("state_province")))));
        }

    }

    @Override
    public void deleteWithId(Long employeeID) throws SQLException {
        try (Connection connection = DriverManager.getConnection(dbHostUrl, dbUser, dbPassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from employees where employee_id=?");
            preparedStatement.setLong(1, employeeID);
            preparedStatement.execute();
        }
    }

    @Override
    public void updateWithId(Employee employee) {
        try (Connection connection = DriverManager.getConnection(dbHostUrl, dbUser, dbPassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update employees" + " set first_name = ?," +
                            " last_name = ?," + " email = ?," + " phone_number = ?," +
                            " hire_date = ?," + " job_id = ?," +
                            " salary = ?," + "manager_id = ?," +
                            "department_id = ? where employee_id = ?");

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDate(5, employee.getHireDate());
            preparedStatement.setLong(6, employee.getJobId());
            preparedStatement.setInt(7, employee.getSalary());
            preparedStatement.setLong(8, employee.getManagerID());
            preparedStatement.setLong(9, employee.getDepartmentId());
            preparedStatement.setLong(10, employee.getEmployeeId());

            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection(dbHostUrl, dbUser, dbPassword);
        ) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into employees (employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,manager_id,department_id) values(?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setDouble(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setDate(6, employee.getHireDate());
            preparedStatement.setDouble(7, employee.getJobId());
            preparedStatement.setDouble(8, employee.getSalary());
            preparedStatement.setDouble(9, employee.getManagerID());
            preparedStatement.setDouble(10, employee.getDepartmentId());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
