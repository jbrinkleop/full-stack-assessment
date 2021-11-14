import { Component, OnInit } from '@angular/core';
import { DepartmentDetails } from '../../interfaces/department-details.interface';
import { DepartmentsService } from '../../services/departments.service';
import { FormBuilder, Validators, FormGroup, FormGroupDirective } from '@angular/forms';

@Component({
  selector: 'app-add-employees',
  templateUrl: './add-employees.component.html',
  styleUrls: ['./add-employees.component.scss']
})
export class AddEmployeesComponent implements OnInit {

  public genders = ['Male', 'Female', 'Transgender', 'Non-Binary', 'Not Disclosed'];
  public jobTitles = ['Software Engineer', 'Analyst', 'Accountant', 'Manager', 'Director', 'CEO'];
  public departments: DepartmentDetails[] = [];

  public employeeForm = this.formBuilder.group({
    firstName: ['', [Validators.required]],
    lastName:  ['', [Validators.required]],
    gender:  ['', [Validators.required]],
    department:  ['', [Validators.required]],
    jobTitle:  ['', [Validators.required]],
    dateOfJoining:  ['', [Validators.required]]
  });

  constructor(
    private departmentService: DepartmentsService,
    private formBuilder: FormBuilder,
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

  public addEmployee(): void {
    this.employeeForm.reset(); 
  }

}
