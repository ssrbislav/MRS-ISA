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
import { AirlineCompaniesComponent } from './passenger/airline-companies/airline-companies.component';
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
import { AddDestinationComponent } from './airline-admin/airline-profile/add-destination/add-destination.component';
import { AddAirplaneComponent } from './airline-admin/airline-profile/add-airplane/add-airplane.component';
import { CreateFlightComponent } from './airline-admin/airline-profile/create-flight/create-flight.component';
import { ListTransferPointsComponent } from './airline-admin/airline-profile/list-transfer-points/list-transfer-points.component';
import { AddTransferPointComponent } from './airline-admin/airline-profile/list-transfer-points/add-transfer-point/add-transfer-point.component';
import { EditFlightComponent } from './airline-admin/airline-profile/edit-flight/edit-flight.component';
import { DefineSeatsComponent } from './airline-admin/airline-profile/define-seats/define-seats.component';
import { CreateFastReservationComponent } from './airline-admin/airline-profile/create-fast-reservation/create-fast-reservation.component';
import { UpdateAirlineInfoComponent } from './airline-admin/airline-profile/update-airline-info/update-airline-info.component';
import { UpdatePassengerInfoComponent } from './passenger/update-passenger-info/update-passenger-info.component';
import { BusinesssReportComponent } from './airline-admin/airline-profile/businesss-report/businesss-report.component';
import { ChooseFlightComponent } from './airline-admin/airline-profile/choose-flight/choose-flight.component';
import { ChooseSeatComponent } from './airline-admin/airline-profile/create-fast-reservation/choose-seat/choose-seat.component';
import { ReservationsComponent } from './passenger/reservations/reservations.component';
import { FastReservationComponent } from './passenger/reservations/fast-reservation/fast-reservation.component';
import { CreateReservationComponent } from './passenger/reservations/create-reservation/create-reservation.component';
import { ListReservationsComponent } from './passenger/list-reservations/list-reservations.component';




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
    AddDestinationComponent,
    AddAirplaneComponent,
    CreateFlightComponent,
    ListTransferPointsComponent,
    AddTransferPointComponent,
    EditFlightComponent,
    DefineSeatsComponent,
    CreateFastReservationComponent,
    UpdateAirlineInfoComponent,
    UpdatePassengerInfoComponent,
    BusinesssReportComponent,
    ChooseFlightComponent,
    ChooseSeatComponent,
    ReservationsComponent,
    FastReservationComponent,
    CreateReservationComponent,
    ListReservationsComponent,


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
    AddDestinationComponent,
    AddAirplaneComponent,
    CreateFlightComponent,
    ListTransferPointsComponent,
    AddTransferPointComponent,
    EditFlightComponent,
    DefineSeatsComponent,
    CreateFastReservationComponent,
    UpdateAirlineInfoComponent,
    UpdatePassengerInfoComponent,
    BusinesssReportComponent,
    ChooseFlightComponent,
    ChooseSeatComponent,
    ListReservationsComponent
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
