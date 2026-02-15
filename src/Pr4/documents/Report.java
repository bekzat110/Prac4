package Pr4.documents;

public class Report implements Document {

    @Override
    public void open() {
        System.out.println("Открыт документ: Отчет.");
    }
}
