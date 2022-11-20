package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepositoryImpl1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeServiceImpl1 implements EmployeeService {

    private EmployeeRepositoryImpl1 employeeRepository;

    @Autowired
    public EmployeeServiceImpl1(EmployeeRepositoryImpl1 employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public ResponseEntity<List<Employee>> insertEmployee(Employee employee) {
        employeeRepository.insertEmployee(employee);
        return new ResponseEntity<>(List.of(employee), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Employee>> updateWithId(Employee employee) {

        employeeRepository.updateWithId(employee);
        return new ResponseEntity<>(List.of(employee), HttpStatus.ACCEPTED);
    }

    @Override
    public void departmentList() throws SQLException, ClassNotFoundException {

        employeeRepository.departmentList();
    }

    @Override
    public ResponseEntity<String> deleteWithId(Long employeeID) throws SQLException {
        employeeRepository.deleteWithId(employeeID);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
