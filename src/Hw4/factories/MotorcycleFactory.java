package Hw4.factories;

import Hw4.vehicles.IVehicle;
import Hw4.vehicles.Motorcycle;

public class MotorcycleFactory extends VehicleFactory {

    private final String bikeType;
    private final int engineVolume;

    public MotorcycleFactory(String bikeType, int engineVolume) {
        this.bikeType = bikeType;
        this.engineVolume = engineVolume;
    }

    @Override
    public IVehicle createVehicle() {
        return new Motorcycle(bikeType, engineVolume);
    }
}
