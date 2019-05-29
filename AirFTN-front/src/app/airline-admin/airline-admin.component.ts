import { Component, OnInit, Inject } from '@angular/core';
import { AiradminProfileComponent } from './airadmin-profile/airadmin-profile.component';
import { MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material';
import { TokenStorageService } from '../auth/token-storage.service';
import { AdminService } from '../services/admin.service';
import { PricelistComponent } from './pricelist/pricelist.component';

@Component({
  selector: 'app-airline-admin',
  templateUrl: './airline-admin.component.html',
  styleUrls: ['./airline-admin.component.css']
})
export class AirlineAdminComponent implements OnInit {

  constructor(private dialog: MatDialog) { }

  ngOnInit() {
  }

  onNavigate(feature: string) {
    if (feature === 'airAdmin') {
      this.updateAirAdminInfo();
    }
    if (feature === 'pricelist') {
      this.createPricelist();
    }
  }

  updateAirAdminInfo() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false
    };

    const dialogRef = this.dialog.open(AiradminProfileComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog was closed');
      console.log(result);
    });
  }

  createPricelist() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false
    };

    const dialogRef = this.dialog.open(PricelistComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog was closed');
      console.log(result);
    });
  }

}
