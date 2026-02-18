import java.util.Scanner;

public class Main {

    // 1) IVehicle интерфейсі
    interface IVehicle {
        void drive();
        void refuel();
    }

    // 2) Көлік түрлері
    static class Car implements IVehicle {
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
            System.out.println("Автокөлік қозғалыста: " + brand + " " + model + " (" + fuelType + ")");
        }

        @Override
        public void refuel() {
            System.out.println("Автокөлік " + fuelType + " отынымен толтырылды.");
        }
    }

    static class Motorcycle implements IVehicle {
        private final String type;
        private final int engineCc;

        public Motorcycle(String type, int engineCc) {
            this.type = type;
            this.engineCc = engineCc;
        }

        @Override
        public void drive() {
            System.out.println("Мотоцикл қозғалыста: " + type + ", " + engineCc + "cc");
        }

        @Override
        public void refuel() {
            System.out.println("Мотоцикл жанармаймен толтырылды.");
        }
    }

    static class Truck implements IVehicle {
        private final double capacityTons;
        private final int axles;

        public Truck(double capacityTons, int axles) {
            this.capacityTons = capacityTons;
            this.axles = axles;
        }

        @Override
        public void drive() {
            System.out.println("Жүк көлігі қозғалыста: сыйымдылығы " + capacityTons + " тонна, ось саны " + axles);
        }

        @Override
        public void refuel() {
            System.out.println("Жүк көлігі дизель отынымен толтырылды.");
        }
    }

    static class Bus implements IVehicle {
        private final int seats;
        private final String route;

        public Bus(int seats, String route) {
            this.seats = seats;
            this.route = route;
        }

        @Override
        public void drive() {
            System.out.println("Автобус қозғалыста: маршрут " + route + ", орын саны " + seats);
        }

        @Override
        public void refuel() {
            System.out.println("Автобус жанармаймен толтырылды.");
        }
    }

    // 3) Factory Method
    static abstract class VehicleFactory {
        public abstract IVehicle createVehicle();

        public void testVehicle() {
            IVehicle v = createVehicle();
            v.drive();
            v.refuel();
        }
    }

    // 4) Фабрикалар
    static class CarFactory extends VehicleFactory {
        private final String brand, model, fuelType;

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

    static class MotorcycleFactory extends VehicleFactory {
        private final String type;
        private final int engineCc;

        public MotorcycleFactory(String type, int engineCc) {
            this.type = type;
            this.engineCc = engineCc;
        }

        @Override
        public IVehicle createVehicle() {
            return new Motorcycle(type, engineCc);
        }
    }

    static class TruckFactory extends VehicleFactory {
        private final double capacityTons;
        private final int axles;

        public TruckFactory(double capacityTons, int axles) {
            this.capacityTons = capacityTons;
            this.axles = axles;
        }

        @Override
        public IVehicle createVehicle() {
            return new Truck(capacityTons, axles);
        }
    }

    static class BusFactory extends VehicleFactory {
        private final int seats;
        private final String route;

        public BusFactory(int seats, String route) {
            this.seats = seats;
            this.route = route;
        }

        @Override
        public IVehicle createVehicle() {
            return new Bus(seats, route);
        }
    }

    // 5) Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Көлік түрін таңдаңыз:");
        System.out.println("1 - Автокөлік");
        System.out.println("2 - Мотоцикл");
        System.out.println("3 - Жүк көлігі");
        System.out.println("4 - Автобус");

        int choice = readInt(sc, "Таңдау: ");
        VehicleFactory factory;

        switch (choice) {
            case 1 -> {
                String brand = readLine(sc, "Маркасы: ");
                String model = readLine(sc, "Моделі: ");
                String fuel = readLine(sc, "Отын түрі (бензин/дизель/электр): ");
                factory = new CarFactory(brand, model, fuel);
            }
            case 2 -> {
                String type = readLine(sc, "Мотоцикл түрі (спорт/туристік): ");
                int cc = readInt(sc, "Қозғалтқыш көлемі (cc): ");
                factory = new MotorcycleFactory(type, cc);
            }
            case 3 -> {
                double tons = readDouble(sc, "Жүк көтерімділігі (тонна): ");
                int axles = readInt(sc, "Ось саны: ");
                factory = new TruckFactory(tons, axles);
            }
            case 4 -> {
                int seats = readInt(sc, "Орын саны: ");
                String route = readLine(sc, "Маршрут: ");
                factory = new BusFactory(seats, route);
            }
            default -> {
                System.out.println("Қате таңдау!");
                sc.close();
                return;
            }
        }

        System.out.println("\n Көлік сәтті жасалды. Тексеру нәтижесі:");
        factory.testVehicle();

        sc.close();
    }

    // ===== Көмекші әдістер =====
    private static String readLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Қате! Бүтін сан енгізіңіз.");
            }
        }
    }

    private static double readDouble(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (Exception e) {
                System.out.println("Қате! Сан енгізіңіз.");
            }
        }
    }
}
