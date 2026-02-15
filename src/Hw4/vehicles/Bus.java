package Hw4.vehicles;

public class Bus implements IVehicle {

    private final int seats;
    private final boolean hasWifi;

    public Bus(int seats, boolean hasWifi) {
        this.seats = seats;
        this.hasWifi = hasWifi;
    }

    @Override
    public void drive() {
        System.out.println("Автобус едет. Мест: " + seats +
                ", Wi-Fi: " + (hasWifi ? "есть" : "нет"));
    }

    @Override
    public void refuel() {
        System.out.println("Автобус заправляется.");
    }
}
