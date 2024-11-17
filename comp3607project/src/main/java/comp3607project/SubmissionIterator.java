package comp3607project;

import java.io.File;

//Abstract iterator
public interface SubmissionIterator {
    public boolean hasNext();
    public File next();
}
