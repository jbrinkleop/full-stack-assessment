import { Component, OnInit, ChangeDetectorRef, Output, EventEmitter } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { EmployeeDetails, EmployeeDetailsResponse, EmployeeUpdateDetails } from '../../interfaces/employee-details.interface';
import { FormBuilder, Validators, FormGroup, FormGroupDirective } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-employees',
  templateUrl: './employees-home.component.html',
  styleUrls: ['./employees-home.component.scss']
})
export class EmployeesHomeComponent implements OnInit {

  
  public employeeDetails: EmployeeDetails[] = [];
  public displayedColumns: string[] = ['empId', 'firstName', 'lastName', 'gender', 'department.deptName', 'jobTitle', 'emailId', 'dateOfBirth', 'delete'];
  public showSpinner = true;
  public jobTitles: string[];

  constructor(
    private employeeService: EmployeeService,
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.fetchEmployeeDetails();
    this.getJobTitles();
  }

  public employeeForm = this.formBuilder.group({
    jobTitle:  [''],
  });

  public fetchEmployeeDetails(){
    this.employeeService.getEmployeeDetails().subscribe((employee: EmployeeDetailsResponse) => {
      if(employee.employeeList !== null){
        this.employeeDetails = employee.employeeList;
        this.initializeEditableFlag();
      } else {
        this.snackBar.open(employee.message, 'OK', {
          duration: 5000
        });
      }
      this.showSpinner = false;
    }, (error: Error) => {
      this.showSpinner = false;
    });
  }

  private initializeEditableFlag(){
    this.employeeDetails.map((employee) => {
      employee.isEditable = false;
    });
  }

  public getJobTitles(){
    this.employeeService.getJobTitles().subscribe(jobs => {
      this.jobTitles = jobs;
    }, (error) => {
      this.snackBar.open('Something went wrong. Cannot get job titles', 'OK', {
        duration: 5000
      });
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

  public editEmployee( element:EmployeeDetails){
    element.isEditable = true;
  }

  public cancelEdit(element: EmployeeDetails){
    element.isEditable = false;
  }

  public saveChanges(id: number, element:EmployeeDetails, formValue: EmployeeUpdateDetails) {
    let editedDetails: EmployeeUpdateDetails = {empId: id, jobTitle: formValue.jobTitle}
    this.employeeService.editEmployeeDetails(editedDetails).subscribe(() => {
      this.snackBar.open('Changes saved successfully', 'OK', {
        duration: 5000
      });
      this.fetchEmployeeDetails();
    }, error => {
      this.snackBar.open('Something went wrong. Changes were not saved', 'OK', {
        duration: 5000
      });
    });    
    element.isEditable = false;
  }

}
