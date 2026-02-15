package Hw4.factories;

import Hw4.vehicles.IVehicle;
import Hw4.vehicles.Truck;

public class TruckFactory extends VehicleFactory {

    private final double payload;
    private final int axles;

    public TruckFactory(double payload, int axles) {
        this.payload = payload;
        this.axles = axles;
    }

    @Override
    public IVehicle createVehicle() {
        return new Truck(payload, axles);
    }
}
