import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { EmployeeDetails } from '../interfaces/employee-details.interface'

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {

  public employeeDetails: EmployeeDetails[] = [];
  public displayedColumns: string[] = ['empId', 'firstName', 'lastName', 'jobTitle', 'emailId', 'serviceDate', 'empStatus'];
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
