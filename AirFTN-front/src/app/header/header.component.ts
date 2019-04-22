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
  }

  sysAdminView() {
    this.showView = 'sysAdmin';
  }

  airlineAdminView() {
    this.showView = 'airlineAdmin';
  }

  passengerView() {
    this.showView = 'passenger';
  }

  Logout() {
    this.featureSelected.emit('logout')
  }

  ShowProfile() {
    this.featureSelected.emit('profile')
  }

}
