package com.observepoint.test.entities;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private int dep_id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String email;
	
	private String gender = "";
	
	private Integer rating = 0;
	
	private Integer absences = 0;
	
	public Employee() {
		
	}
	
	public Employee(Integer id,int dep_id,String name,String email,String gender,Integer rating,Integer absences) {
		this.id        = id;
		this.dep_id    = dep_id;
		this.name      = name;
		this.absences  = absences;
		this.rating    = rating;
		this.gender    = gender;
		this.email     = email;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public int getDep_id() {
		return dep_id;
	}
	
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getRating() {
		return rating;
	}
	
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	public int getAbsences() {
		return absences;
	}
	
	public void setAbsences(Integer absences) {
		this.absences = absences;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
}
