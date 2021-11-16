package com.observepoint.test.test.service;

import com.observepoint.test.test.dao.EmployeeDao;
import com.observepoint.test.test.model.Employees;
import com.observepoint.test.test.model.ServerResponse;
import com.observepoint.test.test.model.response.EmployeeDetailsResponse;
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

    public ServerResponse getEmployeeDetails(){
        try {
            List<Employees> employeesList = employeeDetailsRepo.getEmployeeDetails();
            if (employeesList.size() > 0 ){
                EmployeeDetailsResponse employeeDetailsResponse = new EmployeeDetailsResponse(true, null);
                employeeDetailsResponse.setEmployeeList(employeesList);
                return employeeDetailsResponse;
            } else {
                return new EmployeeDetailsResponse(false, "No employee details found");
            }
        } catch (Exception e) {
            return new EmployeeDetailsResponse(false, "Failed to retrieve employee details");
        }
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

    public ServerResponse insertEmployee(Employees employee){
        try {
            String emailPrefix = employee.getFirstName().toLowerCase()+'.'+employee.getLastName().toLowerCase();
            List<String> matchingEmailIds  = getMatchingEmailIds(emailPrefix);
            String emailId = generateUniqueEmailId(matchingEmailIds, emailPrefix);
            employee.setEmailId(emailId);
            employeeDao.insertEmployeeDetails(employee);
            return new ServerResponse(true, "Employee inserted successfully");
        } catch (Exception e){
            return new ServerResponse(false, "Employee insertion failed");
        }

    }

    public ServerResponse deleteEmployee(Integer empId){
        try {
            employeeDao.deleteEmployeeDetails(empId);
            return new ServerResponse(true, "Deletion was successful");
        } catch (Exception exception){
           return new ServerResponse(false, "Deletion failed");
        }
    }

    @Transactional
    public ServerResponse updateEmployee(Integer empId, String jobTitle){
        try{
            employeeDetailsRepo.updateEmployee(empId, jobTitle);
            return new ServerResponse(true, "Update was successful");
        } catch (Exception exception){
            return new ServerResponse(false, "Update Failed");
        }
    }
}
