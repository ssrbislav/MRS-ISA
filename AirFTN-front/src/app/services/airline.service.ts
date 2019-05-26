import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AirlineCompanyDTO } from '../model/company.model';
import { Observable } from 'rxjs';
import { ResponseMessage } from '../model/responseMessage';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  constructor(private http: HttpClient) { }

  private airlineCompanyUrl = 'localhost:8080/api/company/';

  getAirlineCompanies() {
    return this.http.get<AirlineCompanyDTO[]>(this.airlineCompanyUrl);
  }

  getAirlineCompany(id: BigInteger) {
    const url = `${this.airlineCompanyUrl + 'getCompany/{id}'}`;
    return this.http.get<AirlineCompanyDTO>(url);
  }

  createCompany(info: AirlineCompanyDTO): Observable<ResponseMessage> {
    const url = `${this.airlineCompanyUrl + 'createCompany'}`;
    return this.http.post<ResponseMessage>(url, info, httpOptions);
  }

  updateCompanyProfile(info: AirlineCompanyDTO): Observable<ResponseMessage> {
    const url = `${this.airlineCompanyUrl + 'updateInfo'}`;
    return this.http.post<ResponseMessage>(url, info, httpOptions);
  }

}
