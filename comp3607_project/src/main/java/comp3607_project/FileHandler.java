package comp3607_project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class FileHandler {
    
    public void extractFiles(String submissionFolder){
        unzip(submissionFolder);
        prependJavaFiles(submissionFolder);
    }

    private void unzip(String submissionFolder){
        String folderPath= System.getProperty("user.dir") + "\\src\\main\\resources\\" + submissionFolder + ".zip";
        String destFolder= System.getProperty("user.dir") +"\\src\\main\\java\\comp3607_project\\"+ submissionFolder;


        try{
            ZipFile zipFile= new ZipFile(folderPath);
            zipFile.extractAll(destFolder);
        }catch(ZipException e){
            System.out.println("Error unzipping file");
            e.printStackTrace();
        }
        
        
        File folder = new File(destFolder);

        File[] files= folder.listFiles();

        if(files==null || files.length==0){
            System.out.println("No files found in folder: "+ destFolder);
            return;
        }

        for(File file: files){
            if(file.isFile() && file.getName().endsWith(".zip")){
                String filePath= destFolder + "\\" + file.getName().replace(".zip","");

                try{
                    ZipFile zipFile = new ZipFile(file);
                    zipFile.extractAll(filePath);

                }catch(ZipException e){
                    System.err.println("Error extracting file: "+file.getName());
                    e.printStackTrace();
                }
            }

            file.delete();
               

        }

    }

    private void prependJavaFiles(String submissionFolder){
       
        String sourceFolder= System.getProperty("user.dir") +"\\src\\main\\java\\comp3607_project\\"+ submissionFolder;

        File folder = new File(sourceFolder);
        File[] files= folder.listFiles();

        if(files==null || files.length==0){
            System.out.println("No files found in folder: "+ sourceFolder);
            return;
        }

        for(File file: files){
            
            File subFolder= new File(sourceFolder +"\\" + file.getName());
            File[] javaFiles = subFolder.listFiles();

            
            for(File javaFile: javaFiles){
               
                if(javaFile.isFile() && javaFile.getName().endsWith(".java")){
                    try{
                        String originalContent = new String(Files.readAllBytes(Paths.get(javaFile.getAbsolutePath())));
                        String packageString ="package comp3607_project." + submissionFolder + "." + file.getName() + ";\n" + originalContent;

                        Files.write(Paths.get(javaFile.getAbsolutePath()),packageString.getBytes());
                    }catch(IOException e){
                        System.err.println("Error while prepending package name to the file: "+file.getName());
                        e.setStackTrace(null);
                    }
                }
            }    
        }
    }
}
