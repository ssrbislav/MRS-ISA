import { AirlineCompany } from './company.model';

export class PricelistDTO {

    priceByKm: number;
    economyPricePrecentage: number;
    bussinessPricePrecentage: number;
    firstPricePrecentage: number;
    discountedPrecentage: number;
}

export class Pricelist {

    id: BigInteger;
    priceByKm: number;
    economyPricePrecentage: number;
    bussinessPricePrecentage: number;
    firstPricePrecentage: number;
    discountedPrecentage: number;
    deleted: boolean;
    airline: AirlineCompany;

}
