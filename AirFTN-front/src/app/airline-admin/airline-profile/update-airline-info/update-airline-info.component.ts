import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { AirlineCompany } from 'src/app/model/company.model';
import { AirlineService } from 'src/app/services/airline.service';
import { ResponseMessage } from 'src/app/model/responseMessage';

@Component({
  selector: 'app-update-airline-info',
  templateUrl: './update-airline-info.component.html',
  styleUrls: ['./update-airline-info.component.css']
})
export class UpdateAirlineInfoComponent implements OnInit {

  message: ResponseMessage;
  airline: AirlineCompany;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private airlineService: AirlineService) { }

  ngOnInit() {
    this.dialogRef.updateSize('30%', '60%');
    this.airline = this.data.company;
  }

  onSubmit() {
    console.log(this.airline);
  }

  updateInfo() {
    console.log(this.airline);
    this.airlineService.updateCompanyProfile(this.airline).subscribe(
      data => {
        this.message = data;
        window.alert(this.message.message);
        location.reload();
      }
    )
  }

}
