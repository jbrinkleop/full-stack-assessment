import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {
  private urlPrefix: string = 'http://localhost';
  private port: string = '8080';

  constructor(private httpClient: HttpClient) { }

  public formHeaders() : HttpHeaders {
    const headers = new HttpHeaders()
      .set("Content-Type","application/json")
      .set("Accept","application/json");
    return headers;
  }

  public createApiEndpoint(suffix:string) : string {
    const endpoint = `${this.urlPrefix}:${this.port}/${suffix}`;
    return endpoint;
  }
}
