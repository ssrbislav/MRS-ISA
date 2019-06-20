import { Passenger } from './passenger.model';

export class FriendRequest {

    senderId: BigInteger;
    receiverId: BigInteger;
    delete: boolean;
    person: Passenger;
}
