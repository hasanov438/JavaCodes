package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeServiceImpl1 employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl1 employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> createEmployee(@RequestBody Employee employee) {
        return employeeService.insertEmployee(employee);

    }

    @PutMapping("/update")
    public ResponseEntity<List<Employee>> updateWithId(@RequestBody Employee employee) {
        return employeeService.updateWithId(employee);
    }

    @DeleteMapping("/delete/{employeeID}")
    public ResponseEntity<String> deleteWithId(@PathVariable("employeeID") Long employeeID) throws SQLException {
        return employeeService.deleteWithId(employeeID);
    }

    @GetMapping("/departments")
    public void departmentList() throws SQLException, ClassNotFoundException {
        employeeService.departmentList();
    }

}
