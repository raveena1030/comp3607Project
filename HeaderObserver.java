package project;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;

public class HeaderObserver implements ReportObserver {
    private PDFReportData reportData;

    public HeaderObserver(PDFReportData reportData){
        this.reportData= reportData;
    }

    public void update(PDPageContentStream contentStream) throws IOException {
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
        contentStream.setLeading(20f);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 750);

        contentStream.showText("Student Report for " + reportData.getStudentName());
        contentStream.newLine();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.showText("Student ID: " + reportData.getStudentID());
        contentStream.newLine();
        contentStream.showText("Assignment #: " + reportData.getAssignmentNumber());
        contentStream.newLine();
        contentStream.showText("Total Score: " + reportData.getTotalScore());
        contentStream.newLine();
        contentStream.newLine();
        contentStream.endText();
    }
}
