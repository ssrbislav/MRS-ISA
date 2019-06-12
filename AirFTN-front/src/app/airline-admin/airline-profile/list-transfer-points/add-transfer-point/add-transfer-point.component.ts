import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { TransferPointDTO } from 'src/app/model/transfer.model';
import { TransferService } from 'src/app/services/transfer.service';

@Component({
  selector: 'app-add-transfer-point',
  templateUrl: './add-transfer-point.component.html',
  styleUrls: ['./add-transfer-point.component.css']
})
export class AddTransferPointComponent implements OnInit {

errorMessage: string;
flight: any;
transferPoint: TransferPointDTO = new TransferPointDTO();

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private transferPointService: TransferService) { }

  ngOnInit() {
    this.flight = this.data.flight;
  }

  addTransferPoint() {
    this.transferPoint.flightId = this.flight;
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
