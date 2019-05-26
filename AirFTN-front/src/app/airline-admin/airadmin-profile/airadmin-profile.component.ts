import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { AdminService } from 'src/app/services/admin.service';
import { PassengerService } from 'src/app/services/passenger.service';
import { AdminDTO } from 'src/app/model/admin.model';
import { Passenger } from 'src/app/model/passenger.model';

@Component({
  selector: 'app-airadmin-profile',
  templateUrl: './airadmin-profile.component.html',
  styleUrls: ['./airadmin-profile.component.css']
})
export class AiradminProfileComponent implements OnInit {

  adminInfo: AdminDTO = new AdminDTO();
  passenger: Passenger = new Passenger();
  username: string;


  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private tokenStorage: TokenStorageService,
              private adminService: AdminService,
              private passengerService: PassengerService) { }

  ngOnInit() {
    this.dialogRef.updateSize('60%', '90%');
    this.getAdmin();
  }

  getAdmin() {
    this.username = this.tokenStorage.getUsername();
    this.adminService.getAirAdmin(this.username).subscribe (
      data => {
        this.adminInfo = data;
        console.log(this.adminInfo.first_name);
      }
    );
    console.log(this.adminInfo.first_name);
  }

}
