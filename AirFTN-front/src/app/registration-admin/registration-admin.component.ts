import { Component, OnInit, ViewChild } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { AdminService } from '../services/admin.service';
import { AirlineAdminDTO } from '../model/airlineAdmin.model';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-registration-admin',
  templateUrl: './registration-admin.component.html',
  styleUrls: ['./registration-admin.component.css']
})
export class RegistrationAdminComponent implements OnInit {

  errorMessage = '';
  adminInfo: AirlineAdminDTO = new AirlineAdminDTO();
  isSignedUp = false;
  @ViewChild('header') header: HeaderComponent;

  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private adminService: AdminService) { }

  ngOnInit() {
  }

  cancelForm() {
    this.router.navigate(['sysAdmin']);
  }

  onSubmit() {
    this.adminService.adminRegistration(this.adminInfo).subscribe(
      data => {
        window.alert('Admin successfully registered!');
        this.isSignedUp = true;
        this.router.navigate(['sysAdmin']);
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    );
  }

}
