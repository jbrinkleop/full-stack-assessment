package com.observepoint.test.test.repository;

import com.observepoint.test.test.model.JobTitles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobTitles extends JpaRepository<JobTitles, Integer> {

    @Query(value = "SELECT job_title FROM jobs", nativeQuery = true)
    List<String> getJobTitles();

}
