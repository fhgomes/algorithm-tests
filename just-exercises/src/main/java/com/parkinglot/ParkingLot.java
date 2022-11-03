package com.parkinglot;

/*
Requirements - Parking lot
        -------------
        1. A spot can fit 1 car or 2 motorcycles
        2. Vehicule will park if it's available, motorcycles always park in a half spot if it's available.
        3. If a vehicule can't fit, they'll be turned away
 */

import java.util.HashMap;

public class ParkingLot {

    public static final String TXT_ENTER_MOTO = "Enter Moto  #";
    public static final String TXT_ENTER_CAR = "Enter Car  #";
    int originalSpotSize;
    int qtdCars = 0;
    int qtdMotos = 0;


    int numberOfExits = 0;

    final HashMap<Integer, String[]> mapSlots;

    public ParkingLot(int spots) {
        this.originalSpotSize = spots;
        mapSlots = new HashMap<>();
        for (int i = 1; i < spots+1; i++) {
            mapSlots.put(i, new String[]{});
        }
    }

    public boolean enterCar() {
        String cardId = "c"+(qtdCars+1);

        int slotIndex = 1;
        while (slotIndex < originalSpotSize+1) {
            String[] maybeCarOrMotos = mapSlots.get(slotIndex);
            if (maybeCarOrMotos.length == 0) {
                mapSlots.put(slotIndex, new String[]{cardId});
                qtdCars++;
                System.out.println(TXT_ENTER_CAR + qtdCars);
                return true;
            }
            slotIndex++;
        }

        System.out.println(TXT_ENTER_CAR + (qtdCars+1) + " //Turned away");
        return false;
    }

    public boolean enterMoto() {
        String motoId = "m"+(qtdMotos+1);
        int slotIndex = 1;
        while (slotIndex < originalSpotSize+1) {
            String[] maybeCarOrMotos = mapSlots.get(slotIndex);
            if (maybeCarOrMotos.length == 0) {
                mapSlots.put(slotIndex, new String[]{motoId});
                qtdMotos++;
                System.out.println(TXT_ENTER_MOTO + qtdMotos);
                return true;
            } else if (maybeCarOrMotos.length == 1 && maybeCarOrMotos[0].startsWith("m")) {
                mapSlots.put(slotIndex, new String[]{maybeCarOrMotos[0], motoId});
                qtdMotos++;
                System.out.println(TXT_ENTER_MOTO + qtdMotos);
                return true;
            }
            slotIndex++;
        }

        System.out.println(TXT_ENTER_MOTO + (qtdMotos+1) + " //Turned away");

        return false;
    }

    public int printCountExits() {
        System.out.println("Output: "+ numberOfExits);
        return numberOfExits;
    }

    public void exitCar(int index) {
        String carId = "c"+index;
        int slotIndex = 1;
        while (slotIndex < originalSpotSize+1) {
            String[] maybeCarOrMotos = mapSlots.get(slotIndex);
            if (maybeCarOrMotos.length == 0) {
                continue;
            }
            if (maybeCarOrMotos.length == 1 && maybeCarOrMotos[0].equals(carId)) {
                mapSlots.put(slotIndex, new String[]{});
                System.out.println("Exit car #"+index);
                numberOfExits++;
                return;
            }
            slotIndex++;
        }
        System.out.println("Car not found#"+index);
    }

    public void exitMoto(int index) {
        String motoId = "m"+index;
        int slotIndex = 1;
        while (slotIndex < originalSpotSize+1) {
            String[] maybeCarOrMotos = mapSlots.get(slotIndex);
            if (maybeCarOrMotos.length == 0) {
                continue;
            }

            if (maybeCarOrMotos[0].equals(motoId)) {
                if (maybeCarOrMotos.length == 1) {
                    mapSlots.put(slotIndex, new String[]{});
                } else {
                    mapSlots.put(slotIndex, new String[]{maybeCarOrMotos[1]});
                }
                numberOfExits++;
                System.out.println("Exit Moto #"+index);
                return;
            }
            if (maybeCarOrMotos.length == 2 && maybeCarOrMotos[1].equals(motoId)) {
                mapSlots.put(slotIndex, new String[]{maybeCarOrMotos[0]});
                numberOfExits++;
                System.out.println("Exit Moto #"+index);
                return;
            }
            slotIndex++;
        }
        System.out.println("Moto not found #"+index);
    }

}
