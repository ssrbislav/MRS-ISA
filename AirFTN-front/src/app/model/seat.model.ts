import { SeatType } from './seat-type.enum';

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
    airplaneId: BigInteger;
    deleted: false;
    occupied: boolean;
}
