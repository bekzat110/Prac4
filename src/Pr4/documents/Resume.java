package Pr4.documents;

public class Resume implements Document {

    @Override
    public void open() {
        System.out.println("Открыт документ: Резюме.");
    }
}
