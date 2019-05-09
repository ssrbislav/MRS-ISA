import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { LoginInfo } from '../auth/login-info';
import { Observable } from 'rxjs';
import { SignupInfo } from '../auth/signup-info';
import { JwtResponse } from '../auth/jwt-response';
import { ResponseMessage } from '../model/responseMessage';


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

  attemptAuth(credentials: LoginInfo): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  signUp(info: SignupInfo): Observable<ResponseMessage> {
      return this.http.post<ResponseMessage>(this.registrationUrl, info, httpOptions);
  }

}
