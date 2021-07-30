package com.observepoint.test.repositories;

import java.util.List;
import java.util.Optional;
import com.observepoint.test.entities.Employee;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
	@Query(" FROM Employee e order by e.id ")
	public List<Employee> findAll();
	
	public Optional<Employee> findById(int id);
}