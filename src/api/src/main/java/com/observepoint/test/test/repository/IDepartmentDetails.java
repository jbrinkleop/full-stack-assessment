package com.observepoint.test.test.repository;

import com.observepoint.test.test.model.Departments;
import com.observepoint.test.test.model.Diversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentDetails extends JpaRepository<Departments, Integer> {

    @Query(value = "SELECT name FROM departments", nativeQuery = true)
    List<String> getDepartmentNames();

    @Query(value = "SELECT id FROM departments WHERE name = ?1", nativeQuery = true)
    Integer getDepartmentId(String deptName);

    @Query(value = "SELECT gender, COUNT (gender) as genderCount, (SELECT name FROM DEPARTMENTS DEPT WHERE DEPT.id = EMP.dept_id ) AS deptName FROM EMPLOYEES EMP GROUP BY (dept_id, gender)", nativeQuery = true)
    List<Diversity> getDiversityByDepartment();

}
