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

import com.observepoint.test.repositories.DepartmentRepository;
import com.observepoint.test.entities.DepartmentEntity;

import com.observepoint.test.models.DepartmentReportModel;
@RestController
public class DepartmentsController {
	@Autowired
	private final DepartmentRepository repository;
	
	public DepartmentsController(DepartmentRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin
	@RequestMapping(value="/departments/all",consumes= {"application/json"},method=RequestMethod.GET)
	public ResponseEntity<List<DepartmentEntity>> getDepartmentAll() {
		
		List<DepartmentEntity> entities = repository.findAll();
		return new ResponseEntity<List<DepartmentEntity>>(entities,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/department/{id}",consumes= {"application/json"},method=RequestMethod.GET)
	public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable("id") Integer id) {
		Optional<DepartmentEntity> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			return new ResponseEntity<DepartmentEntity>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DepartmentEntity>(entityOptional.get(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/reports/bydepartment",method=RequestMethod.GET)
	public ResponseEntity<List<DepartmentReportModel>> getReportData(){
		List<DepartmentReportModel> models = repository.getReportTotals();
		return new ResponseEntity<List<DepartmentReportModel>>(models,HttpStatus.OK);
	}
}
