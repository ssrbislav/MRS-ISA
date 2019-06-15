import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { MainPageComponent } from './main-page/main-page.component';
import { LoginComponent } from './login/login.component';
import { PassengerComponent } from './passenger/passenger.component';
import { RoleGuardService } from './auth/role-guard.service';
import { SysAdminComponent } from './sys-admin/sys-admin.component';
import { AirlineAdminComponent } from './airline-admin/airline-admin.component';
import { HotelComponent } from './hotel/hotel.component';
import { AirlineCompaniesComponent } from './airline-companies/airline-companies.component';
import { AdminListComponent } from './sys-admin/admin-list/admin-list.component';
import { AirlineCompanyComponent } from './airline-company/airline-company.component';
import { AirlineCompanyListComponent } from './sys-admin/airline-company-list/airline-company-list.component';
import { DestinationsListComponent } from './sys-admin/destinations-list/destinations-list.component';
import { AirplaneListComponent } from './sys-admin/airplane-list/airplane-list.component';
import { PricelistComponent } from './airline-admin/pricelist/pricelist.component';

const routes: Routes = [

    {
        path: '',
        component: MainPageComponent
    },
    {
        path: 'mainPage',
        component: MainPageComponent
    },
    {
        path: 'signup',
        component: RegistrationComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'hotel',
        component: HotelComponent
    },
    {
        path: 'airlines',
        component: AirlineCompaniesComponent
    },
    {
        path: 'passenger',
        component: PassengerComponent,
        canActivate: [RoleGuardService],
        data: {
            expectedRole: 'ROLE_PASSENGER'
        }
    },
    {
        path: 'sysAdmin',
        component: SysAdminComponent,
        children: [
            {
                path: 'listAdmins',
                component: AdminListComponent
            },
            {
                path: 'listCompanies',
                component: AirlineCompanyListComponent
            },
            {
                path: 'listDestinations',
                component: DestinationsListComponent
            },
            {
                path: 'listAirplanes',
                component: AirplaneListComponent
            }
        ],
        canActivate: [RoleGuardService],
        data: {
            expectedRole: 'ROLE_SYSADMIN'
        },
    },
    {
        path: 'airlineAdmin',
        component: AirlineAdminComponent,
        canActivate: [RoleGuardService],
        data: {
            expectedRole: 'ROLE_AIRLINE_ADMIN'
        }
    },
    {
        path: 'airlineCompany',
        component: AirlineCompanyComponent,
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }

export const RoutingComponents = {
    // RegistrationAdminComponent
};
