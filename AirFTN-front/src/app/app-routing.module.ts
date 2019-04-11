import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { MainPageComponent } from './main-page/main-page.component';
import { LoginComponent } from './login/login.component';
import { PassengerComponent } from './passenger/passenger.component';
import { RoleGuardService } from './auth/role-guard.service';
import { SysAdminComponent } from './sys-admin/sys-admin.component';
import { AirlineAdminComponent } from './airline-admin/airline-admin.component';

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
        path: 'passenger',
        component: PassengerComponent,
        canActivate: [RoleGuardService],
        data: {
            expectedRole: 'ROLE_PASESENGER'
        }
    },
    {
        path: 'sysAdmin',
        component: SysAdminComponent,
        canActivate: [RoleGuardService],
        data: {
            expectedRole: 'ROLE_SYSADMIN'
        }
    },
    {
        path: 'airlineAdmin',
        component: AirlineAdminComponent,
        canActivate: [RoleGuardService],
        data: {
            expectedRole: 'ROLE_AIRLINE_ADMIN'
        }
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
