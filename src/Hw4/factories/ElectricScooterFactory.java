package Hw4.factories;

import Hw4.vehicles.ElectricScooter;
import Hw4.vehicles.IVehicle;

public class ElectricScooterFactory extends VehicleFactory {

    private final int battery;
    private final double maxSpeed;
    private final boolean hasSeat;

    public ElectricScooterFactory(int battery, double maxSpeed, boolean hasSeat) {
        this.battery = battery;
        this.maxSpeed = maxSpeed;
        this.hasSeat = hasSeat;
    }

    @Override
    public IVehicle createVehicle() {
        return new ElectricScooter(battery, maxSpeed, hasSeat);
    }
}
