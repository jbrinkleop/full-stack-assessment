import { Component, OnInit, Output, EventEmitter, ViewChild } from '@angular/core';
import { DepartmentDetails } from '../../interfaces/department-details.interface';
import { DepartmentsService } from '../../services/departments.service';
import { EmployeeService } from '../../services/employee.service';
import { EmployeeDetails } from '../../interfaces/employee-details.interface';
import { Form } from '../../interfaces/employee-details.interface';
import { FormBuilder, Validators, FormGroup, FormGroupDirective } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import * as _moment from 'moment';
import { Moment } from 'moment';

const moment = _moment;

@Component({
  selector: 'app-add-employees',
  templateUrl: './add-employees.component.html',
  styleUrls: ['./add-employees.component.scss']
})
export class AddEmployeesComponent implements OnInit {

  @Output() refreshTable  = new EventEmitter();
  @ViewChild(FormGroupDirective) ngFormDirective: FormGroupDirective;

  public genders = ['Male', 'Female', 'Transgender', 'Non-Binary', 'Not Disclosed'];
  public jobTitles = ['Software Engineer', 'Analyst', 'Accountant', 'Manager', 'Director', 'CEO'];
  public departments: DepartmentDetails[] = [];
  

  public employeeForm = this.formBuilder.group({
    firstName: ['', [Validators.required]],
    lastName:  ['', [Validators.required]],
    gender:  ['', [Validators.required]],
    department:  ['', [Validators.required]],
    jobTitle:  ['', [Validators.required]],
    serviceDate:  ['', [Validators.required]]
  });

  constructor(
    private departmentService: DepartmentsService,
    private employeeService: EmployeeService,
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.getDepartments();
  }

  public getDepartments(): void{
    this.departmentService.getDepartments().subscribe((departments: DepartmentDetails[]) => {
      this.departments = departments;
    }, (error: Error) => {
    });
  }

  public formatFormEntries(formValues: Form ):EmployeeDetails {
    let department = this.departments.filter(dept => {
      return (dept.deptName === formValues.department);
    });
    let date = formValues.serviceDate.getDate();
    formValues.serviceDate.getDate();
    let employeeDetails =  {
      firstName: formValues.firstName,
      lastName: formValues.lastName,
      jobTitle: formValues.jobTitle,
      gender: formValues.gender,
      department: department[0],
      empStatus: 'Active',
      serviceDate: moment(formValues.serviceDate.toDateString()).format("yyyy-MM-DD")
    }
    return employeeDetails;
  }

  public addEmployee(formValues: Form): void {
    let employeeDetails = this.formatFormEntries(formValues);
    this.employeeService.addEmployeeDetails(employeeDetails).subscribe(() => {
      this.snackBar.open('Employee details were saved successfully', 'OK', {
        duration: 5000
      });
      this.refreshEmployeeDetails();
    }, error => {
      this.snackBar.open('Something went wrong. Employee details were not saved', 'OK', {
        duration: 5000
      });
    });
    this.resetForm();
  }

  public refreshEmployeeDetails(){
    this.refreshTable.emit();
  }

  public resetForm(){
    this.ngFormDirective.resetForm();
    this.employeeForm.reset(); 
  }


}
