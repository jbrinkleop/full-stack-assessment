import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { EmployeeDetails } from '../../interfaces/employee-details.interface'

@Component({
  selector: 'app-employees',
  templateUrl: './employees-home.component.html',
  styleUrls: ['./employees-home.component.scss']
})
export class EmployeesHomeComponent implements OnInit {

  public employeeDetails: EmployeeDetails[] = [];
  public displayedColumns: string[] = ['empId', 'firstName', 'lastName', 'gender', 'department.deptName', 'jobTitle', 'emailId', 'serviceDate', 'empStatus'];
  public showSpinner = true;

  constructor(
    private employeeService: EmployeeService
  ) { }

  ngOnInit(): void {
    this.fetchEmployeeDetails();
  }

  public fetchEmployeeDetails(){
    this.employeeService.getEmployeeDetails().subscribe((employee: EmployeeDetails[]) => {
      this.employeeDetails = employee;
      this.showSpinner = false;
    }, (error: Error) => {
      this.showSpinner = false;
    });
  }

}
