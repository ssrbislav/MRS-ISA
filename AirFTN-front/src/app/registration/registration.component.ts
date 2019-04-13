import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private tokenStorage: TokenStorageService,
    private router: Router,) { }

  ngOnInit() {
  }

  cancelForm() {
    this.router.navigate(['mainPage']);
  }
  
  navigate_login() {
    this.router.navigate(['login']);
  }
}
