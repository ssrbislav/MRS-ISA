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

  onNavigate(feature: string) {
    if (feature === 'sysAdmin') {
      this.updateSysAdminInfo();
    }
  }

  updateSysAdminInfo() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    // Still not able to understand this part
    dialogConfig.data = {
      id: 1,
      added: false
    };

    this.dialog.open(SysadminProfileComponent, dialogConfig);
 }

}
