import { TransferPointDTO } from './transfer.model';
import { AirlineCompanyDTO, AirlineCompany } from './company.model';
import { AirplaneDTO } from './airplane.model';
import { Destination } from './destination.model';

export class FlightDTO {

    flightNumber: string;
    companyId: BigInteger;
    airplaneId: BigInteger;
    departure: Date;
    arrival: Date;
    destinationId: BigInteger;
    mileage: number;
    durationOfFlight: number;
    price: number;

}

export class Flight {

    id: BigInteger;
    flightNumber: string;
    company: AirlineCompany;
    airplane: AirplaneDTO;
    departureDate: Date;
    arrivalDate: Date;
    destination: Destination;
    mileage: number;
    durationOfFlight: number;
    transfers: TransferPointDTO[];
    price: number;
}
