import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { TransferPointDTO } from '../model/transfer.model';
import { Observable } from 'rxjs';
import { ResponseMessage } from '../model/responseMessage';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class TransferService {

  constructor(private http: HttpClient) { }

  transferPointUrl = 'http://localhost:8080/api/transferPoint';

  createTransferPoint(info: TransferPointDTO): Observable<ResponseMessage> {
    const url = `${this.transferPointUrl + '/createTP'}`;
    return this.http.post<ResponseMessage>(url, info, httpOptions);
  }

}
