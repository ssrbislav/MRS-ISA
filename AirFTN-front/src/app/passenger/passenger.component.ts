import { Component, OnInit, ViewChild } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { Router } from '@angular/router';
import { UpdatePassengerInfoComponent } from './update-passenger-info/update-passenger-info.component';
import { MatDialogConfig, MatDialog } from '@angular/material';
import { PassengerService } from '../services/passenger.service';
import { TokenStorageService } from '../auth/token-storage.service';
import { ResponseMessage } from '../model/responseMessage';
import { Passenger } from '../model/passenger.model';


@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})
export class PassengerComponent implements OnInit {

  @ViewChild('header') header: HeaderComponent;

  message: ResponseMessage = new ResponseMessage();
  passenger: Passenger = new Passenger();

  constructor(private router: Router,
              private dialog: MatDialog,
              private tokenStorage: TokenStorageService,
              private passengerService: PassengerService) { }

  ngOnInit() {
    this.getPassenger();
  }

  onNavigate(feature: string) {
    if (feature === 'passenger') {
      this.updatePassengerInfo();
    }
  }

  getPassenger() {
    this.passengerService.getPassenger(this.tokenStorage.getUsername()).subscribe(
      data => {
        this.passenger = data;
      }
    );
  }

  updatePassengerInfo() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
    };

    const dialogRef = this.dialog.open(UpdatePassengerInfoComponent, dialogConfig);

  }

  navigateHotels() {
    this.router.navigate(['hotel']);
  }

  navigateAirlineCompanies() {
    this.router.navigate(['airlines']);
  }

  update() {

  }

}
