import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { MainPageComponent } from './main-page/main-page.component';

const routes: Routes = [

    {
        path: '',
        redirectTo: 'mainpage'
    },
    {
        path: 'mainpage',
        component: MainPageComponent
    },
    {
        path: 'signup',
        component: RegistrationComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
