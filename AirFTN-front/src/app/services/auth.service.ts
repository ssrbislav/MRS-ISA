import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { LoginInfo } from '../auth/login-info';
import { Observable } from 'rxjs';
import { SignupInfo } from '../auth/signup-info';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = 'http://localhost:8080/api/user/login';
  private registrationUrl = 'http://localhost:8080/api/user/register';

  constructor(private http: HttpClient) { }

  attemptAuth(credentials: LoginInfo): Observable<string> {
    return this.http.post<'Success!'>(this.loginUrl, credentials, httpOptions);
  }

  signUp(info: SignupInfo): Observable<string> {
      return this.http.post<string>(this.registrationUrl, info, httpOptions);
  }
}
