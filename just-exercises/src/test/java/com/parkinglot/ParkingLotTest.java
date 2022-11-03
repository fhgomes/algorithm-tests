package com.parkinglot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(target.enterCar());
        assertTrue(target.enterMoto());
        assertTrue(target.enterCar());
        assertTrue(target.enterMoto());

        target.exitCar(1);
        assertTrue(target.enterMoto());
        assertEquals(1, target.printCountExits());
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

        assertTrue(target.enterMoto());
        assertTrue(target.enterMoto());
        assertTrue(target.enterMoto());

        target.exitMoto(2);

        assertFalse(target.enterCar());
        assertEquals(1,target.printCountExits());
    }
}