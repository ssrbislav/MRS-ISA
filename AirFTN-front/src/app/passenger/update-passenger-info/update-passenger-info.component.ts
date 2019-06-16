import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialogConfig } from '@angular/material';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { ResponseMessage } from 'src/app/model/responseMessage';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { PassengerService } from 'src/app/services/passenger.service';
import { Passenger } from 'src/app/model/passenger.model';

@Component({
  selector: 'app-update-passenger-info',
  templateUrl: './update-passenger-info.component.html',
  styleUrls: ['./update-passenger-info.component.css']
})
export class UpdatePassengerInfoComponent implements OnInit {

  disabled = true;
  message: ResponseMessage = new ResponseMessage();
  passenger: Passenger = new Passenger();

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private passengerService: PassengerService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.dialogRef.updateSize('40%', '80%');
    this.passenger = this.data;
    this.getPassenger();
  }

  getPassenger() {
    this.passengerService.getPassenger(this.tokenStorage.getUsername()).subscribe(
      data => {
        this.passenger = data;
      }
    );
  }

  changePassword() {
    alert('Not Implemented');
  }

  updateUserInfo() {
    if (this.disabled === true) {
      const elements = document.getElementsByClassName('userInfo');
// tslint:disable-next-line: prefer-for-of
      for (let i = 0; i < elements.length; i++) {
        elements[i].removeAttribute('disabled');
      }
      document.getElementById('updatebtn').innerHTML = 'UPDATE INFO';
      this.disabled = false;
    } else {
      this.passengerService.updatePassenger(this.passenger).subscribe(
        data => {
          this.message = data;
          alert(this.message.message);
        }
      );
      const elements = document.getElementsByClassName('userInfo');
// tslint:disable-next-line: prefer-for-of
      for (let i = 0; i < elements.length; i++) {
        elements[i].setAttribute('disabled', 'disabled');
      }
      document.getElementById('updatebtn').innerHTML = 'ENABLE CHANGES';
      this.disabled = true;
      location.reload();
    }
  }
}
