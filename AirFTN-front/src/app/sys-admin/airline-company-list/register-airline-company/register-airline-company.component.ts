import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { AirlineCompanyDTO } from 'src/app/model/company.model';
import { AirlineService } from 'src/app/services/airline.service';
import { AdminService } from 'src/app/services/admin.service';
import { AdminDTO } from 'src/app/model/admin.model';

@Component({
  selector: 'app-register-airline-company',
  templateUrl: './register-airline-company.component.html',
  styleUrls: ['./register-airline-company.component.css']
})
export class RegisterAirlineCompanyComponent implements OnInit {

  errorMessage = '';
  airlineInfo: AirlineCompanyDTO = new AirlineCompanyDTO();
  admins: any;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private airlineService: AirlineService,
              private adminService: AdminService
              ) { }

  ngOnInit() {
    this.dialogRef.updateSize('40%', '90%');
    this.getAdmins();
  }

  getAdmins() {
    this.adminService.getAirAdminsNoCompany().subscribe(
      data => {
        this.admins = data;
      }
    );
  }

  onSubmit() {

    this.airlineService.createCompany(this.airlineInfo).subscribe(
      data => {
        window.alert('Airline company successfully registered!');
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
