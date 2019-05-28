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

  private airAdminRegistrationLink = 'http://localhost:8080/api/sysadmin/registerAirAdmin';
  private sysAdminRegistrationLink = 'http://localhost:8080/api/sysadmin/registerSysAdmin';
  private adminAirUpdateLink = 'http://localhost:8080/api/airadmin/updateAdmin';
  private airAdminUrl = 'http://localhost:8080/api/airadmin';
  private airAdminNoCompanyUrl = 'http://localhost:8080/api/airadmin/findAllWithoutCompany';
  private sysAdminUrl = 'http://localhost:8080/api/sysadmin';

  constructor(private http: HttpClient) { }

  airAdminRegistration(info: AdminDTO): Observable<ResponseMessage> {
    return this.http.post<ResponseMessage>(this.airAdminRegistrationLink, info, httpOptions);
  }

  sysAdminRegistration(info: AdminDTO): Observable<ResponseMessage> {
    return this.http.post<ResponseMessage>(this.sysAdminRegistrationLink, info, httpOptions);
  }

  airAdminUpdate(info: AdminDTO): Observable<ResponseMessage> {
    return this.http.post<ResponseMessage>(this.adminAirUpdateLink, info, httpOptions);
  }

  sysAdminUpdate(info: AdminDTO): Observable<ResponseMessage> {
    return this.http.post<ResponseMessage>(this.adminAirUpdateLink, info, httpOptions);
  }

  getAirAdmins() {
    return this.http.get(this.airAdminUrl);
  }

  getAirAdminsNoCompany() {
    return this.http.get(this.airAdminNoCompanyUrl);
  }

  getSysAdmins() {
    return this.http.get(this.sysAdminUrl);
  }

  getAirAdmin(username: string) {
    const url = `${this.airAdminUrl + '/getAdmin'}/${username}`;
    return this.http.get<AdminDTO>(url);
  }

  getSysAdmin(username: string) {
    const url = `${this.sysAdminUrl + '/getAdmin'}/${username}`;
    return this.http.get<AdminDTO>(url);
  }

}
