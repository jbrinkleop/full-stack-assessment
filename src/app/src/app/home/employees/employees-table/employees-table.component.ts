import { AfterViewInit } from '@angular/core';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/Employee';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';

@Component({
  selector: 'app-employees-table',
  templateUrl: './employees-table.component.html',
  styleUrls: ['./employees-table.component.scss']
})
export class EmployeesTableComponent implements OnInit, AfterViewInit{
  dataSource: MatTableDataSource<Employee>;
  displayedColumns: Array<Object> = [
    {key:"id",label:"Id"},
    {key:"dep_id",label:"Dep Id"},
    {key:"name",label:"Name"},
    {key:'email',label:"Email"},
    {key:'gender',label:"Gender"},
    {key:'absences',label:"Absences"},
    {key:'rating',label:"Rating"}
  ];
  columnsToDisplay: string[] = ['id','dep_id','name','gender','email','rating','absences'];

  
  constructor(
    private employeeService: EmployeeServiceService,
    private router: Router,
  ) {
    this.dataSource = new MatTableDataSource<Employee>();

  }


  async ngOnInit() {
    
  }

  async ngAfterViewInit(){
    this.dataSource.data = (await this.employeeService.fetchAllEmployees())
    console.log(this.dataSource);
  }

  navigateToEditForm(id:number){
    this.router.navigate(['/employees',id],{skipLocationChange:true});
  }

}
