import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AirlineCompanyDTO, AirlineCompany } from '../model/company.model';
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

  private airlineCompanyUrl = 'http://localhost:8080/api/airline';

  getAirlineCompanies() {
    return this.http.get<AirlineCompanyDTO[]>(this.airlineCompanyUrl);
  }

  getAirlineCompany(id: BigInteger) {
    const url = `${this.airlineCompanyUrl + '/getCompany/' + id}`;
    return this.http.get<AirlineCompanyDTO>(url);
  }

  addDestinationToCompany(destId: BigInteger, companyId: BigInteger) {
    const url = `${this.airlineCompanyUrl + '/addDestination/' + destId + '/' + companyId}`;
    return this.http.post<ResponseMessage>(url, httpOptions);
  }

  createCompany(info: AirlineCompanyDTO): Observable<ResponseMessage> {
    const url = `${this.airlineCompanyUrl + '/createCompany'}`;
    return this.http.post<ResponseMessage>(url, info, httpOptions);
  }

  updateCompanyProfile(info: AirlineCompany): Observable<ResponseMessage> {
    const url = `${this.airlineCompanyUrl + '/updateInfo'}`;
    return this.http.post<ResponseMessage>(url, info, httpOptions);
  }

  updateCompanyAdmin(airlineId: BigInteger,  adminId: BigInteger): Observable<ResponseMessage> {
    const url = `${this.airlineCompanyUrl + '/updateAdmin/' + airlineId + '/' + adminId}`;
    return this.http.post<ResponseMessage>(url, httpOptions);
  }

}
