package com.storozhuk.lesson4;

/**
 * Class Car
 *
 * Creates object Car with specified tank volume, fuel consumption
 * and fuel in tank.
 */
public class Car {
    double tankVolume;
    double fuelInTank;
    double fuelConsumption;

    Car(double tVol, double fCons, double fInTank) {
        this.tankVolume = tVol;
        this.fuelConsumption = fCons;
        this.fuelInTank = fInTank;
    }

    /* Fill the tank completely considering the remainder. Returns required amount of fuel. */
    public double fillTankCompletely() {
        double fuelRequired = this.tankVolume - this.fuelInTank;
        this.fuelInTank += fuelRequired;
        return fuelRequired;
    }

    /* Calculate the required amount of fuel per distance. */
    public double fuelRequiredForDist(double distance) {
        double fuelRequired = this.fuelConsumption*distance/100;
        this.fuelInTank -= fuelRequired;
        return fuelRequired;
    }

    /* Calculate the remaining amount of fuel in the tank after the distance. */
    public double fuelRemainAfterDist(double distance) {
        return (this.fuelInTank-fuelRequiredForDist(distance));
    }
}
