package Pr4;

import Pr4.creators.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип документа:");
        System.out.println("1 - Отчет");
        System.out.println("2 - Резюме");
        System.out.println("3 - Письмо");
        System.out.println("4 - Счет");

        System.out.print("Ваш выбор: ");
        String choice = scanner.nextLine();

        DocumentCreator creator = switch (choice) {
            case "1" -> new ReportCreator();
            case "2" -> new ResumeCreator();
            case "3" -> new LetterCreator();
            case "4" -> new InvoiceCreator();
            default -> throw new IllegalArgumentException("Неверный тип документа");
        };

        creator.openDocument();

        scanner.close();
    }
}
