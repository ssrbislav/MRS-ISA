import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatSort, MatTableDataSource, MatDialogConfig, MatDialog } from '@angular/material';
import { FlightService } from 'src/app/services/flight.service';
import { Flight } from 'src/app/model/flight.model';
import { AirlineCompany } from 'src/app/model/company.model';
import { MakeReservationComponent } from './make-reservation/make-reservation.component';

@Component({
  selector: 'app-show-airline-flights',
  templateUrl: './show-airline-flights.component.html',
  styleUrls: ['./show-airline-flights.component.css']
})
export class ShowAirlineFlightsComponent implements OnInit {

  flights: Flight[];
  airline: AirlineCompany;
  dataSource: MatTableDataSource<Flight>;

  displayedColumns: string[] = ['flightNumber', 'airline', 'airplane', 'departure',
    'arrival', 'destination', 'mileage',
    'duration', 'price', 'transfer', 'reserve'];

  @ViewChild(MatSort) sort: MatSort;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private flightService: FlightService,
              private dialog: MatDialog) { }

  ngOnInit() {
    this.dialogRef.updateSize('80%', '60%');
    this.airline = this.data.airline;
    this.getFlights();
  }

  filterFlights(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  getFlights() {
    this.flightService.getAllAirlineFlights(this.airline.id).subscribe(
      data => {
        this.flights = data;
        this.dataSource = new MatTableDataSource(this.flights);
        this.dataSource.sort = this.sort;
      });
  }

  openForReservation(flight: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: 1,
      added: false,
      flight
    };

    const dialogRef = this.dialog.open(MakeReservationComponent, dialogConfig);
  }

}
