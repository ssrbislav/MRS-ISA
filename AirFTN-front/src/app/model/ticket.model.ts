import { Flight } from './flight.model';
import { Seat } from './seat.model';
import { AirlineCompany } from './company.model';

export class Ticket {

    id: BigInteger;
    price: number;
    seat: Seat;
    flight: Flight;
    airline: AirlineCompany;
    fastTicket: boolean;
}


