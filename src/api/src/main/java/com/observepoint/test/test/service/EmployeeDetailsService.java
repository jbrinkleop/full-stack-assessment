package com.observepoint.test.test.service;

import com.observepoint.test.test.model.Employees;
import com.observepoint.test.test.repository.IEmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDetailsService {

    @Autowired
    IEmployeeDetails employeeDetailsRepo;

    public List<Employees> getEmployeeDetails(){
        List<Employees> employeesList = employeeDetailsRepo.getEmployeeDetails();
        return employeesList;
    }
}
