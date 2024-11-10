package project;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;


public class PDFReportGenerator {
    public void generatePDFReport(PDFReportData reportData, String outputFolder) throws IOException{
        PDDocument doc= new PDDocument();
        PDPage page= new PDPage();
        doc.addPage(page);

        try (PDPageContentStream cs = new PDPageContentStream(doc, page)){
            reportData.notifyObservers(cs);
        }

        
        String outputPath = outputFolder + "/" + reportData.getStudentID() + "_" + reportData.getAssignmentNumber() + "_Report.pdf";
        doc.save(outputPath);
        doc.close();
    }

        
    
}
