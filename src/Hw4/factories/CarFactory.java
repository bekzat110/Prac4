package Hw4.factories;

import Hw4.vehicles.Car;
import Hw4.vehicles.IVehicle;

public class CarFactory extends VehicleFactory {

    private final String brand;
    private final String model;
    private final String fuelType;

    public CarFactory(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public IVehicle createVehicle() {
        return new Car(brand, model, fuelType);
    }
}
