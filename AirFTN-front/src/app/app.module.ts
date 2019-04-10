import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';


import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { MainPageComponent } from './main-page/main-page.component';
import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import { RoleGuardService } from './auth/role-guard.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthInterceptor, httpInterceptorProviders } from './auth/auth-interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PassengerComponent } from './passenger/passenger.component';
import { SysAdminComponent } from './sys-admin/sys-admin.component';
import { AirlineAdminComponent } from './airline-admin/airline-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    MainPageComponent,
    LoginComponent,
    PassengerComponent,
    SysAdminComponent,
    AirlineAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    RoleGuardService,
    httpInterceptorProviders,
    HttpClientModule,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
