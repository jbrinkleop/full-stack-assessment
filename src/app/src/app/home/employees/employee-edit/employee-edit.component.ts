import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatFormFieldControl } from '@angular/material/form-field';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from 'src/app/models/Department';
import { Employee } from 'src/app/models/Employee';
import { DepartmentServiceService } from 'src/app/service/department-service.service';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.scss']
})
export class EmployeeEditComponent implements OnInit {
  routeId = ''; 
  departmentOptions : Department[]   = [];
  formGroup: FormGroup = new FormGroup({});
  loading: boolean = false;
  employee: Employee;

  constructor(
    private employeeService: EmployeeServiceService,
    private departmentService: DepartmentServiceService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    public router: Router,
  ) { 
    this.employee = {} as Employee;
  }

  async ngOnInit() {
    this.routeId = this.route.snapshot.paramMap.get('id') || '';
    await this.fetchDepartmentOptions();
    this.employeeService.fetchEmployeeById(this.routeId)
      .then(
        (data) => {
          this.employee = data as Employee;
          this.loading = false;

          // this.formGroup = this.formBuilder.group({
          //   id: new MatFormFieldControl<number>(this.employee.id,[Validators.required]),
          //   dep_id: new FormControl(this.employee.dep_id,[Validators.required]),
          //   name: new FormControl(this.employee.name,[Validators.required,Validators.minLength(1)]),
          //   email : new FormControl(this.employee.email,[Validators.required,Validators.minLength(1)]),
          //   gender: new FormControl(this.employee.gender),
          //   rating : new FormControl(this.employee.rating,[Validators.required,Validators.min(0),Validators.max(10)]),
          //   absences: new FormControl(this.employee.absences,[Validators.min(0)]),
          // });
        },
        (error) => {
          this.loading = false;
        }
      );
  }

  async fetchDepartmentOptions(){
    this.departmentOptions = await this.departmentService.fetchAllDepartments();
  }

  onSubmit(){
    const id = this.employee.id;
    this.employeeService.updateEmployee(id,this.employee).then(
      (data : Employee) => {
        const msg = `Modified Employee ${data.name}`;
        alert(msg);
      },
      (error) => {
        console.log(error);
        alert('Failed to Update Employee Record');
      }
    );
  }

  delete(){
    const id = this.employee.id;
    this.employeeService.deleteEmployee(id)
      .then(
        (data) => {
          alert(`Removed Employee with Id: ${id}`);
          this.navigateToTable();
        },
      );
  }

  navigateToTable(){
    this.router.navigate(['employees'],{skipLocationChange:true})
  }
}
