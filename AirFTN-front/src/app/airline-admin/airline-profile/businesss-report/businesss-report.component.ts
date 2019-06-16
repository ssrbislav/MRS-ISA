import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { AirlineService } from 'src/app/services/airline.service';

@Component({
  selector: 'app-businesss-report',
  templateUrl: './businesss-report.component.html',
  styleUrls: ['./businesss-report.component.css']
})
export class BusinesssReportComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private airlineService: AirlineService) { }

  ngOnInit() {
    console.log(this.data);
    this.dialogRef.updateSize('40%', '60%');
  }

}
