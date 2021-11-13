package com.observepoint.test.test.service;

import com.observepoint.test.test.repository.IDepartmentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentDetailsService {

    @Autowired
    IDepartmentDetails departmentDetails;

    public List<String> getDepartmentNames(){
        List<String> departmentNames = departmentDetails.getDepartmentNames();
        return departmentNames;
    }
}