package Pr4.creators;

import Pr4.documents.Document;
import Pr4.documents.Report;

public class ReportCreator extends DocumentCreator {

    @Override
    public Document createDocument() {
        return new Report();
    }
}
