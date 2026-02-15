package Pr4.documents;

public class Letter implements Document {

    @Override
    public void open() {
        System.out.println("Открыт документ: Письмо.");
    }
}
