package Pr4.documents;

public class Invoice implements Document {

    @Override
    public void open() {
        System.out.println("Открыт документ: Счет (Invoice).");
    }
}
