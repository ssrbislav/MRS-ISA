import { HttpInterceptor, HTTP_INTERCEPTORS, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    constructor(private token: TokenStorageService) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
          let authReq = request;
          const token = this.token.getToken();
          if (token != null) {
              authReq = request.clone({ headers: request.headers.set('Authorization', 'Bearer ' + token) });
          }

          return next.handle(authReq); 
    }
}

export const httpInterceptorProviders = [
    {
        provide: HTTP_INTERCEPTORS,
        useClass: AuthInterceptor,
        multi: true
    }
];
