package comp3607project;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class TestResultsObserver implements ReportObserver{
    private PDFReportData reportData;

    public TestResultsObserver(PDFReportData reportData){
        this.reportData= reportData;
    }

     public void update(PDPageContentStream contentStream) throws IOException {
        contentStream.setFont(PDType1Font.HELVETICA, 10);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 700);

        for (TestResult result : reportData.getTestResults()) {
            contentStream.showText("Test: " + result.testName);
            contentStream.newLine();
            contentStream.showText("Status: " + (result.passed ? "Passed" : "Failed"));
            contentStream.newLine();
            contentStream.showText("Score: " + result.score);
            contentStream.newLine();
            if (!result.passed) {
                contentStream.showText("Feedback: " + result.feedback);
                contentStream.newLine();
            }
            contentStream.newLine();
        }
        contentStream.endText();
    }
}
