import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../utils/environment';
import { DepartmentDetails } from '../interfaces/department-details.interface'

@Injectable({
  providedIn: 'root'
})

@Injectable({
  providedIn: 'root'
})
export class DepartmentsService {

  constructor(private httpClient: HttpClient) { }


  public getDepartments(): Observable<DepartmentDetails[]> {
    const url = environment.BASE_URL+"/api/department/getDepartments";
    return this.httpClient.get<DepartmentDetails[]>(url);
  }
}
