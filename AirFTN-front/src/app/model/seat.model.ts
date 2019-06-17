import { SeatType } from './seat-type.enum';
import { Airplane } from './airplane.model';

export class SeatDTO {

    row: number;
    column: number;
    seatType: SeatType;
}

export class Seat {

    id: BigInteger;
    row: number;
    column: number;
    seatType: SeatType;
    airplain: Airplane;
    deleted: false;
    occupied: boolean;
}
