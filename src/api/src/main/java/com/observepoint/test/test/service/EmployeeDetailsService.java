package com.observepoint.test.test.service;

import com.observepoint.test.test.dao.EmployeeDao;
import com.observepoint.test.test.model.Employees;
import com.observepoint.test.test.repository.IEmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeDetailsService {

    @Autowired
    IEmployeeDetails employeeDetailsRepo;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDetailsService departmentDetailsService;

    public List<Employees> getEmployeeDetails(){
        List<Employees> employeesList = employeeDetailsRepo.getEmployeeDetails();
        return employeesList;
    }

    public List<String> getMatchingEmailIds(String emailId){
        List<String> emailIds = employeeDetailsRepo.getExistingEmailIds(emailId);
        return emailIds;
    }

    public String generateUniqueEmailId(List<String> matchingEmailIds, String emailPrefix){
        String emailId;
        String emailDomain = "@observepoint.com";
        Integer matchingEmailCount = matchingEmailIds.size();
        // If Email ID already exists, append the next greatest number at the end of the name
        if (matchingEmailCount > 0) {
            emailPrefix = emailPrefix.concat(matchingEmailCount.toString());
        }
        emailId = emailPrefix+emailDomain;
        return emailId;
    }

    public void insertEmployee(Employees employee){
        String emailPrefix = employee.getFirstName().toLowerCase()+'.'+employee.getLastName().toLowerCase();
        List<String> matchingEmailIds  = getMatchingEmailIds(emailPrefix);
        String emailId = generateUniqueEmailId(matchingEmailIds, emailPrefix);
        employee.setEmailId(emailId);
        employeeDao.insertEmployeeDetails(employee);
    }

    public void deleteEmployee(Integer empId){
        employeeDao.deleteEmployeeDetails(empId);
    }

}
