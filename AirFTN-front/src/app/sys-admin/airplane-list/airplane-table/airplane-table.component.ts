import { Component, OnInit } from '@angular/core';
import { AirplaneService } from 'src/app/services/airplane.service';

@Component({
  selector: 'app-airplane-table',
  templateUrl: './airplane-table.component.html',
  styleUrls: ['./airplane-table.component.css']
})
export class AirplaneTableComponent implements OnInit {

  airplanes: any;

  constructor(private airplaneService: AirplaneService) { }

  ngOnInit() {
    this.getAirplanes();
  }

  getAirplanes() {
    this.airplaneService.getAllAirplanes().subscribe(
      data => {
        this.airplanes = data;
      }
    )
  }

}
