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
import { HotelComponent } from './hotel/hotel.component';
import { HeaderComponent } from './header/header.component';
import { AirlineCompaniesComponent } from './airline-companies/airline-companies.component';
import { RegistrationAdminComponent } from './registration-admin/registration-admin.component';
import { AiradminProfileComponent } from './airline-admin/airadmin-profile/airadmin-profile.component';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialogModule, MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterSysadminComponent } from './sys-admin/register-sysadmin/register-sysadmin.component';
import { RegisterAiradminComponent } from './sys-admin/register-airadmin/register-airadmin.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    MainPageComponent,
    LoginComponent,
    PassengerComponent,
    SysAdminComponent,
    AirlineAdminComponent,
    HotelComponent,
    HeaderComponent,
    AirlineCompaniesComponent,
    RegistrationAdminComponent,
    AiradminProfileComponent,
    RegisterSysadminComponent,
    RegisterAiradminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule,
    BrowserAnimationsModule
  ],
  entryComponents: [
    AiradminProfileComponent
  ],
  providers: [
    RoleGuardService,
    httpInterceptorProviders,
    { provide: MatDialogRef, useValue: {} },
    { provide: MAT_DIALOG_DATA, useValue: [] },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
