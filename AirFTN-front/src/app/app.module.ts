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
import { AiradminProfileComponent } from './airline-admin/airadmin-profile/airadmin-profile.component';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialogModule, MatButtonModule, MatSortModule } from '@angular/material';
import {MatSelectModule, MatOptionModule, MatDatepickerModule, MatNativeDateModule } from '@angular/material';
import { MatFormFieldModule, MatInputModule } from '@angular/material';
import {MatTableModule} from '@angular/material/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterSysadminComponent } from './sys-admin/admin-list/register-sysadmin/register-sysadmin.component';
import { RegisterAiradminComponent } from './sys-admin/admin-list/register-airadmin/register-airadmin.component';
import { SysadminProfileComponent } from './sys-admin/sysadmin-profile/sysadmin-profile.component';
import { AdminListComponent } from './sys-admin/admin-list/admin-list.component';
import { AirlineCompanyListComponent } from './sys-admin/airline-company-list/airline-company-list.component';
import { RegisterAirlineCompanyComponent } from './sys-admin/airline-company-list/register-airline-company/register-airline-company.component';
import { AirlineCompanyComponent } from './airline-company/airline-company.component';
import { SysadminTableComponent } from './sys-admin/admin-list/sysadmin-table/sysadmin-table.component';
import { AiradminTableComponent } from './sys-admin/admin-list/airadmin-table/airadmin-table.component';
import { AirlineCompanyTableComponent } from './sys-admin/airline-company-list/airline-company-table/airline-company-table.component';
import { ChangeAdminComponent } from './sys-admin/airline-company-list/airline-company-table/change-admin/change-admin.component';
import { DestinationsListComponent } from './sys-admin/destinations-list/destinations-list.component';
import { DestinationsTableComponent } from './sys-admin/destinations-list/destinations-table/destinations-table.component';
import { CreateDestinationComponent } from './sys-admin/destinations-list/create-destination/create-destination.component';
import { AirplaneListComponent } from './sys-admin/airplane-list/airplane-list.component';
import { AirplaneTableComponent } from './sys-admin/airplane-list/airplane-table/airplane-table.component';
import { CreateAirplaneComponent } from './sys-admin/airplane-list/create-airplane/create-airplane.component';
import { AirlineProfileComponent } from './airline-admin/airline-profile/airline-profile.component';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import { PricelistComponent } from './airline-admin/pricelist/pricelist.component';
import { AddDestinationComponent } from './airline-admin/airline-profile/add-destination/add-destination.component';
import { AddAirplaneComponent } from './airline-admin/airline-profile/add-airplane/add-airplane.component';
import { CreateFlightComponent } from './airline-admin/airline-profile/create-flight/create-flight.component';
import { ListTransferPointsComponent } from './airline-admin/airline-profile/list-transfer-points/list-transfer-points.component';
import { AddTransferPointComponent } from './airline-admin/airline-profile/list-transfer-points/add-transfer-point/add-transfer-point.component';
import { EditFlightComponent } from './airline-admin/airline-profile/edit-flight/edit-flight.component';



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
    AiradminProfileComponent,
    RegisterSysadminComponent,
    RegisterAiradminComponent,
    SysadminProfileComponent,
    AdminListComponent,
    AirlineCompanyListComponent,
    RegisterAirlineCompanyComponent,
    AirlineCompanyComponent,
    SysadminTableComponent,
    AiradminTableComponent,
    AirlineCompanyTableComponent,
    ChangeAdminComponent,
    DestinationsListComponent,
    DestinationsTableComponent,
    CreateDestinationComponent,
    AirplaneListComponent,
    AirplaneTableComponent,
    CreateAirplaneComponent,
    AirlineProfileComponent,
    PricelistComponent,
    AddDestinationComponent,
    AddAirplaneComponent,
    CreateFlightComponent,
    ListTransferPointsComponent,
    AddTransferPointComponent,
    EditFlightComponent,

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
    BrowserAnimationsModule,
    MatSelectModule,
    MatOptionModule,
    MatGridListModule,
    MatListModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatSortModule,
  ],
  entryComponents: [
    AiradminProfileComponent,
    SysadminProfileComponent,
    RegisterSysadminComponent,
    RegisterAiradminComponent,
    RegisterAirlineCompanyComponent,
    ChangeAdminComponent,
    CreateDestinationComponent,
    CreateAirplaneComponent,
    PricelistComponent,
    AddDestinationComponent,
    AddAirplaneComponent,
    CreateFlightComponent,
    ListTransferPointsComponent,
    AddTransferPointComponent,
    EditFlightComponent
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
