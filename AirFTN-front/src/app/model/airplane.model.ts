import { AirlineCompanyDTO, AirlineCompany } from './company.model';
import { Seat } from './seat.model';

export class AirplaneDTO {

    model: string;
    numberOfSeats: number;
    airlineId: BigInteger;
}

export class Airplane {

    id: BigInteger;
    model: string;
    numberOfSeats: number;
    seats: Seat;
    airline: AirlineCompany;
    deleted: boolean;
}
