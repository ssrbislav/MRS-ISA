import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { AdminService } from 'src/app/services/admin.service';
import { AirlineService } from 'src/app/services/airline.service';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-change-admin',
  templateUrl: './change-admin.component.html',
  styleUrls: ['./change-admin.component.css']
})
export class ChangeAdminComponent implements OnInit {

  errorMessage = '';
  admins: any;
  adminId: BigInteger;
  companyId: BigInteger;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private adminService: AdminService,
              private airlineService: AirlineService) { }

  ngOnInit() {
    // this.adminId = this.data.company.admin.id;
    this.companyId = this.data.company.id;
    this.dialogRef.updateSize('30%', '40%');
    this.getAdmins();
  }

  onSubmit() {

    this.airlineService.updateCompanyAdmin(this.companyId, this.adminId).subscribe(
      data => {
        window.alert('Airline company admin successfully updated!');
        this.dialogRef.close();
        location.reload();
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    );
  }

  getAdmins() {

    this.adminService.getAirAdminsNoCompany().subscribe(
      data => {
        this.admins = data;
      }
    );
  }

}
