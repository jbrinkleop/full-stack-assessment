import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../utils/environment';
import { EmployeeDetails } from '../interfaces/employee-details.interface'

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(
    private httpClient: HttpClient
  ) { }


  public getEmployeeDetails(): Observable<EmployeeDetails[]>{
    const url = environment.BASE_URL+"/api/employee/getEmployeeDetails";
    return this.httpClient.get<EmployeeDetails[]>(url);
  }

  public addEmployeeDetails(employeeDetails: EmployeeDetails): Observable<Object> {
    const url = environment.BASE_URL+"/api/employee/addEmployee";
    return this.httpClient.post(url, employeeDetails);            
  }

  public deleteEmployeeById(empId: number): Observable<Object>{
    const url = environment.BASE_URL+"/api/employee/deleteEmployee/"+empId;
    return this.httpClient.delete(url);
  }
}
