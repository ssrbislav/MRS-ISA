import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest, HttpEvent } from '@angular/common/http';
import { Passenger } from '../model/passenger.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PassengerService {

  constructor(private http: HttpClient) { }

  passengerUrl = 'http://localhost:8080/api/passenger';

  public getPassengers() {
    return this.http.get<Passenger[]>(this.passengerUrl);
  }

  public getPassengerById(id: BigInteger) {
    return this.http.get<Passenger>(`${this.passengerUrl + 'getPassengerById'}/${id}`);
  }

  public getPassenger(username: string) {
    return this.http.get<Passenger>(`${this.passengerUrl + 'getPassenger'}/${username}`);
  }

  public getPassengerActive(username: string) {
    return this.http.get<boolean>(`${this.passengerUrl + 'getPassengerActive'}/${username}`);
  }

}
