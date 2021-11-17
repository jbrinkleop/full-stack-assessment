package com.observepoint.test.test.dao;

import com.observepoint.test.test.model.Departments;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DepartmentDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertDepartment(Departments department){
        this.entityManager.persist(department);
        this.entityManager.clear();
    }
}
