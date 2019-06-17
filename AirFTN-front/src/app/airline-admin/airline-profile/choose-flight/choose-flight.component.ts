import { Component, OnInit, Inject } from '@angular/core';
import { AirlineService } from 'src/app/services/airline.service';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig, MatDialog } from '@angular/material';
import { FlightService } from 'src/app/services/flight.service';
import { Flight, FlightDTO } from 'src/app/model/flight.model';
import { CreateFastReservationComponent } from '../create-fast-reservation/create-fast-reservation.component';

@Component({
  selector: 'app-choose-flight',
  templateUrl: './choose-flight.component.html',
  styleUrls: ['./choose-flight.component.css']
})
export class ChooseFlightComponent implements OnInit {

  flights: FlightDTO[];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private airlineService: AirlineService,
              private dialog: MatDialog,
              private flightService: FlightService) { }

  ngOnInit() {
    this.getFlights();
  }

  getFlights() {
    this.flightService.getAllAirlineFlights(this.data.airline).subscribe(
      data => {
        this.flights = data;
      }
    )
  }

  openFormForCreating(flight: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      flight,
    };

    const dialogRef = this.dialog.open(CreateFastReservationComponent, dialogConfig);

    this.dialogRef.close();
  }

}
