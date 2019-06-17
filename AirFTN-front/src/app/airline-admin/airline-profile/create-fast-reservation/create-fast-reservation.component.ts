import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialogConfig, MatDialog } from '@angular/material';
import { DefineSeatsComponent } from '../define-seats/define-seats.component';
import { ChooseSeatComponent } from './choose-seat/choose-seat.component';
import { Airplane } from 'src/app/model/airplane.model';
import { Seat } from 'src/app/model/seat.model';
import { SeatService } from 'src/app/services/seat.service';
import { AirplaneService } from 'src/app/services/airplane.service';

@Component({
  selector: 'app-create-fast-reservation',
  templateUrl: './create-fast-reservation.component.html',
  styleUrls: ['./create-fast-reservation.component.css']
})
export class CreateFastReservationComponent implements OnInit {

  flightId: any;
  airplane: Airplane = new Airplane();
  seatMatrix: Seat[][];
  seats: Seat[] = new Array();
  seat: Seat;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private dialog: MatDialog,
              private seatService: SeatService,
              private airplaneService: AirplaneService) { }

  ngOnInit() {
    this.flightId = this.data.flight;
    this.getAirplane(this.flightId);
  }

  showFlightSeats(seatMatrix: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      // added: false,
      seatMatrix,
    };

    const dialogRef = this.dialog.open(ChooseSeatComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(
      data => {
        this.seat = data;
        console.log(this.seat);
      }
    );
  }

  getAirplane(flightId: any) {
    this.airplaneService.getFlightAirplane(this.flightId).toPromise().then(
      data => {
        this.airplane = data;
        this.getAllSeats(this.airplane.id);
      }
    );

  }

  getAllSeats(id: BigInteger) {
    this.seatService.getSeatsByAirplaneId(id).toPromise().then(
      data => {
        this.seatMatrix = data;
      }
    );
  }

}
