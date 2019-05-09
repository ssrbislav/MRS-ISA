import { Component, OnInit, ViewChild } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { Router } from '@angular/router';


@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})
export class PassengerComponent implements OnInit {

  @ViewChild('header') header: HeaderComponent;

  constructor(private router: Router) { }

  ngOnInit() {

  }

  navigateHotels() {
    this.router.navigate(['hotel']);
  }

  navigateAirlineCompanies() {
    this.router.navigate(['airlines']);
  }

}
