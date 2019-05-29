import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { AdminService } from 'src/app/services/admin.service';
import { PricelistDTO } from 'src/app/model/pricelist.model';
import { AdminDTO } from 'src/app/model/admin.model';
import { AirlineCompanyDTO } from 'src/app/model/company.model';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { AirlineService } from 'src/app/services/airline.service';


@Component({
  selector: 'app-pricelist',
  templateUrl: './pricelist.component.html',
  styleUrls: ['./pricelist.component.css']
})
export class PricelistComponent implements OnInit {

  pricelist: PricelistDTO = new PricelistDTO();
  username: string;
  adminId: BigInteger;
  airline: AirlineCompanyDTO;
  companies: AirlineCompanyDTO[];
  adminInfo: AdminDTO = new AdminDTO();

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private adminService: AdminService,
              private airlineService: AirlineService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.dialogRef.updateSize('30%', '70%');
    this.getAdmin();
  }

  onSubmit() {
    if (this.pricelist === undefined) {
      
    } else {
      window.alert("Pricelist already created");
    }
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
