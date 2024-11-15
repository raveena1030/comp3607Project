//observer interface
package project;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public interface ReportObserver {
    void update(PDPageContentStream contentStream) throws IOException;
}
