import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material';
import { DestinationsTableComponent } from './destinations-table/destinations-table.component';

@Component({
  selector: 'app-destinations-list',
  templateUrl: './destinations-list.component.html',
  styleUrls: ['./destinations-list.component.css']
})
export class DestinationsListComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }

  addDestination() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false
    };

    const dialogRef = this.dialog.open(DestinationsTableComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog was closed');
      console.log(result);
    });
  }

}
