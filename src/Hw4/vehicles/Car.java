package Hw4.vehicles;

public class Car implements IVehicle {

    private final String brand;
    private final String model;
    private final String fuelType;

    public Car(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public void drive() {
        System.out.println("Автомобиль " + brand + " " + model + " едет. Тип топлива: " + fuelType);
    }

    @Override
    public void refuel() {
        System.out.println("Автомобиль " + brand + " заправляется.");
    }
}
