import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { FlightService } from 'src/app/services/flight.service';
import { TransferPoint } from 'src/app/model/transfer.model';

@Component({
  selector: 'app-list-transfer-points',
  templateUrl: './list-transfer-points.component.html',
  styleUrls: ['./list-transfer-points.component.css']
})
export class ListTransferPointsComponent implements OnInit {

  flight: any;
  transfers: TransferPoint[];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private flightService: FlightService,
              ) { }

  ngOnInit() {
    this.dialogRef.updateSize('40%', '50%');
    this.flight = this.data.flight;
    this.getTransferPoints();
  }

  getTransferPoints() {
    this.flightService.getTransferPoints(this.flight).toPromise().then(
      data => {
        this.transfers = data;
      }
    );
  }

}
