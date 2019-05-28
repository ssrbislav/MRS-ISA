import { Component, OnInit } from '@angular/core';
import { MatDialogConfig, MatDialog } from '@angular/material';
import { RegisterAirlineCompanyComponent } from './register-airline-company/register-airline-company.component';

@Component({
  selector: 'app-airline-company-list',
  templateUrl: './airline-company-list.component.html',
  styleUrls: ['./airline-company-list.component.css']
})
export class AirlineCompanyListComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }

  addArilineCompany() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false
    };

    const dialogRef = this.dialog.open(RegisterAirlineCompanyComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog was closed');
      console.log(result);
    });
  }

}
