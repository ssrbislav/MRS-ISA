import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { SeatService } from 'src/app/services/seat.service';
import { Seat, SeatDTO } from 'src/app/model/seat.model';
import { Airplane } from 'src/app/model/airplane.model';
import { AirplaneService } from 'src/app/services/airplane.service';
import { SeatType } from 'src/app/model/seat-type.enum';

@Component({
  selector: 'app-define-seats',
  templateUrl: './define-seats.component.html',
  styleUrls: ['./define-seats.component.css']
})
export class DefineSeatsComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private seatService: SeatService,
              private airplaneService: AirplaneService) { }

  seatMatrix: Seat[][];
  seats: Seat[] = new Array();
  seat: SeatDTO;
  row: number;
  column: number;
  airplane: Airplane;
  type = 'ECONOMY';
  message: any;

  ngOnInit() {
    this.dialogRef.updateSize('40%', '80%');
    this.getAirplane();
  }

  getAirplane() {
    this.airplaneService.getFlightAirplane(this.data.flight).toPromise().then(
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

  // When showwSeatClass button is pressed -> color is changed to represent seat class
  setSeatClass(seatMatrix: Seat[][]) {
    for (const seats of seatMatrix) {
      for (const seat of seats) {
        if (seat.seatType.toString() === 'ECONOMY_CLASS') {
          document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#009688';
        }
        if (seat.seatType.toString() === 'BUSSINES_CLASS') {
          document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = 'FFC107';
        }
        if (seat.seatType.toString() === 'FIRST_CLASS') {
          document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#29B6F6';
        }
      }
    }
  }

  // Based on clicked button the color of presed seat will change to show that class color
  changeSeatClass(seat: Seat) {
    console.log(seat.seatType);
    if (this.type === 'ECONOMY_CLASS') {
      const element = document.getElementById('li' + seat.row + '' + seat.column);
      element.style.backgroundColor = '#009688';
      seat.seatType = SeatType.ECONOMY_CLASS;
      seat.airplain = this.airplane;
      this.seats.push(seat);
    }
    if (this.type === 'BUSSINES_CLASS') {
      document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#FFC107';
      seat.seatType = SeatType.BUSINESS_CLASS;
      seat.airplain = this.airplane;
      this.seats.push(seat);
    }
    if (this.type === 'FIRST_CLASS') {
      console.log(this.seats);
      document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#29B6F6';
      seat.seatType = SeatType.FIRST_CLASS;
      seat.airplain = this.airplane;
      this.seats.push(seat);
    }
  }

  // Will update all seat classes when button is pressed
  updateSeatsClasses() {
    console.log(this.seats);
    this.seatService.updateSeatsClasses(this.seats).subscribe(
      data => {
        this.message = data;
        console.log(this.message);
      }
    );
  }

  setEconomy() {
    this.type = 'ECONOMY_CLASS';
    console.log(this.type);
  }

  setBussines() {
    this.type = 'BUSSINES_CLASS';
    console.log(this.type);
  }

  setFirst() {
    this.type = 'FIRST_CLASS';
    console.log(this.type);
  }

  setUnavailable() {
    this.type = 'UNAVAILABLE';
    console.log(this.type)
  }

  

}
