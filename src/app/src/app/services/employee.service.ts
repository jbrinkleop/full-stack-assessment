import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../utils/environment';
import { EmployeeDetails, EmployeeDetailsResponse, EmployeeUpdateDetails } from '../interfaces/employee-details.interface'

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(
    private httpClient: HttpClient
  ) { }


  public getEmployeeDetails(): Observable<EmployeeDetailsResponse>{
    const url = environment.BASE_URL+"/api/employee/getEmployeeDetails";
    return this.httpClient.get<EmployeeDetailsResponse>(url);
  }

  public addEmployeeDetails(employeeDetails: EmployeeDetails): Observable<Object> {
    const url = environment.BASE_URL+"/api/employee/addEmployee";
    return this.httpClient.post(url, employeeDetails);            
  }

  public deleteEmployeeById(empId: number): Observable<Object>{
    const url = environment.BASE_URL+"/api/employee/deleteEmployee/"+empId;
    return this.httpClient.delete(url);
  }

  public editEmployeeDetails(editedEmployeeDetails: EmployeeUpdateDetails): Observable<Object> {
    const url = environment.BASE_URL+"/api/employee/editEmployeeDetails";
    return this.httpClient.post(url, editedEmployeeDetails)
  }

  public getJobTitles():Observable<Array<string>>{
    const url = environment.BASE_URL+"/api/employee/jobTitles";
    return this.httpClient.get<Array<string>>(url);
  }
}
