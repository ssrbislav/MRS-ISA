import { Component, OnInit, ViewChild } from '@angular/core';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { AdminService } from 'src/app/services/admin.service';
import { AdminDTO } from 'src/app/model/admin.model';
import { AirlineService } from 'src/app/services/airline.service';
import { AirlineCompanyDTO } from 'src/app/model/company.model';
import { DestinationDTO } from 'src/app/model/destination.model';
import { DestinationService } from 'src/app/services/destination.service';
import { MatTableDataSource, MatSort } from '@angular/material';
import { FlightDTO } from 'src/app/model/flight.model';
import { FlightService } from 'src/app/services/flight.service';

@Component({
  selector: 'app-airline-profile',
  templateUrl: './airline-profile.component.html',
  styleUrls: ['./airline-profile.component.css']
})
export class AirlineProfileComponent implements OnInit {

  constructor(private tokenStorage: TokenStorageService,
              private adminService: AdminService,
              private airlineService: AirlineService,
              private destinationService: DestinationService,
              private flightService: FlightService) { }

  username: string;
  adminId: BigInteger;
  adminInfo: AdminDTO = new AdminDTO();

  airline: AirlineCompanyDTO;
  companies: AirlineCompanyDTO[];
 
  destinations: DestinationDTO[];
  dataSourceDestination: MatTableDataSource<DestinationDTO>;

  flights: FlightDTO[];

  displayedColumns: string[] = ['city', 'country', 'description', 'delete'];

  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {
    this.getAdmin();
    this.getDestinations();
  }

  getAdmin() {
    this.username = this.tokenStorage.getUsername();
    this.adminService.getAirAdmin(this.username).toPromise().then(
      data => {
        this.adminInfo = data;
        this.getAirlineCompanies();
      }
    );
  }

  getAirlineCompanies() {
    this.airlineService.getAirlineCompanies().toPromise().then(
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

  getDestinations() {
    this.destinationService.getAllDestinations().toPromise().then(
      data => {
        this.destinations = data;
        this.dataSourceDestination = new MatTableDataSource(this.destinations);
        this.dataSourceDestination.sort = this.sort;
      }
    );
  }

  getFlights() {
    this.flightService.getAllAirlineFlights(this.airline.id).toPromise().then(
      data => {
        this.flights = data;
      }
    )
  }

  filterDestinations(filterValue: string) {
    this.dataSourceDestination.filter = filterValue.trim().toLowerCase();
  }

}
