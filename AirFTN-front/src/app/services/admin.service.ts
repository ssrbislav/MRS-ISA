import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AirlineAdminDTO } from '../model/airlineAdmin.model';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private adminRegistrationLink = 'http://localhost:8080/api/admin/registerAdmin';

  constructor(private http: HttpClient) { }

  adminRegistration(info: AirlineAdminDTO): Observable<string> {
    return this.http.post<string>(this.adminRegistrationLink, info, httpOptions);
  }

}
