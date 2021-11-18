package com.observepoint.test.test.controller;

import com.observepoint.test.test.model.Departments;
import com.observepoint.test.test.model.Diversity;
import com.observepoint.test.test.model.Employees;
import com.observepoint.test.test.model.ServerResponse;
import com.observepoint.test.test.service.DepartmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin
public class DepartmentDetailsController {

    @Autowired
    DepartmentDetailsService departmentService;

    @GetMapping("/getDepartments")
    public List<Departments> getDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/reports/getDiversity")
    public List<Diversity> getDiversityByDepartment() {
        return departmentService.getDiversityByDepartment();
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<ServerResponse> insertEmployee (@RequestBody Departments department){
        ServerResponse serverResponse = departmentService.insertDepartment(department);
        return ResponseEntity.ok().body(serverResponse);
    }
}
