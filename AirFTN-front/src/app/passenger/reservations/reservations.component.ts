import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {MatIconRegistry} from '@angular/material/icon';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

  constructor(private location: Location) { }

  ngOnInit() {
  }

  back_navigate() {
    this.location.back();
  }

}
