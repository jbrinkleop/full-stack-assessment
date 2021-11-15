package com.observepoint.test.test.repository;

import com.observepoint.test.test.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeDetails extends JpaRepository<Employees, Integer> {


    @Query(value = "SELECT * FROM employees emp INNER JOIN departments dept on emp.dept_id = dept.id", nativeQuery = true)
    List<Employees> getEmployeeDetails();

    @Query(value = "SELECT emp.email_id FROM employees emp WHERE emp.email_id LIKE ?1%", nativeQuery = true)
    List<String> getExistingEmailIds(String emailId);

    @Query(value = "SELECT emp.dept_id FROM employees emp where id = ?1", nativeQuery = true)
    Integer getDeptId(Integer empId);

    @Modifying
    @Query(value = "UPDATE EMPLOYEES emp SET emp.dept_id = null where id = ?1", nativeQuery = true)
    void updateDeptId(Integer empId);

}
