package com.observepoint.test.test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String deptName;
}
