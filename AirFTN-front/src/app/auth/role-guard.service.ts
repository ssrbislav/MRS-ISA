import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, Router } from '@angular/router/';
import { TokenStorageService } from './token-storage.service';

const TOKEN_KEY = 'AuthToken';
const AUTHORITIES_KEY = 'AuthAuthorities';

@Injectable({
  providedIn: 'root'
})
export class RoleGuardService implements CanActivate {

  constructor(public router: Router, public tokenStorage: TokenStorageService) { }

  canActivate(route: ActivatedRouteSnapshot): boolean {

    const expectedRole = route.data.expectedRole;
    const token = this.tokenStorage.getToken();

    if (token == null) {
      window.alert('Please Log in!');
      this.router.navigate(['mainPage']);
  }

    if (sessionStorage.getItem(TOKEN_KEY)) {
      JSON.parse(sessionStorage.getItem(AUTHORITIES_KEY)).forEach(authority => {
        if(authority.authority != expectedRole) {
          window.alert('You do not have the authority to access this page!');
          this.router.navigate(['mainPage']);
          return false;
        }
      });
    }

    return true;
  }
}
