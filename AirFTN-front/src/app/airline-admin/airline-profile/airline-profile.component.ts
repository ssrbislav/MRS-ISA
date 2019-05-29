import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { AdminService } from 'src/app/services/admin.service';
import { AdminDTO } from 'src/app/model/admin.model';
import { AirlineService } from 'src/app/services/airline.service';
import { AirlineCompanyDTO } from 'src/app/model/company.model';

@Component({
  selector: 'app-airline-profile',
  templateUrl: './airline-profile.component.html',
  styleUrls: ['./airline-profile.component.css']
})
export class AirlineProfileComponent implements OnInit {

  constructor(private tokenStorage: TokenStorageService,
              private adminService: AdminService,
              private airlineService: AirlineService) { }

  username: string;
  adminId: BigInteger;
  airline: AirlineCompanyDTO;
  companies: AirlineCompanyDTO[];
  adminInfo: AdminDTO = new AdminDTO();

  tiles = [
    {text: 'ARILIEN INFORMATION', cols: 3, rows: 1, color: 'lightgray'},
    {text: 'FLIGHTS', cols: 1, rows: 2, color: 'lightgray'},
    {text: 'DESTINATIONS', cols: 1, rows: 1, color: 'lightgray'},
    {text: 'OTHER STUFF', cols: 2, rows: 1, color: 'lightgray'},
  ];


  ngOnInit() {
    this.getAdmin();
  }

  getAdmin() {
    this.username = this.tokenStorage.getUsername();
    this.adminService.getAirAdmin(this.username).subscribe(
      data => {
        this.adminInfo = data;
        this.getAirlineCompanies();
      }
    );
  }

  getAirlineCompanies() {
    this.airlineService.getAirlineCompanies().subscribe(
      data => {
        data.forEach(element => {
          this.adminId = element.admin.id;
          if (this.adminId === this.adminInfo.id) {
                this.airline = element;
          }
        });
      }
    );
  }


}
