import { TransferPointDTO } from './transfer.model';

export class FlightDTO {

    flightNumber: string;
    companyId: BigInteger;
    airplaneId: BigInteger;
    departure: Date;
    arrival: Date;
    destinationId: BigInteger;
    millage: number;
    transfers: TransferPointDTO[];
    price: number;

}
