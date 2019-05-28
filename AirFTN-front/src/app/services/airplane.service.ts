import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { AirplaneDTO } from '../model/airplane.model';

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
    return this.http.get(this.airplaneUrl);
  }

  createAirplane(info: AirplaneDTO) {
    const url = `${this.airplaneUrl + '/createAirplane'}`;
    return this.http.post(url, info, httpOptions);
  }

}
