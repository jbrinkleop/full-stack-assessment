import { Component, OnInit } from '@angular/core';
import { DepartmentsService } from '../services/departments.service';
import { DepartmentDetails} from '../interfaces/department-details.interface';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.scss']
})
export class DepartmentsComponent implements OnInit {

  public department: string;
  public departmentDetails: DepartmentDetails[];
  
  constructor(
    private departmentService : DepartmentsService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.getAllDepartments();
  }

  public getAllDepartments(){
    this.departmentService.getDepartments().subscribe((department)=>{
      this.departmentDetails = department;
    },(error) => {
      this.snackBar.open('Something went wrong. Cannot load departments.', 'OK', {
        duration: 5000
      });
    });
  }

  public addNewDepartment() {
    let department: DepartmentDetails = {deptName: ''};
    department.deptName = this.department;
    this.departmentService.addNewDepartment(department).subscribe((response) => {
      if(response.status){
        this.snackBar.open('Department is saved successfully', 'OK', {
          duration: 5000
        });
      } else {
        this.snackBar.open('No duplicate entries allowed', 'OK', {
          duration: 5000
        });
      }

      this.getAllDepartments();
    }, (error) => {
      this.snackBar.open('Something went wrong. Employee details were not saved', 'OK', {
        duration: 5000
      });
    })
  }
}
