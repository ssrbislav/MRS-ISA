import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  showView: string = '';
  @Output() featureSelected = new EventEmitter<string>();
  private roles: string[];

  constructor(private tokenStorage: TokenStorageService,
    private router: Router) { }

  ngOnInit() {
    if(this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
        this.roles.every(role => {
          if(role === 'ROLE_SYSADMIN') {
            this.showView = 'sysAdmin'
            return true;
          } else if(role == 'ROLE_AIRLINE_ADMIN') {
            this.showView = 'airlineAdmin';
            return true;
          } else if(role == 'ROLE_PASSENGER'){
            this.showView = 'passenger';
            return true;
          }
        });
    }
    
  }
  
  Logout() {
    window.sessionStorage.clear();
    this.router.navigate(['mainPage']);
    window.alert("Successfully Logged out!");
  }

  ShowProfile() {
    if (this.showView = 'passenger') {
      this.router.navigate['passenger'];
    }
    else if (this.showView = 'sysAdmin') {
      this.router.navigate['sysAdmin'];
    }
    else if (this.showView = 'airlineAdmin') {
      this.router.navigate['airlineAdmin'];
    }
  }

}
