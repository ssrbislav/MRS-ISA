import { Component, OnInit, Inject, AfterViewChecked } from '@angular/core';
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
export class DefineSeatsComponent implements OnInit, AfterViewChecked {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private seatService: SeatService,
              private airplaneService: AirplaneService) { }

  seatMatrix: Seat[][];
  seats: Seat[] = new Array();
  seat: Seat;
  row: number;
  column: number;
  airplane: Airplane;
  type = 'ECONOMY';
  message: any;

  ngOnInit() {
    this.dialogRef.updateSize('40%', '80%');
    this.getAirplane();
  }

  ngAfterViewChecked() {
    this.setSeatClass(this.seatMatrix);
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
        if (seat.seatType.toString() === 'BUSINESS_CLASS') {
          document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#FFC107';
        }
        if (seat.seatType.toString() === 'FIRST_CLASS') {
          document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#29B6F6';
        }
        if (seat.occupied === true) {
          document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#ccc';
          document.getElementById(seat.row + '' + seat.column).setAttribute('disabled', 'disabled');
        }
      }
    }
  }

  onCheckboxChange(option, event) {
    if (event.target.checked) {
      this.seats.push(option);
    } else {
      for (let i = 0; i < this.seatMatrix.length; i++) {
        if (this.seats[i] === option) {
          this.seats.splice(i, 1);
        }
      }
    }
    console.log(this.seats);
  }


  changeSeatClass(seat: Seat) {
    if (this.type === 'ECONOMY_CLASS') {
      document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#009688';
      seat.seatType = SeatType.ECONOMY_CLASS;   }
    if (this.type === 'BUSSINES_CLASS') {
      document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#FFC107';
      seat.seatType = SeatType.BUSINESS_CLASS;
    }
    if (this.type === 'FIRST_CLASS') {
      document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#29B6F6';
      seat.seatType = SeatType.FIRST_CLASS;
    }
    if (this.type === 'DISABLED') {
      seat.occupied = true;
      document.getElementById(seat.row + '' + seat.column).setAttribute('disabled', 'disabled');
      document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#ccc';
    }
    if (this.type === 'ENABLED') {
      // document.getElementById('li' + seat.row + '' + seat.column).style.backgroundColor = '#ccc';
      document.getElementById(seat.row + '' + seat.column).removeAttribute('disabled');
      seat.occupied = false;
    }
  }

  // Will update all seat classes when button is pressed
  updateSeatsClasses() {
    this.seatService.updateSeatsClasses(this.seats).subscribe(
      data => {
        this.message = data;
        alert(this.message.message);
      }
    );
    this.dialogRef.close();
  }

  setEconomy() {
    this.type = 'ECONOMY_CLASS';
  }

  setBussines() {
    this.type = 'BUSSINES_CLASS';
  }

  setFirst() {
    this.type = 'FIRST_CLASS';
  }

  setEnable() {
    this.type = 'ENABLED';
  }

  setDisable() {
    this.type = 'DISABLED';
  }


}
