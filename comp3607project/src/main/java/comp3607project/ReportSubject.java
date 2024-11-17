package comp3607project;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

public interface ReportSubject {
    void registerObserver (ReportObserver ob);
    void removeObserver(ReportObserver ob);
    void notifyObservers(PDPageContentStream cs) throws IOException;
}

