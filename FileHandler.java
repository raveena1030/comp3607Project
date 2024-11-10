package comp3607project.ZipFileHandling;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileHandler {
    
    public void processSubmissions(SubmissionCollection submissions, String outputDirectory) throws IOException{
        SubmissionIterator iterator = submissions.createFileIterator();

        while (iterator.hasNext()){
            File zipFile = iterator.next();
            System.out.println("Processing submission: " + zipFile.getName());
            extractJavaFiles(zipFile, outputDirectory);
            //implement jUnit code
            //implement pdfGeneration code
        }
    }

    private void extractJavaFiles(File zipFile, String outputDir) throws IOException {
        Path outputPath = Paths.get(outputDir);
        if (!Files.exists(outputPath)) {
            Files.createDirectories(outputPath);
        }

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                if (zipEntry.getName().endsWith(".java")) {
                    Path extractedFilePath = outputPath.resolve(zipEntry.getName());
                    Files.createDirectories(extractedFilePath.getParent());
                    
                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(extractedFilePath.toFile()))) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = zis.read(buffer)) != -1) {
                            bos.write(buffer, 0, bytesRead);
                        }
                    }
                    System.out.println("Extracted Java file: " + extractedFilePath);
                }
                zis.closeEntry();
            }
        }
    }
}
