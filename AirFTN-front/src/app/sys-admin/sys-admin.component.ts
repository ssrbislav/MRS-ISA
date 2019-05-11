import { Component, OnInit } from '@angular/core';
import { SysadminProfileComponent } from './sysadmin-profile/sysadmin-profile.component';
import { MatDialogConfig, MatDialog } from '@angular/material';

@Component({
  selector: 'app-sys-admin',
  templateUrl: './sys-admin.component.html',
  styleUrls: ['./sys-admin.component.css']
})
export class SysAdminComponent implements OnInit {

  constructor(private dialog: MatDialog) { }

  ngOnInit() {
  }

  // This is from where the pop up window should be intialized, not from Header -> fix this
//   updateSysAdminInfo() {
//     const dialogConfig = new MatDialogConfig();

//     dialogConfig.disableClose = true;
//     dialogConfig.autoFocus = true;
//     dialogConfig.data = {
//       id: 1,
//       added: false
//     };

//     const dialogRef = this.dialog.open(SysadminProfileComponent, dialogConfig);
//  }

}
