import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { AirplaneDTO } from 'src/app/model/airplane.model';
import { AirplaneService } from 'src/app/services/airplane.service';
import { AirlineService } from 'src/app/services/airline.service';

@Component({
  selector: 'app-create-airplane',
  templateUrl: './create-airplane.component.html',
  styleUrls: ['./create-airplane.component.css']
})
export class CreateAirplaneComponent implements OnInit {

  errorMessage = '';
  airplane: AirplaneDTO = new AirplaneDTO();
  airlines: any;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private airplaneService: AirplaneService,
              private airlineService: AirlineService) { }

  ngOnInit() {
    this.dialogRef.updateSize('40%', '90%');
    this.getAirlineCommpanies();
  }

  onSubmit() {
    this.airplaneService.createAirplane(this.airplane).subscribe(
      data => {
        window.alert('Airplane successfully added!');
        this.dialogRef.close();
        location.reload();
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    );
  }

  getAirlineCommpanies() {
    this.airlineService.getAirlineCompanies().subscribe(
      data => {
        this.airlines = data;
      }
    )
  }

}
