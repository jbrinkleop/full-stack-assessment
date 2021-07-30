package com.observepoint.test.repositories;

import java.util.List;
import com.observepoint.test.entities.DepartmentEntity;
import com.observepoint.test.models.DepartmentReportModel;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity,Integer>{
	@Query(" FROM DepartmentEntity d order by d.id ")
	public List<DepartmentEntity> findAll();
	
	@Query(" SELECT new com.observepoint.test.models.DepartmentReportModel("
			+ "d.id, d.name, AVG(e.rating), AVG(e.absences) "
			+ ") "
			+ " FROM DepartmentEntity d "
			+ " LEFT JOIN Employee e ON d.id=e.dep_id "
			+ " WHERE e.id IS NOT NULL "
			+ " GROUP BY d.id "
			+ " HAVING AVG(e.rating) > 5 ")
	public List<DepartmentReportModel> getReportTotals();
}