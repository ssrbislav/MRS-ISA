import { Component, OnInit } from '@angular/core';
import { AirlineCompany } from 'src/app/model/company.model';
import { Ticket } from 'src/app/model/ticket.model';

@Component({
  selector: 'app-create-reservation',
  templateUrl: './create-reservation.component.html',
  styleUrls: ['./create-reservation.component.css']
})
export class CreateReservationComponent implements OnInit {

  airline: AirlineCompany;
  tickets: Ticket[];

  constructor() { }

  ngOnInit() {
  }

  getCompanyTickets(id: BigInteger) {
    
  }

  

}
