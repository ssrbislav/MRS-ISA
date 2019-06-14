import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Seat } from '../model/seat.model';
import { ResponseMessage } from '../model/responseMessage';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class SeatService {

  constructor(private http: HttpClient) { }

  seatUrl = 'http://localhost:8080/api/seat';

  getSeats() {
    return this.http.get<Seat[]>(this.seatUrl);
  }

  getSeatsBySeatType(seatType: number) {
    const url = `${this.seatUrl + '/findAllByAirplaneId/' + seatType}`;
    return this.http.get<Seat[]>(url);
  }

  getSeatsByAirplaneId(id: BigInteger) {
    const url = `${this.seatUrl + '/findAllByAirplaneId/' + id}`;
    return this.http.get<Seat[][]>(url);
  }

  updateSeatsClasses(seats: Seat[]): Observable<ResponseMessage> {
    const url = `${this.seatUrl + '/updateSeatClass'}`;
    return this.http.post<ResponseMessage>(url, seats, httpOptions);
  }

}
