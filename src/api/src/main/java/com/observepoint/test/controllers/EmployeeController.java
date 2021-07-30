package com.observepoint.test.controllers;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.observepoint.test.repositories.EmployeeRepository;
import com.observepoint.test.entities.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private final EmployeeRepository repository;
	
	public EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin
	@RequestMapping(value="/employees/all",consumes= {"application/json"},method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> getDepartmentAll() {
		
		List<Employee> entities = repository.findAll();
		return new ResponseEntity<List<Employee>>(entities,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/employee/{id}",consumes= {"application/json"},method=RequestMethod.GET)
	public ResponseEntity<Employee> getDepartmentById(@PathVariable("id") Integer id) {
		Optional<Employee> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(entityOptional.get(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/employee/{id}",consumes= {"application/json"},method=RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id,@RequestBody Employee employee) {
		Optional<Employee> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		Employee fetched = entityOptional.get();
		fetched.setId(fetched.getId());
		Employee updated = repository.save(employee);
		return new ResponseEntity<Employee>(updated,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/employees",consumes= {"application/json"},method=RequestMethod.POST)
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee body){
		body.setId(null);
		Employee saved  = repository.save(body);
		return new ResponseEntity<Employee>(body,HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value="/employee/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteEmployee(@PathVariable("id") Integer id) {
		Optional<Employee> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		Employee fetched = entityOptional.get();
		repository.delete(fetched);
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
	
}
