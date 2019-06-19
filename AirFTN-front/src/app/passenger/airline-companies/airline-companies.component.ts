import { Component, OnInit } from '@angular/core';
import { AirlineCompanyDTO } from 'src/app/model/company.model';
import { AirlineService } from 'src/app/services/airline.service';
import { Flight } from 'src/app/model/flight.model';
import { FlightService } from 'src/app/services/flight.service';
import {Location} from '@angular/common';
import { MatDialogConfig, MatDialog } from '@angular/material';
import { ShowAirlineFlightsComponent } from './show-airline-flights/show-airline-flights.component';

@Component({
  selector: 'app-airline-companies',
  templateUrl: './airline-companies.component.html',
  styleUrls: ['./airline-companies.component.css']
})
export class AirlineCompaniesComponent implements OnInit {

  airlines: AirlineCompanyDTO[];
  flights: Flight[];

  constructor(private airlineService: AirlineService,
              private flightService: FlightService,
              private location: Location,
              private dialog: MatDialog) { }

  ngOnInit() {
    this.getAirlines();
  }

  back_navigate() {
    this.location.back();
  }

  getAirlines() {
    this.airlineService.getAirlineCompanies().subscribe(
      result => {
        this.airlines = result;
        console.log(this.airlines);
      });
  }

  showCompnayFlights(airline: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      airline
    };

    const dialogRef = this.dialog.open(ShowAirlineFlightsComponent, dialogConfig);
  }

}
