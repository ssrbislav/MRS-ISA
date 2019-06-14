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
import { AddAirplaneComponent } from './add-airplane/add-airplane.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { ListTransferPointsComponent } from './list-transfer-points/list-transfer-points.component';
import { EditFlightComponent } from './edit-flight/edit-flight.component';
import { DefineSeatsComponent } from './define-seats/define-seats.component';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { PricelistDTO, Pricelist } from 'src/app/model/pricelist.model';
import { PricelistService } from 'src/app/services/pricelist.service';
import { ResponseMessage } from 'src/app/model/responseMessage';

@Component({
  selector: 'app-airline-profile',
  templateUrl: './airline-profile.component.html',
  styleUrls: ['./airline-profile.component.css',],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class AirlineProfileComponent implements OnInit {

  constructor(private tokenStorage: TokenStorageService,
    private adminService: AdminService,
    private airlineService: AirlineService,
    private destinationService: DestinationService,
    private flightService: FlightService,
    private airplaneService: AirplaneService,
    private dialog: MatDialog,
    private pricelistService: PricelistService) { }

  username: string;
  adminId: BigInteger;
  adminInfo: AdminDTO = new AdminDTO();

  airline: AirlineCompanyDTO = new AirlineCompanyDTO();
  companies: AirlineCompanyDTO[];

  destinations: DestinationDTO[];
  dataSource: MatTableDataSource<FlightDTO>;

  flights: FlightDTO[];

  airplanes: Airplane[];

  pricelistDTO: PricelistDTO;

  pricelist: Pricelist = new Pricelist();

  responseMessage: ResponseMessage;

  displayedColumns: string[] = ['flightNumber', 'airline', 'airplane', 'departure',
    'arrival', 'destination', 'mileage',
    'duration', 'price', 'transfer', 'seats', 'edit'];

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
        this.getPricelistByCompanyId(this.airline.id);
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

  addDestination(company: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      company
    };

    const dialogRef = this.dialog.open(AddDestinationComponent, dialogConfig);

    // dialogRef.afterClosed().subscribe(result => {
    //   console.log('Dialog closed');
    //   console.log(result);
    // });
  }

  addAirplane(company: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      company
    };

    const dialogRef = this.dialog.open(AddAirplaneComponent, dialogConfig);
  }

  createFlight(company: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      company
    };

    const dialogRef = this.dialog.open(CreateFlightComponent, dialogConfig);
  }

  showFlightTransfers(flight: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      flight
    };

    const dialogRef = this.dialog.open(ListTransferPointsComponent, dialogConfig);

  }

  editFlight(flight: any, company: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      flight,
      company
    };

    const dialogRef = this.dialog.open(EditFlightComponent, dialogConfig);
  }

  showFlightSeats(flight: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      flight,
    };

    const dialogRef = this.dialog.open(DefineSeatsComponent, dialogConfig);
  }

  getPricelistByCompanyId(id: BigInteger) {
    this.pricelistService.getPricelistByAirlineId(id).subscribe(
      data => {
        this.pricelist = data;
        this.pricelistDTO = data;
      });
  }

  enablePricelistEdit() {
    const elements = document.getElementsByClassName('pricelist-elem');
    for (var i = 0; i < elements.length; i++) {
      elements[i].removeAttribute('disabled');
    }
    document.getElementsByClassName('pricelist-update')[0].removeAttribute('disabled');
  }

  updatePricelist() {
    const elements = document.getElementsByClassName('pricelist-elem');
    for (var i = 0; i < elements.length; i++) {
      elements[i].setAttribute('disabled', 'disabled');
    }
    document.getElementsByClassName('pricelist-update')[0].setAttribute('disabled', 'disabled');

    if (this.pricelistDTO === undefined) {
      this.pricelistService.createPricelist(this.pricelist, this.airline.id).subscribe(
        data => {
          this.responseMessage = data;
          alert(this.responseMessage.message);
        }
      );
      location.reload();
    } else {
      console.log(this.pricelist);
      this.pricelistService.updatePricelist(this.pricelist).subscribe(
        data => {
          this.responseMessage = data;
          alert(this.responseMessage.message);
        }
      );
      location.reload();
    }
  }

}
