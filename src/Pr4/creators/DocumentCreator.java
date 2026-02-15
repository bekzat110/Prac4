package Pr4.creators;

import Pr4.documents.Document;

public abstract class DocumentCreator {

    public abstract Document createDocument();

    public void openDocument() {
        Document document = createDocument();
        document.open();
    }
}
