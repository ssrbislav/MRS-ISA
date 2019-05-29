import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PricelistDTO } from '../model/pricelist.model';
import { Observable } from 'rxjs';
import { ResponseMessage } from '../model/responseMessage';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PricelistService {

  constructor(private http: HttpClient) { }

  pricelistUrl = 'http://localhost:8080/api/pricelist/';

  getPricelists() {
    return this.http.get<PricelistDTO[]>(this.pricelistUrl);
  }

  createPricelist(info: PricelistDTO, id: BigInteger): Observable<ResponseMessage> {
    const url = `${this.pricelistUrl + 'createPricelist/' + id}`;
    return this.http.post<ResponseMessage> (url, info, httpOptions);
  }

  updatePricelist(info: PricelistDTO): Observable<ResponseMessage> {
    const url = `${this.pricelistUrl + '/updatePricelist'}`;
    return this.http.post<ResponseMessage> (url, info, httpOptions);
  }

}
