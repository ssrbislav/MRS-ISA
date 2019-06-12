import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { TransferPointDTO } from 'src/app/model/transfer.model';
import { TransferService } from 'src/app/services/transfer.service';
import { FlightService } from 'src/app/services/flight.service';
import { Flight, FlightDTO } from 'src/app/model/flight.model';

@Component({
  selector: 'app-add-transfer-point',
  templateUrl: './add-transfer-point.component.html',
  styleUrls: ['./add-transfer-point.component.css']
})
export class AddTransferPointComponent implements OnInit {

errorMessage: string;
flightId: any;
flight: FlightDTO;
transferPoint: TransferPointDTO = new TransferPointDTO();

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private transferPointService: TransferService,
              private flightService: FlightService) { }

  ngOnInit() {
    this.flightId = this.data.flight;
  }

  getFlight() {
    this.flightService.getFlightDTO(this.flightId).toPromise().then(
      data => {
        this.flight = data;
      }
    );
  }

  addTransferPoint() {
    this.transferPoint.flightId = this.flightId;
    this.transferPointService.createTransferPoint(this.transferPoint).subscribe(
      data => {
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
