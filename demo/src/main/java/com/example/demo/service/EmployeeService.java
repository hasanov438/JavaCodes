package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    ResponseEntity<List<Employee>> insertEmployee(Employee employee);

    ResponseEntity<List<Employee>> updateWithId(Employee employeeId);

    void departmentList() throws SQLException, ClassNotFoundException;

    ResponseEntity<String> deleteWithId(Long employeeID) throws SQLException;

}
