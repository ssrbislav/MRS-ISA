import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { AdminService } from 'src/app/services/admin.service';
import { PassengerService } from 'src/app/services/passenger.service';
import { AdminDTO } from 'src/app/model/admin.model';
import { Passenger } from 'src/app/model/passenger.model';
import { ResponseMessage } from 'src/app/model/responseMessage';

@Component({
  selector: 'app-airadmin-profile',
  templateUrl: './airadmin-profile.component.html',
  styleUrls: ['./airadmin-profile.component.css']
})
export class AiradminProfileComponent implements OnInit {

  adminInfo: AdminDTO = new AdminDTO();
  passenger: Passenger = new Passenger();
  username: string;
  disabled = true;
  message: ResponseMessage;


  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private tokenStorage: TokenStorageService,
              private adminService: AdminService,
              private passengerService: PassengerService) { }

  ngOnInit() {
    this.dialogRef.updateSize('40%', '80%');
    this.getAdmin();
  }

  getAdmin() {
    this.username = this.tokenStorage.getUsername();
    this.adminService.getAirAdmin(this.username).subscribe (
      data => {
        this.adminInfo = data;
      }
    );
  }

  changePassword() {
    alert('Not Implemented');
  }

  updateAdminInfo() {
    if (this.disabled === true) {
      const elements = document.getElementsByClassName('adminInfo');
// tslint:disable-next-line: prefer-for-of
      for (let i = 0; i < elements.length; i++) {
        elements[i].removeAttribute('disabled');
      }
      document.getElementById('updatebtn').innerHTML = 'UPDATE INFO';
      this.disabled = false;
    } else {
      this.adminService.airAdminUpdate(this.adminInfo).subscribe(
        data => {
          this.message = data;
          alert(this.message.message);
        }
      );
      const elements = document.getElementsByClassName('adminInfo');
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
