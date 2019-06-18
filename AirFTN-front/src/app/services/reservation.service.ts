import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ReservationDTO } from '../model/reservation.model';
import { ResponseMessage } from '../model/responseMessage';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
  };

@Injectable({
    providedIn: 'root'
})
export class ReservationService {

    constructor(private http: HttpClient) { }

    reservationUrl = 'http://localhost:8080/api/reservation';

    reserveFastTicket(reservation: ReservationDTO): Observable<ResponseMessage> {
        const url = `${this.reservationUrl + '/createReservation'}`;
        return this.http.post<ResponseMessage>(url, reservation, httpOptions);
    }


}
