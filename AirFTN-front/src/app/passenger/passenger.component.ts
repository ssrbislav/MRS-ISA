import { Component, OnInit, ViewChild } from '@angular/core';
import { HeaderComponent } from '../header/header.component';


@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})
export class PassengerComponent implements OnInit {
  
  @ViewChild("header") header: HeaderComponent;

  constructor() { }

  ngOnInit() {
    this.header.passengerView();
  }

}
