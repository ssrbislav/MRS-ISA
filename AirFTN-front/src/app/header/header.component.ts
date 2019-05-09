import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material';
import { AiradminProfileComponent } from '../airline-admin/airadmin-profile/airadmin-profile.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  showView = '';
  @Output() featureSelected = new EventEmitter<string>();
  private roles: string[];
  private username: string;

  constructor(private tokenStorage: TokenStorageService,
              private router: Router, public dialog: MatDialog) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_SYSADMIN') {
          this.showView = 'sysAdmin'
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

    this.username = this.tokenStorage.getUsername();
  }

  Logout() {
    window.sessionStorage.clear();
    this.router.navigate(['mainPage']);
    window.alert('Successfully Logged out!');
  }

  ShowProfile() {
    if (this.showView === 'passenger') {
      this.router.navigate(['passenger']);
    } else if (this.showView === 'sysAdmin') {
      this.router.navigate(['sysAdmin']);
    } else if (this.showView === 'airlineAdmin') {
      this.router.navigate(['airlineAdmin']);
    }
  }

  clickAdminRegistration() {
    this.router.navigate(['sysAdmin/registerAdmin']);
  }

  clickAddHotel() {
    window.alert('Feature not available!');
  }

  Update() {
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

}
