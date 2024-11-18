package comp3607_project;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;

public class PdfGenerator {
    
    public void createPDF(String fileDest,String content){


        try{
            PdfWriter writer= new PdfWriter(fileDest);
            PdfDocument pdf= new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph(content));
            document.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

}
