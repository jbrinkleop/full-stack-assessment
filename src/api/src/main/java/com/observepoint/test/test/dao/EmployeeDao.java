package com.observepoint.test.test.dao;

import com.observepoint.test.test.model.Departments;
import com.observepoint.test.test.model.Employees;
import com.observepoint.test.test.repository.IEmployeeDetails;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;

@Repository
public class EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    IEmployeeDetails employeeDetailsRepo;

    @Transactional
    public void insertEmployeeDetails(Employees employee){
        this.entityManager.persist(employee);
        this.entityManager.clear();
    }

    @Transactional
    public void deleteEmployeeDetails(Integer empId){
        // Set dep_id foreign key in Employees table to NULL to safely delete the row
        employeeDetailsRepo.updateDeptId(empId);
        // Delete the row
        Employees deleteEmployee = entityManager.find(Employees.class, empId);
        this.entityManager.remove(deleteEmployee);
        entityManager.flush();
        entityManager.clear();
    }




}
