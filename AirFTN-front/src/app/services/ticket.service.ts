import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ticket } from '../model/ticket.model';
import { ResponseMessage } from '../model/responseMessage';
import { Observable } from 'rxjs';
import { Seat } from '../model/seat.model';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
    providedIn: 'root'
})
export class TicketService {

    constructor(private http: HttpClient) { }

    ticketUrl = 'http://localhost:8080/api/ticket';

    getAllFastTickets() {
        const url = `${this.ticketUrl + '/findAllFastTickets'}`;
        return this.http.get<Ticket[]>(url);
    }

    createFastTicket(info: Seat): Observable<ResponseMessage> {
        const url = `${this.ticketUrl + '/createFastTicket'}`;
        return this.http.post<ResponseMessage>(url, info, httpOptions);
    }

}
