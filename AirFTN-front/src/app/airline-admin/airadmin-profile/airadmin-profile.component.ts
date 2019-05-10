import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { AdminService } from 'src/app/services/admin.service';
import { PassengerService } from 'src/app/services/passenger.service';
import { AirlineAdminDTO } from 'src/app/model/airlineAdmin.model';
import { Passenger } from 'src/app/model/passenger.model';

@Component({
  selector: 'app-airadmin-profile',
  templateUrl: './airadmin-profile.component.html',
  styleUrls: ['./airadmin-profile.component.css']
})
export class AiradminProfileComponent implements OnInit {

  adminInfo: AirlineAdminDTO = new AirlineAdminDTO();
  passenger: Passenger = new Passenger();
  username: string;
  @ViewChild('inputElement1') public inputEl1: ElementRef;


  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private tokenStorage: TokenStorageService,
              private adminService: AdminService,
              private passengerService: PassengerService) { }

  ngOnInit() {
    this.dialogRef.updateSize('60%', '%80');
    this.findAdmin();
  }

  findAdmin() {
    this.username = this.tokenStorage.getUsername();
    this.passengerService.getPassenger(this.username).subscribe(
      data => {
        console.log(data.email);
      }
    );
  }

  onSubmit() {
  }

}
