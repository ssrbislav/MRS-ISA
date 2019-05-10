import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-airadmin-profile',
  templateUrl: './airadmin-profile.component.html',
  styleUrls: ['./airadmin-profile.component.css']
})
export class AiradminProfileComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, public dialogRef: MatDialogRef<any>) { }

  ngOnInit() {
    this.dialogRef.updateSize('60%', '%80');
  }

  onSubmit() {
    
  }

  cancelForm() {
    this.dialogRef.close();
  }

}
