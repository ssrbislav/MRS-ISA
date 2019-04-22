import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { SignupInfo } from '../auth/signup-info';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  form: any = {};
  private signupInfo: SignupInfo;
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

  onSubmit() {

    this.signupInfo = new SignupInfo(
      this.form.email,
      this.form.username,
      this.form.password,
      this.form.first_name,
      this.form.last_name,
      this.form.address,
      this.form.phoneNumber,
      this.form.dateOfBirth
    );

    this.authService.signUp(this.signupInfo).subscribe(
      data => {
        window.alert("User successfully registered!");
        window.alert("Please activate your account!");
        this.isSignUpFailed = false;
        this.isSignedUp = true;
        this.router.navigate(['login']);
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

  navigate() {
    this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_SYSADMIN') {
          this.router.navigate(['sysAdmin']);
          return true;
        } 
        else if (role === 'ROLE_AIRLINE_ADMIN') {
          this.router.navigate(['airlineAdmin']);
          return true;
        } 
        else if (role === 'ROLE_PASSENGER') {
          this.router.navigate(['passenger']);
           return true;
        }
      });
  }

  

}

