package com.observepoint.test.test.repository;

import com.observepoint.test.test.model.Departments;
import com.observepoint.test.test.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentDetails extends JpaRepository<Departments, Integer> {
    @Query(value = "SELECT name FROM departments", nativeQuery = true)
    List<String> getDepartmentNames();
}
