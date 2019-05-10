import { Component, OnInit } from '@angular/core';
import { AirlineAdminDTO } from 'src/app/model/airlineAdmin.model';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-register-airadmin',
  templateUrl: './register-airadmin.component.html',
  styleUrls: ['./register-airadmin.component.css']
})
export class RegisterAiradminComponent implements OnInit {

  errorMessage = '';
  adminInfo: AirlineAdminDTO = new AirlineAdminDTO();
  isSignedUp = false;

  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private adminService: AdminService) { }

  ngOnInit() {
  }

  cancelForm() {
    this.router.navigate(['sysAdmin']);
  }

  onSubmit() {
    this.adminService.airAdminRegistration(this.adminInfo).subscribe(
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
