package Hw4;

import Hw4.factories.*;
import Hw4.vehicles.IVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<IVehicle> vehicles = new ArrayList<>();

        while (true) {

            System.out.println("\n1 - Создать транспорт");
            System.out.println("2 - Проверить транспорт");
            System.out.println("0 - Выход");
            System.out.print("Выберите действие: ");

            String action = sc.nextLine();

            if (action.equals("0")) break;

            if (action.equals("1")) {

                System.out.println("Выберите тип транспорта:");
                System.out.println("1 - Автомобиль");
                System.out.println("2 - Мотоцикл");
                System.out.println("3 - Грузовик");
                System.out.println("4 - Автобус");
                System.out.println("5 - Электросамокат");

                String type = sc.nextLine();

                VehicleFactory factory = switch (type) {
                    case "1" -> new CarFactory("Toyota", "Camry", "Бензин");
                    case "2" -> new MotorcycleFactory("Спортивный", 600);
                    case "3" -> new TruckFactory(10, 4);
                    case "4" -> new BusFactory(40, true);
                    case "5" -> new ElectricScooterFactory(500, 25, false);
                    default -> throw new IllegalArgumentException("Неверный тип транспорта");
                };

                IVehicle v = factory.createVehicle();
                vehicles.add(v);

                v.drive();
                v.refuel();
            }

            if (action.equals("2")) {
                for (IVehicle v : vehicles) {
                    v.drive();
                    v.refuel();
                }
            }
        }

        sc.close();
    }
}
