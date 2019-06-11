export class TransferPointDTO {

    arrival: Date;
    departure: Date;
    countryAndCity: string;

}

export class TransferPoint {

    id: BigInteger;
    arrival: Date;
    departure: Date;
    countryAndCity: string;
    deleted: boolean;

}
