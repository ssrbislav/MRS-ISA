import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Seat } from '../model/seat.model';

@Injectable({
  providedIn: 'root'
})
export class SeatService {

  constructor(private http: HttpClient) { }

  seatUrl = 'http://localhost:8080/seat';

  getSeats() {
    return this.http.get<Seat[]>(this.seatUrl);
  }

  getSeatsBySeatType(seatType: number) {
    const url = `${this.seatUrl + '/findAllByAirplaneId/' + seatType}`;
    return this.http.get<Seat[]>(url);
  }

  getSeatsByAirplaneId(id: BigInteger) {
    const url = `${this.seatUrl + '/findAllByAirplaneId/' + id}`;
    return this.http.get<Seat[]>(url);
  }

}
