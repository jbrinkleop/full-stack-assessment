package com.observepoint.test.test.dao;

import com.observepoint.test.test.model.Employees;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertEmployeeDetails(Employees employee){
        this.entityManager.persist(employee);
    }


}
