package Pr4.creators;

import Pr4.documents.Document;
import Pr4.documents.Resume;

public class ResumeCreator extends DocumentCreator {

    @Override
    public Document createDocument() {
        return new Resume();
    }
}
