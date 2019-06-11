import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { DestinationDTO, Destination } from '../model/destination.model';
import { ResponseMessage } from '../model/responseMessage';
import { Observable } from 'rxjs';

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
    return this.http.get<Destination[]>(this.destinationUrl);
  }

  getAllByCompanyId(id: BigInteger) {
    const url = `${this.destinationUrl + '/getDestinationByCompanyId/' + id}`;
    return this.http.get<DestinationDTO[]>(url);
  }

  createDestination(info: DestinationDTO): Observable<ResponseMessage> {
    const url = `${this.destinationUrl + '/createDestination'}`;
    return this.http.post<ResponseMessage> (url, info, httpOptions);
  }

}
