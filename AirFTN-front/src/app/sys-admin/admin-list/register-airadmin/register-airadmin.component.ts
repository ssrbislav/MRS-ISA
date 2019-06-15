import { Component, OnInit, Inject } from '@angular/core';
import { AdminDTO } from '../../../model/admin.model';
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

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private adminService: AdminService) { }

  ngOnInit() {
    this.dialogRef.updateSize('40%', '80%');
  }

  onSubmit() {
    this.adminService.airAdminRegistration(this.adminInfo).subscribe(
      data => {
        window.alert('Admin successfully registered!');
        this.dialogRef.close();
        location.reload();

      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    );
  }

}
