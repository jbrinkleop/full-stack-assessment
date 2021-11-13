package com.observepoint.test.test.controller;

import com.observepoint.test.test.service.DepartmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "*")
public class DepartmentDetailsController {

    @Autowired
    DepartmentDetailsService departmentService;

    @GetMapping("/getDepartmentNames")
    public List<String> getDepartmentNames(){
        return departmentService.getDepartmentNames();
    }
}
