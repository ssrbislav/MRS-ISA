import { AdminDTO } from './admin.model';

export class AirlineCompanyDTO {

    id: BigInteger;
    name: string;
    city: string;
    address: string;
    description: string;
    planes: any;
    flights: any;
    destination: any;
    fastReservationTickets: any;
    admin: AdminDTO;
    adminId: BigInteger;
    deleted: boolean;

}

export class AirlineCompany {

    id: BigInteger;
    name: string;
    city: string;
    address: string;
    description: string;
    planes: any;
    flights: any;
    destination: any;
    fastReservationTickets: any;
    admin: AdminDTO;
    deleted: boolean;

}
