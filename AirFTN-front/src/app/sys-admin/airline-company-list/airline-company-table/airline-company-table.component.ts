import { Component, OnInit } from '@angular/core';
import { AirlineService } from 'src/app/services/airline.service';
import { MatDialogConfig, MatDialog } from '@angular/material';
import { ChangeAdminComponent } from './change-admin/change-admin.component';

@Component({
  selector: 'app-airline-company-table',
  templateUrl: './airline-company-table.component.html',
  styleUrls: ['./airline-company-table.component.css']
})
export class AirlineCompanyTableComponent implements OnInit {

  companies: any;

  constructor(private arlineService: AirlineService,
              private dialog: MatDialog) { }

  ngOnInit() {
    this.loadAllCompanies();
  }

  loadAllCompanies() {
    this.arlineService.getAirlineCompanies().subscribe(
      data => {
        this.companies = data;
      }
    );
  }

  changeAdmin(company) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      company
    };

    const dialogRef = this.dialog.open(ChangeAdminComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog closed');
      console.log(result);
    });
  }

}
