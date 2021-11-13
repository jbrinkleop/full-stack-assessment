package com.observepoint.test.test.repository;

import com.observepoint.test.test.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeDetails extends JpaRepository<Employees, Integer> {
    @Query(value = "SELECT * FROM employees emp inner join departments dept on emp.dept_id = dept.id", nativeQuery = true)
    List<Employees> getEmployeeDetails();
}
