package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        
    //     List<testResult> testResults = new ArrayList<>();
    //   testResults.add(new testResult("Naming Conventions", true, "", 5));
    // testResults.add(new testResult("Method Functionality", false, "Incorrect return type.", 3));
    //  testResults.add(new testResult("Inheritance", true, "", 10));

    //    String studentID = "816";
    //    String studentName = "John Doe";
    //    String assignmentNumber = "Assignment 1";
    //    int totalScore = testResults.stream().mapToInt(tr -> tr.score).sum(); // Sum of test scores
    //    String outputFolder = "./"; // Output folder for the PDF

        PDFReportData reportData = new PDFReportData(studentID, StudentName, assignmentNumber, testResults, totalScore);
        reportData.registerObserver(new HeaderObserver(reportData));
        reportData.registerObserver(new TestResultsObserver(reportData));
        
        // Create PDF report
        try {
            PDFReportGenerator.generatePDFReport( studentID, studentName, assignmentNumber, testResults, totalScore, outputFolder);
            System.out.println("PDF Report generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }
}
