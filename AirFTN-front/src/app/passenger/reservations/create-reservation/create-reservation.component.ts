import { Component, OnInit } from '@angular/core';
import { AirlineCompany } from 'src/app/model/company.model';
import { Ticket } from 'src/app/model/ticket.model';
import { AirlineService } from 'src/app/services/airline.service';
import { FlightService } from 'src/app/services/flight.service';
import { Flight } from 'src/app/model/flight.model';
import { APP_DATE_FORMATS, AppDateAdapter } from 'src/app/services/format-datepicker';
import { MAT_DATE_FORMATS, DateAdapter, MatDialogConfig, MatDialog } from '@angular/material';
import { MakeReservationComponent } from '../../airline-companies/show-airline-flights/make-reservation/make-reservation.component';
import { FilterDateDTO } from 'src/app/model/filter-date.model';

@Component({
  selector: 'app-create-reservation',
  templateUrl: './create-reservation.component.html',
  styleUrls: ['./create-reservation.component.css'],
  providers: [
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS}
  ]
})
export class CreateReservationComponent implements OnInit {

  airlines: AirlineCompany[];
  tickets: Ticket[];
  flights: Flight[];
  dateFlights: Flight[] = [];
  filterDate: FilterDateDTO = new FilterDateDTO();

  constructor(private airlineService: AirlineService,
              private flightService: FlightService,
              private dialog: MatDialog) { }

  ngOnInit() {
    this.getAirlines();
  }

  getAirlines() {
    return this.airlineService.getAirlineCompanies().subscribe(
      data => {
        this.airlines = data;
      }
    );
  }

  getAirlineFlights(id: BigInteger) {
    this.flightService.getAllAirlineFlights(id).subscribe(
      data => {
        this.flights = data;
      });
  }

  getFlightsByDestination(airlineId: BigInteger, destinationId: BigInteger) {
    this.flightService.getAllByDestinationCity(airlineId, destinationId).subscribe(
      data => {
        this.flights = data;
      });
  }

  filterByDate() {

    this.dateFlights = [];

    const datum = new Date(this.filterDate.date);

    this.flights.forEach(element => {

      const d = new Date(element.departureDate);

      if (d.getFullYear() === datum.getFullYear()) {
        if (d.getMonth() === datum.getMonth()) {
          if (d.getDate() === datum.getDate()) {
            this.dateFlights.push(element);
          }
        }
      }
    });

    console.log(this.flights);
    console.log(this.dateFlights);
    this.flights = this.dateFlights;

  }


  chooseTicket(flight: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      flight
    };

    const dialogRef = this.dialog.open(MakeReservationComponent, dialogConfig);
  }

}
