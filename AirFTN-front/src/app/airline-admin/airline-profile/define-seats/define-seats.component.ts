import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-define-seats',
  templateUrl: './define-seats.component.html',
  styleUrls: ['./define-seats.component.css']
})
export class DefineSeatsComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>) { }

  ngOnInit() {
    this.dialogRef.updateSize('40%', '80%');
  }


}
