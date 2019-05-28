import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { DestinationDTO } from '../model/destination.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class DestinationService {

  constructor(private http: HttpClient) { }

  destinationUrl = 'http://localhost:8080/api/destination';

  getAllDestinations() {
    return this.http.get<DestinationDTO[]>(this.destinationUrl);
  }

}
