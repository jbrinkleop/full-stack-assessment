import { Component, OnInit, ChangeDetectorRef, Output, EventEmitter } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { EmployeeDetails, EmployeeDetailsResponse } from '../../interfaces/employee-details.interface';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-employees',
  templateUrl: './employees-home.component.html',
  styleUrls: ['./employees-home.component.scss']
})
export class EmployeesHomeComponent implements OnInit {

  public employeeDetails: EmployeeDetails[] = [];
  public displayedColumns: string[] = ['empId', 'firstName', 'lastName', 'gender', 'department.deptName', 'jobTitle', 'emailId', 'serviceDate', 'empStatus', 'delete'];
  public showSpinner = true;

  constructor(
    private employeeService: EmployeeService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.fetchEmployeeDetails();
  }

  public fetchEmployeeDetails(){
    this.employeeService.getEmployeeDetails().subscribe((employee: EmployeeDetailsResponse) => {
      this.employeeDetails = employee.employeeList;
      this.showSpinner = false;
    }, (error: Error) => {
      this.showSpinner = false;
    });
  }

  public deleteEmployee(id: number){
    this.employeeService.deleteEmployeeById(id).subscribe(()=> {
      this.snackBar.open('Employee details were deleted successfully', 'OK', {
        duration: 5000
      });
      this.fetchEmployeeDetails();
    }, (error: Error) => {
      this.snackBar.open('Something went wrong. Employee details were not deleted', 'OK', {
        duration: 5000
      });
    });
  }


}
