import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../models/Employee';
import { RestApiService } from '../rest-api.service';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {
  constructor(private restService: RestApiService,private httpClient:HttpClient) { }

  public async fetchAllEmployees(){
    const suffix   = `employees/all`;
    const headers  = this.restService.formHeaders();
    const endpoint = this.restService.createApiEndpoint(suffix);
    
    const data     = await this.httpClient.get<Employee[]>(endpoint,{headers}).toPromise();
    console.log(data);
    return (data as Array<Employee>);
  }

  public async updateEmployee(id:number,employee: Employee) : Promise<Employee> {
    const endpoint    = `employee/${id}`;
    const headers     = this.restService.formHeaders();
    const apiEndpoint = this.restService.createApiEndpoint(endpoint);

    return this.httpClient.put<Employee>(apiEndpoint,employee,{headers}).toPromise();
  }

  public async deleteEmployee(id:number) : Promise<number> {
    const endpoint    = `employee/${id}`;
    const headers     = this.restService.formHeaders();
    const apiEndpoint = this.restService.createApiEndpoint(endpoint);
    return this.httpClient.delete<number>(apiEndpoint,{headers}).toPromise();
  }

  public fetchEmployeeById(id:string) : Promise<Employee>{
    const suffix = `employee/${id}`;
    const headers  = this.restService.formHeaders();
    const endpoint = this.restService.createApiEndpoint(suffix);
    
    return this.httpClient.get<Employee>(endpoint,{headers}).toPromise();
  }  
}
