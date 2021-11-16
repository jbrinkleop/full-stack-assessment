package com.observepoint.test.test.controller;

import com.observepoint.test.test.model.Employees;
import com.observepoint.test.test.model.ServerResponse;
import com.observepoint.test.test.model.UpdateRequest;
import com.observepoint.test.test.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/employee")
public class EmployeeDetailsController {

    @Autowired
    EmployeeDetailsService employeeService;

    @GetMapping("/getEmployeeDetails")
    public ResponseEntity<ServerResponse> getEmployeeDetails(){
        ServerResponse serverResponse =  employeeService.getEmployeeDetails();
        return ResponseEntity.ok().body(serverResponse);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<ServerResponse> insertEmployee (@RequestBody Employees employee){
        ServerResponse serverResponse = employeeService.insertEmployee(employee);
        return ResponseEntity.ok().body(serverResponse);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<ServerResponse> deleteEmployee(@PathVariable Integer id){
        ServerResponse serverResponse = employeeService.deleteEmployee(id);
        return ResponseEntity.ok().body(serverResponse);
    }

    @PostMapping("/editEmployeeDetails")
    public ResponseEntity<ServerResponse> editEmployeeDetails(@RequestBody UpdateRequest updateRequest){
        ServerResponse serverResponse = employeeService.updateEmployee(updateRequest.getEmpId(),updateRequest.getJobTitle());
        return ResponseEntity.ok().body(serverResponse);
    }

}
