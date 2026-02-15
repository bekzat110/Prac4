package Hw4.vehicles;

public class Motorcycle implements IVehicle {

    private final String bikeType;
    private final int engineVolume;

    public Motorcycle(String bikeType, int engineVolume) {
        this.bikeType = bikeType;
        this.engineVolume = engineVolume;
    }

    @Override
    public void drive() {
        System.out.println("Мотоцикл (" + bikeType + ", " + engineVolume + "cc) едет.");
    }

    @Override
    public void refuel() {
        System.out.println("Мотоцикл заправляется.");
    }
}
