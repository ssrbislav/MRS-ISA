import { Component, OnInit, Inject } from '@angular/core';
import { AirplaneService } from 'src/app/services/airplane.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { AirlineService } from 'src/app/services/airline.service';
import { DestinationService } from 'src/app/services/destination.service';
import { DestinationDTO, Destination } from 'src/app/model/destination.model';

@Component({
  selector: 'app-add-destination',
  templateUrl: './add-destination.component.html',
  styleUrls: ['./add-destination.component.css']
})
export class AddDestinationComponent implements OnInit {

  errorMessage = '';
  companyId: BigInteger;
  destination: Destination;
  destinations: DestinationDTO[];
  dest: BigInteger;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private airlineService: AirlineService,
              private destinationService: DestinationService) { }

  ngOnInit() {
    this.companyId = this.data.company;
    this.loadAllDestinations();
  }

  onSubmit() {

    this.airlineService.addDestinationToCompany(this.dest, this.companyId).subscribe(
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

  loadAllDestinations() {
    return this.destinationService.getAllDestinations().toPromise().then(
      data => {
        this.destinations = data;
      }
    );
  }


}
