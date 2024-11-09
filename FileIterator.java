package comp3607project.ZipFileHandling;

import java.io.*;
import java.util.*;

//concrete iterator
public class FileIterator implements SubmissionIterator {
    private List<File> submissions;
    private int position = 0;

    public FileIterator(List<File> submissions){
        this.submissions = submissions;
    }

    public boolean hasNext(){
        return position < submissions.size();
    }

    public File next(){
        if (!hasNext()){
            throw new java.util.NoSuchElementException("No more submissions.");
        }
        return submissions.get(position++);
    }
}
