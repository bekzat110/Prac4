package Hw4.vehicles;

public class Truck implements IVehicle {

    private final double payload;
    private final int axles;

    public Truck(double payload, int axles) {
        this.payload = payload;
        this.axles = axles;
    }

    @Override
    public void drive() {
        System.out.println("Грузовик едет. Грузоподъёмность: " + payload + " тонн, Осей: " + axles);
    }

    @Override
    public void refuel() {
        System.out.println("Грузовик заправляется.");
    }
}
