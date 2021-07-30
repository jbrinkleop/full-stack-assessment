package com.observepoint.test.models;

public class DepartmentReportModel {
	private int id;
	private String name;
	private int revenue;
	private Double averageRating;
	private Double totalAbsences;
	
	public DepartmentReportModel() {
		
	}
	
	public DepartmentReportModel(int id,String name,Double averageRating,Double totalAbsences) {
		this.id            = id;
		this.name          = name;
		this.revenue       = revenue;
		this.averageRating = averageRating;
		this.totalAbsences = totalAbsences;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	
	public void setAverageRating(Double averageRating) {
		this.averageRating= averageRating;
	}
	
	public Double getAverageRating() {
		return averageRating;
	}
	
	public void setTotalAbsences(Double totalAbsences) {
		this.totalAbsences = totalAbsences;
	}
	
	public Double getTotalAbsences() {
		return totalAbsences;
	}
}
