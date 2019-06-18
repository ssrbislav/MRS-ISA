import { Ticket } from './ticket.model';
import { Passenger } from './passenger.model';

export class Reservation {

    id: BigInteger;
    passenger: Passenger;
    ticket: Ticket;
    fastReservation: boolean;
}

export class ReservationDTO {

    username: string;
    ticket: Ticket;
    fastReservation: boolean;

}
