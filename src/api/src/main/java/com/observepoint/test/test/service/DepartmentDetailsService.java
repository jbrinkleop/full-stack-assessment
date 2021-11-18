package com.observepoint.test.test.service;

import com.observepoint.test.test.dao.DepartmentDao;
import com.observepoint.test.test.model.Departments;
import com.observepoint.test.test.model.Diversity;
import com.observepoint.test.test.model.ServerResponse;
import com.observepoint.test.test.repository.IDepartmentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentDetailsService {

    @Autowired
    IDepartmentDetails departmentDetails;

    @Autowired
    DepartmentDao departmentDao;

    public List<Departments> getAllDepartments() {
        return departmentDetails.findAll();
    }

    public List<Diversity> getDiversityByDepartment() {
        return departmentDetails.getDiversityByDepartment();
    }

    public ServerResponse insertDepartment(Departments department){
        try{
            departmentDao.insertDepartment(department);
            return new ServerResponse(true, null);
        } catch(Exception e){
            return  new ServerResponse(false,"Failed to insert department");
        }
    }

}
