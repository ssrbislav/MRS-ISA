import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialogConfig, MatDialog } from '@angular/material';
import { FlightService } from 'src/app/services/flight.service';
import { TransferPoint } from 'src/app/model/transfer.model';
import { AddTransferPointComponent } from './add-transfer-point/add-transfer-point.component';

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
              private dialog: MatDialog) { }

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

  addTransferPoint(flight: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      flight
    };

    const dialogRef = this.dialog.open(AddTransferPointComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
    });
  }

}
