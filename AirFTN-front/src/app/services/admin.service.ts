import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AdminDTO } from '../model/admin.model';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private airAdminRegistrationLink = 'http://localhost:8080/api/admin/registerAdmin';
  private adminUpdateLink = 'http://localhost:8080/api/admin/update';

  constructor(private http: HttpClient) { }

  airAdminRegistration(info: AdminDTO): Observable<string> {
    return this.http.post<string>(this.airAdminRegistrationLink, info, httpOptions);
  }

  adminUpdate(info: AdminDTO): Observable<string> {
    return this.http.post<string>(this.adminUpdateLink, info, httpOptions);
  }

}
