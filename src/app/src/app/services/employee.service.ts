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

  /**
   * Fetch employee details
   */
  public getEmployeeDetails(): Observable<EmployeeDetails[]>{
    const url = environment.BASE_URL+"/api/employee/getEmployeeDetails";
    return this.httpClient.get<EmployeeDetails[]>(url);
  }
}
