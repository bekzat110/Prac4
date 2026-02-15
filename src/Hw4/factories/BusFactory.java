package Hw4.factories;

import Hw4.vehicles.Bus;
import Hw4.vehicles.IVehicle;

public class BusFactory extends VehicleFactory {

    private final int seats;
    private final boolean hasWifi;

    public BusFactory(int seats, boolean hasWifi) {
        this.seats = seats;
        this.hasWifi = hasWifi;
    }

    @Override
    public IVehicle createVehicle() {
        return new Bus(seats, hasWifi);
    }
}
