import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { AdminService } from 'src/app/services/admin.service';
import { PassengerService } from 'src/app/services/passenger.service';

@Component({
  selector: 'app-sysadmin-profile',
  templateUrl: './sysadmin-profile.component.html',
  styleUrls: ['./sysadmin-profile.component.css']
})
export class SysadminProfileComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private tokenStorage: TokenStorageService,
              private adminService: AdminService,
              private passengerService: PassengerService) { }

  ngOnInit() {
    this.dialogRef.updateSize('60%', '90%');
  }

}
