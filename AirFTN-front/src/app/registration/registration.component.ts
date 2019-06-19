import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { SignupInfo } from '../auth/signup-info';
import { MAT_DATE_FORMATS, DateAdapter } from '@angular/material';
import { APP_DATE_FORMATS, AppDateAdapter } from '../services/format-datepicker';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS}
  ]
})
export class RegistrationComponent implements OnInit {

  minDate = new Date(1919, 6, 28);
  maxDate = new Date(2001, 6, 28);
  form: any = {};
  signupInfo: SignupInfo = new SignupInfo();
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
  private roles: string[];

  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private authService: AuthService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken() !== null) {
      this.navigate();
    }
  }

  cancelForm() {
    this.router.navigate(['mainPage']);
  }

  navigate_login() {
    this.router.navigate(['login']);
  }

  checkSame(pass: string) {
    this.form.passwordRepeat = pass;
    if (this.form.passwordRepeat !== this.signupInfo.password) {
      this.errorMessage = 'Passwords do not match!';
    } else {
      this.errorMessage = '';
    }
  }

  onSubmit() {
    console.log(this.signupInfo);
    this.authService.signUp(this.signupInfo).subscribe(
      data => {
        window.alert('Registration successfull! \nPlease activate your account!');
        this.isSignUpFailed = false;
        this.isSignedUp = true;
        this.router.navigate(['login']);
      },
      error => {
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
        location.reload();
      }
    );
  }

  navigate() {
    this.roles = this.tokenStorage.getAuthorities();
    this.roles.every(role => {
      if (role === 'ROLE_SYSADMIN') {
        this.router.navigate(['sysAdmin']);
        return true;
      } else if (role === 'ROLE_AIRLINE_ADMIN') {
        this.router.navigate(['airlineAdmin']);
        return true;
      } else if (role === 'ROLE_PASSENGER') {
        this.router.navigate(['passenger']);
        return true;
      }
    });
  }

}

