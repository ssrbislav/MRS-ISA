import { Component, OnInit, Inject } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { AdminDTO } from 'src/app/model/admin.model';

@Component({
  selector: 'app-register-sysadmin',
  templateUrl: './register-sysadmin.component.html',
  styleUrls: ['./register-sysadmin.component.css']
})
export class RegisterSysadminComponent implements OnInit {

  errorMessage = '';
  adminInfo: AdminDTO = new AdminDTO();

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private adminService: AdminService) { }

  ngOnInit() {
    this.dialogRef.updateSize('40%', '90%');
  }

  onSubmit() {
    this.adminService.sysAdminRegistration(this.adminInfo).subscribe(
      data => {
        window.alert('System Admin successfully registered!');
        this.dialogRef.close();
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      });
  }

}
