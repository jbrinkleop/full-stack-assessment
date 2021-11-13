package com.observepoint.test.test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employees {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
   @Column(name = "first_name")
    private String firstName;

   @Column(name ="last_name")
    private String lastName;

   @Column(name = "email_id")
    private String emailId;

   @Column(name="dept_id")
   private Integer deptId;

   @Column(name="job_title")
    private String jobTitle;

   @Column(name="emp_status")
   private String empStatus;

   @Column(name = "service_date")
    private Date serviceDate;

   @Column(name = "end_date")
    private Date endDate;
}
