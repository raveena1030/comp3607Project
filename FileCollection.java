package comp3607project.ZipFileHandling;

import java.util.*;
import java.io.*;

//Concrete Aggregate
public class FileCollection implements SubmissionCollection {
    private List<File> submissions;

    public FileCollection(){
        this.submissions = new ArrayList<>();
    }

    public void addSubmission(File file){
        submissions.add(file);
    }

    public SubmissionIterator createFileIterator(){
        return new FileIterator(submissions);
    }
}
