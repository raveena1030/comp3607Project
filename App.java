package comp3607project;

import java.io.File;
import java.io.IOException;

import comp3607project.ZipFileHandling.FileCollection;
import comp3607project.ZipFileHandling.FileHandler;
import comp3607project.ZipFileHandling.SubmissionCollection;

public class App 
{
    public static void main( String[] args )
    {
        SubmissionCollection submissions = new FileCollection();
        
        File submissionsFolder = new File("C:\\Users\\shani\\OneDrive\\Desktop\\testfolder");

        for (File file:submissionsFolder.listFiles()){
            if(file.isFile() && file.getName().endsWith(".zip")){
                submissions.addSubmission(file);
                System.out.println(file.getName() + " was added");
            }
        }

        FileHandler fileHandler = new FileHandler();
        String outputDirectory = "C:\\Users\\shani\\OneDrive\\Desktop";

        try {
            fileHandler.processSubmissions(submissions, outputDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
