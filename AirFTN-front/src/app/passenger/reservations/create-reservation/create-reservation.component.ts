import { Component, OnInit } from '@angular/core';
import { AirlineCompany } from 'src/app/model/company.model';
import { Ticket } from 'src/app/model/ticket.model';
import { AirlineService } from 'src/app/services/airline.service';
import { FlightService } from 'src/app/services/flight.service';
import { Flight } from 'src/app/model/flight.model';

@Component({
  selector: 'app-create-reservation',
  templateUrl: './create-reservation.component.html',
  styleUrls: ['./create-reservation.component.css']
})
export class CreateReservationComponent implements OnInit {

  airlines: AirlineCompany[];
  tickets: Ticket[];
  flights: Flight[];

  constructor(private airlineService: AirlineService,
              private flightService: FlightService) { }

  ngOnInit() {
    this.getAirlines();
  }

  getAirlines() {
    return this.airlineService.getAirlineCompanies().subscribe(
      data => {
        this.airlines = data;
        console.log(this.airlines);
      }
    );
  }

  getAirlineFlights(id: BigInteger) {
    this.flightService.getAllAirlineFlights(id).subscribe(
      data => {
        this.flights = data;
        console.log(this.flights);
      });
  }

  getFlightsByDestination(airlineId: BigInteger, destinationId: BigInteger) {
    this.flightService.getAllByDestinationCity(airlineId, destinationId).subscribe(
      data => {
        this.flights = data;
        console.log(this.flights);
      });
  }

}
