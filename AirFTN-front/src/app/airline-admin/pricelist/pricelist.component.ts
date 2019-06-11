import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { AdminService } from 'src/app/services/admin.service';
import { PricelistDTO } from 'src/app/model/pricelist.model';
import { AdminDTO } from 'src/app/model/admin.model';
import { AirlineCompanyDTO, AirlineCompany } from 'src/app/model/company.model';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { AirlineService } from 'src/app/services/airline.service';
import { PricelistService } from 'src/app/services/pricelist.service';


@Component({
  selector: 'app-pricelist',
  templateUrl: './pricelist.component.html',
  styleUrls: ['./pricelist.component.css']
})
export class PricelistComponent implements OnInit {

  pricelist: PricelistDTO = new PricelistDTO();
  username: string;
  adminId: BigInteger;
  airline: AirlineCompany;
  companies: AirlineCompany[];
  adminInfo: AdminDTO = new AdminDTO();
  errorMessage = '';

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private adminService: AdminService,
              private airlineService: AirlineService,
              private tokenStorage: TokenStorageService,
              private pricelistService: PricelistService) { }

  ngOnInit() {
    this.dialogRef.updateSize('30%', '70%');
    this.getAdmin();
    this.checkIfPricelistExist();
  }

  checkIfPricelistExist() {
    console.log(this.pricelist.priceByKm);
    if (this.pricelist.priceByKm !== undefined) {
      window.alert('Pricelist already exist!');
      this.dialogRef.close();
    }
  }

  onSubmit() {
    this.pricelistService.createPricelist(this.pricelist, this.airline.id).subscribe(
      data => {
        window.alert('Pricelist successfully created!');
        this.dialogRef.close();
        location.reload();
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    );
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
