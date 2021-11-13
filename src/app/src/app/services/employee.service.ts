import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../utils/environment'

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
  public getEmployeeDetails(): Observable<any>{
    const url = environment.BASE_URL+"/api/employee/getEmployeeDetails";
    return this.httpClient.get(url);
  }
}
