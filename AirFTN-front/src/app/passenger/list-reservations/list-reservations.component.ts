import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatTableDataSource } from '@angular/material';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { ReservationService } from 'src/app/services/reservation.service';
import { Reservation } from 'src/app/model/reservation.model';
import { ResponseMessage } from 'src/app/model/responseMessage';

@Component({
  selector: 'app-list-reservations',
  templateUrl: './list-reservations.component.html',
  styleUrls: ['./list-reservations.component.css']
})
export class ListReservationsComponent implements OnInit {

  dataSource: MatTableDataSource<Reservation>;
  username: string;
  reservations: Reservation[];
  message: ResponseMessage = new ResponseMessage();

  columnsToDisplay = ['from', 'to', 'departure', 'seat', 'price', 'reserve'];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private reservationService: ReservationService) { }

  ngOnInit() {
    this.dialogRef.updateSize('80%', '70%');
    this.getReservations(this.data.passenger.id);
  }

  getReservations(id: BigInteger) {
    this.reservationService.findByPassengerId(id).subscribe(
      data => {
        this.reservations = data;
        this.dataSource = new MatTableDataSource(this.reservations);
        console.log(this.reservations);
      }
    );
  }

  cancelReservation(reservation: any) {
    console.log(reservation);
    this.reservationService.cancelReservation(reservation).subscribe(
      data => {
        this.message = data;
        alert(this.message.message);
      }
    );
    location.reload();
  }

}
