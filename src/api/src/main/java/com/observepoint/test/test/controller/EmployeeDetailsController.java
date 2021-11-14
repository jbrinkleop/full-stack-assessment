package com.observepoint.test.test.controller;

import com.observepoint.test.test.model.Employees;
import com.observepoint.test.test.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/employee")
public class EmployeeDetailsController {

    @Autowired
    EmployeeDetailsService employeeService;

    @GetMapping("/getEmployeeDetails")
    public List<Employees> getEmployeeDetails(){
        return employeeService.getEmployeeDetails();
    }

    @PostMapping("/addEmployee")
    public void insertEmployee (@RequestBody Employees employee){
        employeeService.insertEmployee(employee);
    }
}
