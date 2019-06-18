import { Component, OnInit } from '@angular/core';
import { animate, transition, state, trigger, style } from '@angular/animations';
import { Ticket } from 'src/app/model/ticket.model';
import { TicketService } from 'src/app/services/ticket.service';
import { MatTableDataSource } from '@angular/material';
import { Flight, FlightDTO } from 'src/app/model/flight.model';
import { FlightService } from 'src/app/services/flight.service';
import { AirlineCompany } from 'src/app/model/company.model';
import { AirlineService } from 'src/app/services/airline.service';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { ReservationDTO } from 'src/app/model/reservation.model';
import { PassengerService } from 'src/app/services/passenger.service';
import { Passenger } from 'src/app/model/passenger.model';
import { ReservationService } from 'src/app/services/reservation.service';
import { ResponseMessage } from 'src/app/model/responseMessage';
import {Location} from '@angular/common';

@Component({
  selector: 'app-fast-reservation',
  templateUrl: './fast-reservation.component.html',
  styleUrls: ['./fast-reservation.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class FastReservationComponent implements OnInit {

  dataSource: MatTableDataSource<Ticket>;
  tickets: Ticket[] = new Array();
  reservation: ReservationDTO = new ReservationDTO();
  passenger: Passenger;
  message: ResponseMessage = new ResponseMessage();

  columnsToDisplay = ['from', 'to', 'departure', 'seat', 'price', 'reserve'];

  constructor(private ticketService: TicketService,
              private tokenStorage: TokenStorageService,
              private reservationService: ReservationService) { }

  ngOnInit() {
    this.getFastTickets();
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  getFastTickets() {
    this.ticketService.getAllFastTickets().subscribe(
      data => {
        this.tickets = data;
        this.dataSource = new MatTableDataSource(this.tickets);
      }
    );
  }


  reserveFastTicket(ticket: Ticket) {
    this.reservation.fastReservation = true;
    this.reservation.ticket = ticket;
    this.reservation.username = this.tokenStorage.getUsername();
    this.reservationService.reserveFastTicket(this.reservation).subscribe(
      data => {
        this.message = data;
        window.alert(this.message.message);
      }
    );
    location.reload();
  }

}


