package com.observepoint.test.test.model.response;

import com.observepoint.test.test.model.Employees;
import com.observepoint.test.test.model.ServerResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeDetailsResponse extends ServerResponse {
    public EmployeeDetailsResponse(Boolean status, String message) {super(status, message);}
    private List<Employees> employeeList;
}
