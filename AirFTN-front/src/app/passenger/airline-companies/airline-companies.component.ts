import { Component, OnInit } from '@angular/core';
import { AirlineCompanyDTO } from 'src/app/model/company.model';
import { AirlineService } from 'src/app/services/airline.service';
import { Flight } from 'src/app/model/flight.model';
import { FlightService } from 'src/app/services/flight.service';
import {Location} from '@angular/common';

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
    private location: Location) { }

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
    console.log(airline);

  }

}
