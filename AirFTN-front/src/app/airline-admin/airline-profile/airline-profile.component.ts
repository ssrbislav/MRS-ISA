import { Component, OnInit, ViewChild } from '@angular/core';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { AdminService } from 'src/app/services/admin.service';
import { AdminDTO } from 'src/app/model/admin.model';
import { AirlineService } from 'src/app/services/airline.service';
import { AirlineCompanyDTO } from 'src/app/model/company.model';
import { DestinationDTO } from 'src/app/model/destination.model';
import { DestinationService } from 'src/app/services/destination.service';
import { MatTableDataSource, MatSort, MatDialog, MatDialogConfig } from '@angular/material';
import { FlightDTO, Flight } from 'src/app/model/flight.model';
import { FlightService } from 'src/app/services/flight.service';
import { AirplaneService } from 'src/app/services/airplane.service';
import { Airplane, AirplaneDTO } from 'src/app/model/airplane.model';
import { ChangeAdminComponent } from 'src/app/sys-admin/airline-company-list/airline-company-table/change-admin/change-admin.component';
import { AddDestinationComponent } from './add-destination/add-destination.component';

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
              private flightService: FlightService,
              private airplaneService: AirplaneService,
              private dialog: MatDialog) { }

  username: string;
  adminId: BigInteger;
  adminInfo: AdminDTO = new AdminDTO();

  airline: AirlineCompanyDTO;
  companies: AirlineCompanyDTO[];

  destinations: DestinationDTO[];
  dataSource: MatTableDataSource<FlightDTO>;

  flights: FlightDTO[];

  airplanes: Airplane[];

  displayedColumns: string[] = ['flightNumber', 'airline', 'airplane', 'departure',
    'arrival', 'destination', 'mileage',
    'duration', 'price', 'transfer', 'edit'];

  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {
    this.getAdmin();
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
        this.getCompanyDestinations(this.airline.id);
        this.getCompanyFlights(this.airline.id);
        this.getCompanyAirplanes(this.airline.id);
      }
    );
  }

  getCompanyDestinations(id: BigInteger) {
    this.destinationService.getAllByCompanyId(this.airline.id).toPromise().then(
      data => {
        this.destinations = data;
      }
    );
  }

  getCompanyFlights(id: BigInteger) {
    this.flightService.getAllAirlineFlights(this.airline.id).toPromise().then(
      data => {
        this.flights = data;
        this.dataSource = new MatTableDataSource(this.flights);
        this.dataSource.sort = this.sort;
      }
    );
  }

  getCompanyAirplanes(id: BigInteger) {
    this.airplaneService.getCompanyAirplanes(this.airline.id).toPromise().then(
      data => {
        this.airplanes = data;
      }
    );
  }

  filterFlights(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  addDestination(company) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      company
    };

    const dialogRef = this.dialog.open(AddDestinationComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog closed');
      console.log(result);
    });
  }


}
