package com.example.demo.repository;


import com.example.demo.model.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;


public interface EmployeeRepository {
    public void insertEmployee(Employee employee);

    public void updateWithId(Employee employee);

    public void deleteWithId(Long employeeID) throws SQLException;

    public void departmentList() throws ClassNotFoundException, SQLException;
}
