import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest, HttpEvent } from '@angular/common/http';
import { Passenger } from '../model/passenger.model';
import { Observable } from 'rxjs';
import { ResponseMessage } from '../model/responseMessage';
import { FriendRequest } from '../model/friendRequest.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PassengerService {

  constructor(private http: HttpClient) { }

  passengerUrl = 'http://localhost:8080/api/passenger';
  friendRequestUrl = 'http://localhost:8080/api/friendRequest';

  public getPassengers() {
    return this.http.get<Passenger[]>(this.passengerUrl);
  }

  public getPassengerById(id: BigInteger) {
    return this.http.get<Passenger>(`${this.passengerUrl + '/getPassengerById'}/${id}`);
  }

  public getPassenger(username: string) {
    return this.http.get<Passenger>(`${this.passengerUrl + '/getPassenger'}/${username}`);
  }

  public getPassengerActive(username: string) {
    return this.http.get<boolean>(`${this.passengerUrl + '/getPassengerActive'}/${username}`);
  }

  public updatePassenger(info: Passenger): Observable<ResponseMessage> {
    return this.http.post<ResponseMessage>(`${this.passengerUrl + '/updatePassenger'}`, info, httpOptions);
  }

  public sendFrinedRequest(info: FriendRequest): Observable<ResponseMessage> {
    return this.http.post<ResponseMessage>(`${this.friendRequestUrl + '/create'}`, info, httpOptions);
  }

  public getFriendRequests(id: BigInteger) {
    return this.http.get<FriendRequest[]>(`${this.friendRequestUrl + '/findByReceiverId'}/${id}`);
  }

  public getFriends(id: BigInteger) {
    return this.http.get<Passenger[]>(`${this.passengerUrl + '/getFriends'}/${id}`);
  }

  confirmFriendRequest(info: FriendRequest): Observable<ResponseMessage>  {
    return this.http.post<ResponseMessage>(`${this.friendRequestUrl + '/confirmFriendRequest'}`, info, httpOptions);
  }

  rejectFriendRequest(info: FriendRequest): Observable<ResponseMessage>  {
    return this.http.post<ResponseMessage>(`${this.friendRequestUrl + '/delete'}`, info, httpOptions);
  }

}
