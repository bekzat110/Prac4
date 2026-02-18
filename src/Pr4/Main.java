package Pr4;

import java.util.Scanner;

interface Document {
    void open();
}

class Report implements Document {
    @Override
    public void open() {
        System.out.println("Отчет открыт. Отображается аналитическая информация.");
    }
}

class Resume implements Document {
    @Override
    public void open() {
        System.out.println("Резюме открыто. Отображаются данные кандидата.");
    }
}

class Letter implements Document {
    @Override
    public void open() {
        System.out.println("Письмо открыто. Отображается текст письма.");
    }
}

class Invoice implements Document {
    @Override
    public void open() {
        System.out.println("Счет (Pr4.Invoice) открыт. Отображаются данные для оплаты.");
    }
}

abstract class DocumentCreator {

    public abstract Document createDocument();

    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }
}

class ReportCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Report();
    }
}

class ResumeCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Resume();
    }
}

class LetterCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Letter();
    }
}

class InvoiceCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Invoice();
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DocumentCreator creator = null;

        System.out.println("Выберите тип документа:");
        System.out.println("1 - Отчет");
        System.out.println("2 - Резюме");
        System.out.println("3 - Письмо");
        System.out.println("4 - Счет (Pr4.Invoice)");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                creator = new ReportCreator();
                break;
            case 2:
                creator = new ResumeCreator();
                break;
            case 3:
                creator = new LetterCreator();
                break;
            case 4:
                creator = new InvoiceCreator();
                break;
            default:
                System.out.println("Неверный выбор.");
                System.exit(0);
        }

        System.out.println("\nСоздание документа...");
        creator.openDocument();

        scanner.close();
    }
}