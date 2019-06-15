import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { DestinationDTO } from 'src/app/model/destination.model';
import { DestinationService } from 'src/app/services/destination.service';

@Component({
  selector: 'app-create-destination',
  templateUrl: './create-destination.component.html',
  styleUrls: ['./create-destination.component.css']
})
export class CreateDestinationComponent implements OnInit {

  destinationInfo: DestinationDTO = new DestinationDTO();
  errorMessage = '';

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private destinationService: DestinationService) { }

  ngOnInit() {
    this.dialogRef.updateSize('40%', '60%');
  }

  onSubmit() {
    this.destinationService.createDestination(this.destinationInfo).subscribe(
      data => {
        window.alert('Destination successfully created!');
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
