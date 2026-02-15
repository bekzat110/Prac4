package Pr4.creators;

import Pr4.documents.Document;
import Pr4.documents.Letter;

public class LetterCreator extends DocumentCreator {

    @Override
    public Document createDocument() {
        return new Letter();
    }
}
