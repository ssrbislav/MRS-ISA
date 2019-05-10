import { Component, OnInit, Inject } from '@angular/core';
import { AdminDTO } from '../../model/admin.model';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-register-airadmin',
  templateUrl: './register-airadmin.component.html',
  styleUrls: ['./register-airadmin.component.css']
})
export class RegisterAiradminComponent implements OnInit {

  errorMessage = '';
  adminInfo: AdminDTO = new AdminDTO();
  isSignedUp = false;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>, 
              private tokenStorage: TokenStorageService,
              private router: Router,
              private adminService: AdminService) { }

  ngOnInit() {
    this.dialogRef.updateSize('50%', '50%');
  }

  // cancelForm() {
  //   this.router.navigate(['sysAdmin']);
  // }

  // onSubmit() {
  //   this.adminService.airAdminRegistration(this.adminInfo).subscribe(
  //     data => {
  //       window.alert('Admin successfully registered!');
  //       this.isSignedUp = true;
  //       this.router.navigate(['sysAdmin']);
  //     },
  //     error => {
  //       console.log(error);
  //       this.errorMessage = error.error.message;
  //     }
  //   );
  // }

}
