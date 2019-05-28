import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { DestinationService } from 'src/app/services/destination.service';
import { TouchSequence } from 'selenium-webdriver';

@Component({
  selector: 'app-destinations-table',
  templateUrl: './destinations-table.component.html',
  styleUrls: ['./destinations-table.component.css']
})
export class DestinationsTableComponent implements OnInit {

  destinations: any;

  constructor(private destinationService: DestinationService) { }

  ngOnInit() {
    this.loadAllDestinations();
  }

  loadAllDestinations() {
    this.destinationService.getAllDestinations().subscribe(
      data => {
        this.destinations = data;
      }
    );
  }

}
