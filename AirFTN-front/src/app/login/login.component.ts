import { Component, OnInit } from '@angular/core';
import { LoginInfo } from '../auth/login-info';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { PassengerService } from '../services/passenger.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  private loginInfo: LoginInfo;
  private active = false;
  private username: string;

  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private authService: AuthService,
              private passengerService: PassengerService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken() !== null) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
      this.navigate();
    }
  }

  onSubmit() {

    // this.passengerService.getPassenger(this.form.username).subscribe(
    //   data => {
    //     this.active = data.active;
    //   }
    // );

    this.loginInfo = new LoginInfo(
      this.form.username,
      this.form.password);

    this.authService.attemptAuth(this.loginInfo).subscribe(
      data => {
        this.tokenStorage.saveToken(data.token);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);
        this.isLoggedIn = true;
        this.isLoginFailed = false;
        this.roles = this.tokenStorage.getAuthorities();
        this.roles.every(role => {
          if (role === 'ROLE_SYSADMIN') {
            this.router.navigate(['sysAdmin']);
            return true;
          } else if (role === 'ROLE_AIRLINE_ADMIN') {
            this.router.navigate(['airlineAdmin']);
            return true;
          } else if (role === 'ROLE_PASSENGER') {
            // if(!this.active) {
            //   alert('Please activate your account!');
            //   this.tokenStorage.clear();
            //   return false;
            // } else {
              this.router.navigate(['passenger']);
              return true;
            // }
          }
        });
      },
      error => {
        console.log(error);
        window.alert('Wrong credentials!')
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  relodePage() {
    window.location.reload();
  }

  cancelForm() {
    this.router.navigate(['mainPage']);
  }

  signup_navigate() {
    this.router.navigate(['signup']);
  }

  navigate() {
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
