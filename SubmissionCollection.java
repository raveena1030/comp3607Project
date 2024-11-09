package comp3607project.ZipFileHandling;

import java.io.File;

//Aggregate
public interface SubmissionCollection {
    void addSubmission (File file);
    SubmissionIterator createFileIterator();
}
