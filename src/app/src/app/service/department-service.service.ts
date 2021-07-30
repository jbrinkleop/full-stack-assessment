import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Department } from '../models/Department';
import { DepartmentReport } from '../models/DepartmentReport';
import { RestApiService } from '../rest-api.service';

@Injectable({
  providedIn: 'root'
})
export class DepartmentServiceService {

  constructor(private httpClient: HttpClient,private restService: RestApiService) { }

  public async fetchAllDepartments() : Promise<Department[]> {
    const endpoint = this.restService.createApiEndpoint(`departments/all`);
    const headers  = this.restService.formHeaders();
    return this.httpClient.get<Department[]>(endpoint,{headers}).toPromise();
  }

  public async fetchReportTotals() : Promise<DepartmentReport[]> { 
    const endpoint = this.restService.createApiEndpoint(`reports/bydepartment`);
    const headers  = this.restService.formHeaders();
    return this.httpClient.get<DepartmentReport[]>(endpoint,{headers}).toPromise();
  }

}
