import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AdminDTO } from '../model/admin.model';
import { Observable } from 'rxjs';
import { ResponseMessage } from '../model/responseMessage';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private airAdminRegistrationLink = 'http://localhost:8080/api/admin/registerAirAdmin';
  private sysAdminRegistrationLink = 'http://localhost:8080/api/admin/registerSysAdmin';
  private adminUpdateLink = 'http://localhost:8080/api/admin/updateAdmin';
  private adminUrl = 'http://localhost:8080/api/admin';

  constructor(private http: HttpClient) { }

  airAdminRegistration(info: AdminDTO): Observable<ResponseMessage> {
    return this.http.post<ResponseMessage>(this.airAdminRegistrationLink, info, httpOptions);
  }

  sysAdminRegistration(info: AdminDTO): Observable<ResponseMessage> {
    return this.http.post<ResponseMessage>(this.sysAdminRegistrationLink, info, httpOptions);
  }

  adminUpdate(info: AdminDTO): Observable<ResponseMessage> {
    return this.http.post<ResponseMessage>(this.adminUpdateLink, info, httpOptions);
  }

  getAdmin(username) {
    const url = `${this.adminUrl + '/getAdmin'}/${username}`;
    return this.http.get<AdminDTO>(url);
  }

}
