import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { AirlineService } from 'src/app/services/airline.service';
import { Airplane } from 'src/app/model/airplane.model';
import { AirplaneService } from 'src/app/services/airplane.service';

@Component({
  selector: 'app-add-airplane',
  templateUrl: './add-airplane.component.html',
  styleUrls: ['./add-airplane.component.css']
})
export class AddAirplaneComponent implements OnInit {

  airplaneId: BigInteger;
  companyId: BigInteger;
  airplane: Airplane;
  airplanes: Airplane[];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private airlineService: AirlineService,
              private airplaneService: AirplaneService) { }

  ngOnInit() {
    this.companyId = this.data.company;
  }

  loadAllAirplanes() {
    return this.airplaneService.getAllAirplanes().toPromise().then(
      data => {
        this.airplanes = data;
      }
    )
  }

}
