package com.parkinglot;

import org.junit.jupiter.api.Test;

class ParkingLotTest {
    /*
        Input:
        - Spots: 3
        - Sequence
        - Enter Car  #1
        - Enter Moto #1
        - Enter Car  #2
        - Enter Moto #2
        - Exit  Car  #1
        - Enter Moto #3
        - Output: 1
     */
    @Test
    void testFirstCase() {
        ParkingLot target = new  ParkingLot(3);

        target.enterCar();
        target.enterMoto();
        target.enterCar();
        target.enterMoto();

        target.exitCar(1);
        target.enterMoto();
        target.printCountExits();
    }

    /*
        Input:
        - Spots: 2
        - Sequence
        - Enter Moto #1
        - Enter Moto #2
        - Enter Moto #3
        - Exit  Moto #2
        - Enter Car  #1 //Turned away
        - Output: 1
     */
    @Test
    void testSecondCase() {
        ParkingLot target = new  ParkingLot(2);

        target.enterMoto();
        target.enterMoto();
        target.enterMoto();
        target.exitMoto(2);

        target.enterCar();
        target.printCountExits();
    }
}