package comp3607project;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PDFReportData implements ReportSubject {

    private String studentID;
    private String studentName;
    private String assignmentNumber;
    private List<TestResult> results;
    private int totalScore;
    private List<ReportObserver> observers = new ArrayList<>();

    public PDFReportData(String studentID, String name, String assignment, List<TestResult> testResults, int total){
        this.studentID= studentID;
        this.studentName= name;
        this.assignmentNumber= assignment;
        this.results= testResults;
        this.totalScore= total;
    }

    public void registerObserver(ReportObserver ob){
        observers.add(ob);
    }

    public void removeObserver(ReportObserver ob){
        observers.remove(ob);
    }

    public void notifyObservers(PDPageContentStream contentStream)throws IOException{
        for(ReportObserver ob : observers){
            ob.update(contentStream);
        }
    }

    public String getStudentID() { 
        return studentID; 
    
    }

    public String getStudentName() { 
        return studentName; 
    }

    public String getAssignmentNumber() { 
        return assignmentNumber;
    }

    public List<TestResult> getTestResults() { 
        return results; 
    }

    public int getTotalScore() { 
        return totalScore;
    }

    public List<ReportObserver> getObservers(){
        return observers;
    }
}

