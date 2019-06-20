import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDatepickerInputEvent, DateAdapter, MAT_DATE_FORMATS, MatTableDataSource } from '@angular/material';
import { AirlineService } from 'src/app/services/airline.service';
import { BusinessReport } from 'src/app/model/businessReport.model';
import { ReservationService } from 'src/app/services/reservation.service';
import { Ticket } from 'src/app/model/ticket.model';
import { APP_DATE_FORMATS, AppDateAdapter } from 'src/app/services/format-datepicker';

@Component({
  selector: 'app-businesss-report',
  templateUrl: './businesss-report.component.html',
  styleUrls: ['./businesss-report.component.css'],
  providers: [
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS}
  ]
})
export class BusinesssReportComponent implements OnInit {

  bussinesReport: BusinessReport = new BusinessReport();

  dataSource: MatTableDataSource<Ticket>;
  ticket: Ticket;

  tickets: Ticket[];

  price = 0;


  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private airlineService: AirlineService,
              private reservationService: ReservationService) { }

  ngOnInit() {
    this.dialogRef.updateSize('60%', '60%');
  }

  generateBusinessReport() {
    this.bussinesReport.airline = this.data.id;

    this.reservationService.createBusinessReport(this.bussinesReport).subscribe(
      result => {
        this.tickets = result;
        this.tickets.forEach(element => {
          this.price += element.price;
        });
      });
  }
}
