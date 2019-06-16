import { AirlineCompany } from './company.model';

export class PricelistDTO {

    luggagePrice: number;
    economyPricePrecentage: number;
    bussinessPricePrecentage: number;
    firstPricePrecentage: number;
    discountedPrecentage: number;
}

export class Pricelist {

    id: BigInteger;
    luggagePrice: number;
    economyPricePrecentage: number;
    bussinessPricePrecentage: number;
    firstPricePrecentage: number;
    discountedPrecentage: number;
    deleted: boolean;
    airline: AirlineCompany;

}
