package com.observepoint.test.entities;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class DepartmentEntity {
	@Id
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	private Integer revenue;
	
	public DepartmentEntity() {
		
	}
	
	public DepartmentEntity(int id,String name,Integer revenue) {
		this.id      = id;
		this.name    = name;
		this.revenue = revenue;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(String name) {
		this.name = name;
	}
	
	public int getRevenue() {
		return revenue;
	}
	
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
}
