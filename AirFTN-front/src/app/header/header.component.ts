import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material';
import { AiradminProfileComponent } from '../airline-admin/airadmin-profile/airadmin-profile.component';
import { SysadminProfileComponent } from '../sys-admin/sysadmin-profile/sysadmin-profile.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  showView = '';
  @Output() featureSelected = new EventEmitter<string>();
  private roles: string[];
  username: string;

  constructor(private tokenStorage: TokenStorageService,
              private router: Router, public dialog: MatDialog) { }

  ngOnInit() {
    this.getPassenger();
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_SYSADMIN') {
          this.showView = 'sysAdmin';
          return true;
        } else if (role === 'ROLE_AIRLINE_ADMIN') {
          this.showView = 'airlineAdmin';
          return true;
        } else if (role === 'ROLE_PASSENGER') {
          this.showView = 'passenger';
          return true;
        }
      });
    }
  }

  getPassenger() {
    this.username = this.tokenStorage.getUsername();
  }


  Logout() {
    window.sessionStorage.clear();
    this.router.navigate(['mainPage']);
  }

  showProfile() {
    if (this.showView === 'passenger') {
      this.router.navigate(['passenger']);
    } else if (this.showView === 'sysAdmin') {
      this.router.navigate(['sysAdmin']);
    } else if (this.showView === 'airlineAdmin') {
      this.router.navigate(['airlineAdmin']);
    }
  }

  clickShowAdmins() {
    this.router.navigate(['sysAdmin/listAdmins']);
  }

  updateAirAdminInfo() {
    this.featureSelected.emit('airAdmin');
  }

  updateSysAdminInfo() {
    this.featureSelected.emit('sysAdmin');
  }

  updateProfileInfo() {
    this.featureSelected.emit('passenger');
  }

  clickShowAirlineCompanies() {
    this.router.navigate(['sysAdmin/listCompanies']);
  }

  clickShowDestinations() {
    this.router.navigate(['sysAdmin/listDestinations']);
  }

  clickShowAirplanes() {
    this.router.navigate(['sysAdmin/listAirplanes']);
  }

  showMyReservations() {
    this.featureSelected.emit('my_reservations');
  }

  showFriends() {
    this.featureSelected.emit('my_friends');
  }

}
