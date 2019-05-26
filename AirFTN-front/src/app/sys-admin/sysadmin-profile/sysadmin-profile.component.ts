import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { AdminService } from 'src/app/services/admin.service';
import { PassengerService } from 'src/app/services/passenger.service';
import { AdminDTO } from 'src/app/model/admin.model';

@Component({
  selector: 'app-sysadmin-profile',
  templateUrl: './sysadmin-profile.component.html',
  styleUrls: ['./sysadmin-profile.component.css']
})
export class SysadminProfileComponent implements OnInit {

  private username: string;
  private adminInfo: AdminDTO = new AdminDTO();
  @ViewChild('inputEl1') public inputEl1: ElementRef;
  @ViewChild('inputEl2') public inputEl2: ElementRef;
  @ViewChild('inputEl3') public inputEl3: ElementRef;
  @ViewChild('inputEl4') public inputEl4: ElementRef;
  @ViewChild('inputEl5') public inputEl5: ElementRef;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private tokenStorage: TokenStorageService,
              private adminService: AdminService,
              ) { }

  ngOnInit() {
    this.dialogRef.updateSize('60%', '90%');
    this.getAdmin();
  }

  getAdmin() {
    this.username = this.tokenStorage.getUsername();
    this.adminService.getSysAdmin(this.username).subscribe (
      data => {
        this.adminInfo = data;
        console.log(this.adminInfo.first_name);
      }
    );
    console.log(this.adminInfo.first_name);
  }

}
