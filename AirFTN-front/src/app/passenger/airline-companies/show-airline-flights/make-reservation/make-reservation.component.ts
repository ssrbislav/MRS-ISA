import { AfterViewChecked, Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { Airplane } from 'src/app/model/airplane.model';
import { Flight } from 'src/app/model/flight.model';
import { Passenger } from 'src/app/model/passenger.model';
import { Person } from 'src/app/model/person.model';
import { ReservationDTO } from 'src/app/model/reservation.model';
import { ResponseMessage } from 'src/app/model/responseMessage';
import { Seat } from 'src/app/model/seat.model';
import { Ticket } from 'src/app/model/ticket.model';
import { AirplaneService } from 'src/app/services/airplane.service';
import { PassengerService } from 'src/app/services/passenger.service';
import { ReservationService } from 'src/app/services/reservation.service';
import { SeatService } from 'src/app/services/seat.service';
import { TicketService } from 'src/app/services/ticket.service';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-make-reservation',
  templateUrl: './make-reservation.component.html',
  styleUrls: ['./make-reservation.component.css']
})
export class MakeReservationComponent implements OnInit, AfterViewChecked {

  flight: Flight;
  airplane: Airplane = new Airplane();
  seatMatrix: Seat[][];
  // seats: Seat[] = new Array();
  seat: Seat; // = new Seat();
  message: ResponseMessage = new ResponseMessage();
  person: Person;
  passenger: Passenger;
  reservation: ReservationDTO = new ReservationDTO();
  ticket: Ticket;

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  passportFormControl = new FormControl('', [ Validators.required]);
  surnameFormControl = new FormControl('', [ Validators.required]);
  nameFormControl = new FormControl('', [ Validators.required]);

  matcher = new MyErrorStateMatcher();

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private airplaneService: AirplaneService,
              private seatService: SeatService,
              private tokenStorage: TokenStorageService,
              private passengerService: PassengerService,
              private reservationService: ReservationService,
              private ticketService: TicketService) { }

  ngOnInit() {
    this.dialogRef.updateSize('50%', '90%');
    this.flight = this.data.flight;
    console.log(this.flight.id);
    this.getAirplane(this.flight.id);
    this.getPassenger();
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

  getAirplane(flightId: any) {
    this.airplaneService.getFlightAirplane(this.flight.id).toPromise().then(
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

  getPassenger() {
    this.passengerService.getPassenger(this.tokenStorage.getUsername()).subscribe(
      data => {
        this.passenger = data;
      });
  }

  onCheckboxChange(option, event) {
    const elem = document.getElementsByClassName('seatinput');
    if (event.target.checked) {
      this.seat = option;
// tslint:disable-next-line: prefer-for-of
      for (let i = 0; i < elem.length; i++) {
        elem[i].setAttribute('disabled', 'disabled');
      }
    }
  }

  choiceOther() {
    this.person = new Person();
  }

  choiceMe() {
    this.person = new Person();
    this.person.firstName = this.passenger.firstName;
    this.person.lastName = this.passenger.lastName;
    this.person.email = this.passenger.email;
    this.person.passportNumber = this.passenger.passportNumber;
  }

  getTicket() {
    this.ticketService.findBySeatId(this.seat.id).subscribe(
      data => {
        this.ticket = data;
        this.reservation.ticket = this.ticket;
      }
    );
  }

  makeReservation() {
    this.getTicket();
    this.reservation.username = this.tokenStorage.getUsername();
    this.reservation.fastReservation = false;
    console.log(this.reservation);
    this.reservationService.createReservation(this.reservation).subscribe(
      result => {
        this.message = result;
        this.dialogRef.close();
        window.alert(this.message.message);
      }
    );
  }

}
