import { Flight } from './flight.model';
import { Seat } from './seat.model';

export class Ticket {

}

export class FastTicket {

    price: number;
    seat: Seat;
    flight: Flight;
    fastTicket: true;
}
