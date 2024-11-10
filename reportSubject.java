//subject interface
package project;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

public interface reportSubject {
    void registerObserver (ReportObserver ob);
    void removeObserver(ReportObserver ob);
    void notifyObservers(PDPageContentStream cs) throws IOException;
}

