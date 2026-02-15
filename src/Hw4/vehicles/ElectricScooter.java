package Hw4.vehicles;

public class ElectricScooter implements IVehicle {

    private final int battery;
    private final double maxSpeed;
    private final boolean hasSeat;

    public ElectricScooter(int battery, double maxSpeed, boolean hasSeat) {
        this.battery = battery;
        this.maxSpeed = maxSpeed;
        this.hasSeat = hasSeat;
    }

    @Override
    public void drive() {
        System.out.println("Электросамокат едет. Батарея: " + battery +
                "Wh, Максимальная скорость: " + maxSpeed +
                " км/ч, Сиденье: " + (hasSeat ? "есть" : "нет"));
    }

    @Override
    public void refuel() {
        System.out.println("Электросамокат заряжается.");
    }
}
