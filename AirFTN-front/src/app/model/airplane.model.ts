import { AirlineCompanyDTO, AirlineCompany } from './company.model';

export class AirplaneDTO {

    model: string;
    numberOfSeats: number;
    airlineId: BigInteger;
}

export class Airplane {

    id: BigInteger;
    model: string;
    numberOfSeats: number;
    airline: AirlineCompany;
}
