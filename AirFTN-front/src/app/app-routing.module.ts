import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { MainPageComponent } from './main-page/main-page.component';
import { LoginComponent } from './login/login.component';

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
        path: 'signin',
        component: LoginComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
