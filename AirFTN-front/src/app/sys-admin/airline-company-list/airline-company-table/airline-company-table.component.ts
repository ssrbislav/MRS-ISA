import { Component, OnInit } from '@angular/core';
import { AirlineService } from 'src/app/services/airline.service';

@Component({
  selector: 'app-airline-company-table',
  templateUrl: './airline-company-table.component.html',
  styleUrls: ['./airline-company-table.component.css']
})
export class AirlineCompanyTableComponent implements OnInit {

  companies: any;

  constructor(private arlineService: AirlineService) { }

  ngOnInit() {
    this.loadAllCompanies();
  }

  loadAllCompanies() {
    this.arlineService.getAirlineCompanies().subscribe(
      data => {
        this.companies = data;
        console.log(data.toString());
      }
    )
  }

}
