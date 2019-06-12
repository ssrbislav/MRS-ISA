import { Flight } from './flight.model';

export class TransferPointDTO {

    arrivalTime: Date;
    departureTime: Date;
    countryAndCity: string;
    flightId: BigInteger;

}

export class TransferPoint {

    id: BigInteger;
    arrivalTime: Date;
    departureTime: Date;
    countryAndCity: string;
    flight: Flight;
    deleted: boolean;

}
