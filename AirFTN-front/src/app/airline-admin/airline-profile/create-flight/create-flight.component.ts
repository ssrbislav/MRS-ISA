import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { FlightDTO } from 'src/app/model/flight.model';
import { AirlineCompanyDTO } from 'src/app/model/company.model';
import { FlightService } from 'src/app/services/flight.service';
import { DestinationService } from 'src/app/services/destination.service';
import { AirplaneService } from 'src/app/services/airplane.service';
import { Airplane } from 'src/app/model/airplane.model';
import { Destination, DestinationDTO } from 'src/app/model/destination.model';

@Component({
  selector: 'app-create-flight',
  templateUrl: './create-flight.component.html',
  styleUrls: ['./create-flight.component.css']
})
export class CreateFlightComponent implements OnInit {

  flight: FlightDTO = new FlightDTO();
  errorMessage: string;
  airplanes: Airplane[];
  freeAirplanes: Airplane[];
  destinations: DestinationDTO[];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private flightService: FlightService,
              private destinationService: DestinationService,
              private airplaneService: AirplaneService) { }

  ngOnInit() {
    this.dialogRef.updateSize('35%', '80%');
    this.getAirplanes();
    this.getDestinations();
    this.getNotTakenAirplanes();
  }

  getAirplanes() {
    this.airplaneService.getCompanyAirplanes(this.data.company).subscribe(
      data => {
        this.airplanes = data;
      }
    );
  }

  getNotTakenAirplanes() {
    this.airplaneService.getNotTakenAirplanes(this.data.company).subscribe(
      data => {
        this.freeAirplanes = data;
      }
    );
  }

  getDestinations() {
    this.destinationService.getAllByCompanyId(this.data.company).subscribe(
      data => {
        this.destinations = data;
      }
    )
  }

  onSubmit() {
    console.log(this.data.company);
    this.flight.companyId = this.data.company;
    console.log(this.flight);
    this.flightService.createFlight(this.flight).subscribe(
      data => {
        console.log(data);
        this.dialogRef.close();
        location.reload();
      },
      error => {
        console.log(error.errorMessage);
        this.errorMessage = error.error.message;
      }
    );
  }

}
