import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { Flight } from 'src/app/model/flight.model';
import { FlightService } from 'src/app/services/flight.service';
import { AirplaneService } from 'src/app/services/airplane.service';
import { AirlineCompanyDTO } from 'src/app/model/company.model';
import { Airplane } from 'src/app/model/airplane.model';

@Component({
  selector: 'app-edit-flight',
  templateUrl: './edit-flight.component.html',
  styleUrls: ['./edit-flight.component.css']
})
export class EditFlightComponent implements OnInit {

  errorMessage: string;
  flightId: any;
  flight: Flight;
  format: string;
  company: any;
  airplanes: Airplane[];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private flightService: FlightService,
              private airplaneService: AirplaneService) { }

  ngOnInit() {
    this.format = 'yyyy-MM-dd hh:mm';
    this.flightId = this.data.flight;
    this.company = this.data.company;
    this.dialogRef.updateSize('35%', '80%');
    this.getFlight();
    this.getAirplanes();
  }

  getAirplanes() {
    this.airplaneService.getCompanyAirplanes(this.company.id).toPromise().then(
      data => {
        this.airplanes = data;
      }
    );
  }

  getFlight() {
    this.flightService.getFlight(this.flightId).toPromise().then(
      data => {
        this.flight = data;
      }
    );
  }

  onSubmit() {
    this.flightService.updateFlight(this.flight).subscribe(
      data => {
        this.dialogRef.close();
        location.reload();
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    );
    location.reload();
  }
}
