import { Component, OnInit, Inject } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-register-sysadmin',
  templateUrl: './register-sysadmin.component.html',
  styleUrls: ['./register-sysadmin.component.css']
})
export class RegisterSysadminComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>, 
              private tokenStorage: TokenStorageService,
              private router: Router,
              private adminService: AdminService) { }

  ngOnInit() {
    this.dialogRef.updateSize('40%', '90%');
  }

}
