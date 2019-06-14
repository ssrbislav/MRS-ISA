import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { AirplaneDTO, Airplane } from '../model/airplane.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AirplaneService {

  constructor(private http: HttpClient) { }

  airplaneUrl = 'http://localhost:8080/api/airplane';

  getAllAirplanes() {
    return this.http.get<Airplane[]>(this.airplaneUrl);
  }

  getCompanyAirplanes(id: BigInteger) {
    const url = `${this.airplaneUrl + '/findByCompanyId/' + id}`;
    return this.http.get<Airplane[]>(url);
  }

  getFlightAirplane(id: BigInteger) {
    const url = `${this.airplaneUrl + '/findByFlightId/' + id}`;
    return this.http.get<Airplane>(url)
  }

  createAirplane(info: AirplaneDTO) {
    const url = `${this.airplaneUrl + '/createAirplane'}`;
    return this.http.post(url, info, httpOptions);
  }

}
