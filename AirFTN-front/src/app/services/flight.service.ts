import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { FlightDTO, Flight } from '../model/flight.model';
import { ResponseMessage } from '../model/responseMessage';
import { Observable } from 'rxjs';
import { TransferPoint } from '../model/transfer.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http: HttpClient) { }

  private flightUrl = 'http://localhost:8080/api/flight';

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

  updateFlight(info: FlightDTO): Observable<ResponseMessage> {
    const url = `${this.flightUrl + '/updateFlight'}`;
    return this.http.post<ResponseMessage> (url, info, httpOptions);
  }

  getTransferPoints(id: BigInteger) {
    const url = `${this.flightUrl + '/getTransferPoints/' + id}`;
    return this.http.get<TransferPoint[]>(url);
  }

}
