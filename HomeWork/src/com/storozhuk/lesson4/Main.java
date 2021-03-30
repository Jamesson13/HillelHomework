package com.storozhuk.lesson4;

public class Main {
    public static void main(String[] args) {
        final double ODESSA_KRYVEOZERO_DIST = 178.0d;
        final double KRYVEOZERO_JASHKIV_DIST = 153.0d;
        final double JASHKIV_KYIV_DIST = 148.0d;

        double fuelRequiredForTour = 0;
        double fuelRequired;
        double fuelPrice;

        Car discovery = new Car(90, 8.3, 0);

        if (args.length == 0) {
            System.out.println("No arguments set.");
            return;
        }

        fuelPrice = Double.parseDouble(args[0]);
        System.out.println("Fuel price: " + fuelPrice);

        fuelRequired = discovery.fillTankCompletely();
        fuelRequiredForTour += fuelRequired;
        System.out.println("Refilling in Odessa. Fuel required: "
                + String.format("%.2f", fuelRequired) + " l. Money spent: "
                + String.format("%.2f", fuelRequired*fuelPrice)+ " UAH");

        fuelRequired = discovery.fuelRequiredForDist(ODESSA_KRYVEOZERO_DIST);
        fuelRequiredForTour += fuelRequired;
        System.out.println("Refilling in Kryve Ozero. Fuel required: "
                + String.format("%.2f", discovery.fillTankCompletely()) + " l. Money spent: "
                + String.format("%.2f", fuelRequired*fuelPrice)+ " UAH");

        fuelRequired = discovery.fuelRequiredForDist(KRYVEOZERO_JASHKIV_DIST);
        fuelRequiredForTour += fuelRequired;
        System.out.println("Refilling in Jashkiv. Fuel required: "
                + String.format("%.2f", discovery.fillTankCompletely()) + " l. Money spent: "
                + String.format("%.2f", fuelRequired*fuelPrice)+ " UAH");


        System.out.println("Currently in Kyiv. Fuel remain: "
                + String.format("%.2f", discovery.fuelRemainAfterDist(JASHKIV_KYIV_DIST))
                + " l. Total money spent: "
                + String.format("%.2f", fuelRequiredForTour*fuelPrice) + " UAH");
    }
}
