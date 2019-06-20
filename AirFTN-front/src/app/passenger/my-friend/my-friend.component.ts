import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Passenger } from 'src/app/model/passenger.model';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { PassengerService } from 'src/app/services/passenger.service';
import { ResponseMessage } from 'src/app/model/responseMessage';
import { FriendRequest } from 'src/app/model/friendRequest.model';

@Component({
  selector: 'app-my-friend',
  templateUrl: './my-friend.component.html',
  styleUrls: ['./my-friend.component.css']
})
export class MyFriendComponent implements OnInit {

  friends: Passenger[];
  username: any;
  receiver: any;
  message: ResponseMessage = new ResponseMessage();
  request: FriendRequest = new FriendRequest();
  friendRequests: FriendRequest[];

  listOfPeople: Passenger[] = [];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<any>,
              private tokenStorage: TokenStorageService,
              private passengerService: PassengerService) { }

  ngOnInit() {
    this.dialogRef.updateSize('60%', '70%');
    this.getFriendRequests(this.data.passenger.id);
    this.getFriends(this.data.passenger.id);
  }

  sendRequest() {
    this.request.receiverId = this.receiver.id;
    this.request.senderId = this.data.passenger.id;
    this.passengerService.sendFrinedRequest(this.request).subscribe(
      result => {
        this.message = result;
        console.log(this.message.message);
        this.dialogRef.close();
      }
    );
  }

  getReceiver(username: string) {
    this.passengerService.getPassenger(username).toPromise().then(
      data => {
        this.receiver = data;
        if (this.receiver !== 'undefined') {
          window.alert('User exists!');
          document.getElementById('send').removeAttribute('disabled');
        }
      }
    );
  }

  getFriendRequests(id: BigInteger) {
    this.passengerService.getFriendRequests(id).subscribe(
      result => {
        this.friendRequests = result;
        this.friendRequests.forEach(element => {
          this.passengerService.getPassengerById(element.senderId).subscribe(
            data => {
              element.person = data;
            }
          );
        });
      }
    );
  }

  getFriends(id: BigInteger) {
    this.passengerService.getFriends(id).subscribe(
      data => {
        this.friends = data;
        console.log(this.friends);
      }
    );
  }

  acceptRequest(friendRequest: FriendRequest) {
    this.passengerService.confirmFriendRequest(friendRequest).subscribe(
      data => {
        this.message = data;
        console.log(this.message.message);
      }
    );
  }

  rejectRequest(friendRequest: FriendRequest) {
    this.passengerService.rejectFriendRequest(friendRequest).subscribe(
      data => {
        this.message = data;
        console.log(this.message.message);
      }
    );
  }


}
