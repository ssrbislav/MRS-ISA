import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { FlightDTO } from '../model/flight.model';
import { ResponseMessage } from '../model/responseMessage';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http: HttpClient) { }

  flightUrl = 'http://localhost:8080/api/flight';

  getAllFlights() {
    return this.http.get<FlightDTO[]>(this.flightUrl);
  }

  getAllAirlineFlights(id: BigInteger) {
    const url = `${this.flightUrl + '/getByAirlineId/' + id}`;
    return this.http.get<FlightDTO[]>(url);
  }

  getFlight(id: BigInteger) {
    const url = `${this.flightUrl + '/getFlight/' + id}`;
    return this.http.get<FlightDTO>(url);
  }

  createFlight(info: FlightDTO): Observable<ResponseMessage> {
    const url = `${this.flightUrl + '/createFlght'}`;
    return this.http.post<ResponseMessage> (url, info, httpOptions);
  }

  // Check this method, I should not pass DTO object but FLight object
  // At least I think so
  updateFlight(info: FlightDTO): Observable<ResponseMessage> {
    const url = `${this.flightUrl + '/updateFlight'}`;
    return this.http.post<ResponseMessage> (url, info, httpOptions);
  }

}
