import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Airplane } from 'src/app/model/airplane.model';
import { ResponseMessage } from 'src/app/model/responseMessage';
import { Seat } from 'src/app/model/seat.model';
import { AirplaneService } from 'src/app/services/airplane.service';
import { SeatService } from 'src/app/services/seat.service';
import { TicketService } from 'src/app/services/ticket.service';
import { ChooseSeatComponent } from './choose-seat/choose-seat.component';

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
  message: ResponseMessage = new ResponseMessage();

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private dialog: MatDialog,
              private seatService: SeatService,
              private airplaneService: AirplaneService,
              private ticketService: TicketService) { }

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
      seatMatrix,
    };

    const dialogRef = this.dialog.open(ChooseSeatComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(
      data => {
        this.seat = data;
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

  createFastReservation() {
    this.seat.airplaneId = this.airplane.id;
    this.ticketService.createFastTicket(this.seat).subscribe(
      data => {
        this.message = data;
        alert(this.message.message);
      }
    );
  }

}
