import { Component, OnInit, Inject, AfterViewChecked } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { SeatService } from 'src/app/services/seat.service';
import { AirplaneService } from 'src/app/services/airplane.service';
import { Airplane } from 'src/app/model/airplane.model';
import { Seat } from 'src/app/model/seat.model';
import { SeatType } from 'src/app/model/seat-type.enum';

@Component({
  selector: 'app-choose-seat',
  templateUrl: './choose-seat.component.html',
  styleUrls: ['./choose-seat.component.css']
})
export class ChooseSeatComponent implements OnInit, AfterViewChecked  {

  airplane: Airplane = new Airplane();
  seatMatrix: Seat[][];
  seats: Seat[];
  seat: Seat;
  row: number;
  column: number;
  type = 'ECONOMY';
  message: any;


  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private seatService: SeatService,
              private airplaneService: AirplaneService) { }

  ngOnInit() {
    this.dialogRef.updateSize('35%', '70%');
    this.seatMatrix = this.data.seatMatrix;
  }

  ngAfterViewChecked() {
    this.setSeatClass(this.seatMatrix);
  }

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

  getSeat() {
    this.dialogRef.close(this.seat);
  }

  onCheckboxChange(option, event) {
    const elem = document.getElementsByClassName('seatinput');
    if (event.target.checked) {
      this.seat = option;
      for (let i = 0; i < elem.length; i++) {
        elem[i].setAttribute('disabled', 'disabled');
      }
    }
    console.log(this.seat);
  }

}
