package com.observepoint.test.test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;


public interface Diversity {

    String getGender();
    Integer getGenderCount();
    String getDeptName();

}
