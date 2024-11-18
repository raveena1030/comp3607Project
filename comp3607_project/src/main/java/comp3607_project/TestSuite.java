package comp3607_project;

import java.io.File;
import java.util.ArrayList;

public class TestSuite {

    public void runTests(String submissionFolder){
         
        String sourceFolder= System.getProperty("user.dir") +"\\src\\main\\java\\comp3607_project\\"+ submissionFolder;

        File folder = new File(sourceFolder);
        File[] files= folder.listFiles();

        if(files==null || files.length==0){
            System.out.println("No files found in folder: "+ sourceFolder);
        }


        for(File file: files){

            File subFolder= new File(sourceFolder +"\\" + file.getName());
            
            ClassNameExtractor classNames = new ClassNameExtractor();

            ArrayList<Class<?>> classInstances = classNames.getClassInstance(subFolder);
            
            String feedback= new String();
            boolean ChatBotFlag= false;
            boolean ChatBotPlatform= false;
            boolean ChatBotGenerator= false;
            boolean ChatBotSimulation= false;

            for(Class<?> c : classInstances){
                if(c.getSimpleName().equals("ChatBot")){
                    ChatBotTester chatBotTester = new ChatBotTester();
                    feedback+=chatBotTester.printer(c);
                    ChatBotFlag=true;
                }else if(c.getSimpleName().equals("ChatBotPlatform")){
                    ChatBotPlatformTester chatBotPlatformTester = new ChatBotPlatformTester();
                    feedback+=chatBotPlatformTester.runner(c);
                    ChatBotPlatform=true;
                }else if(c.getSimpleName().equals("ChatBotGenerator")){
                    ChatBotGeneratorTester chatBotGeneratorTester = new ChatBotGeneratorTester();
                    feedback+=chatBotGeneratorTester.testGenerateChatBotLLM(c);
                    ChatBotGenerator=true;
                }else if(c.getSimpleName().equals("ChatBotSimulation")){
                    ChatBotSimulationTester chatBotSimulationTester = new ChatBotSimulationTester();
                    feedback+=chatBotSimulationTester.testMain(c);
                    ChatBotSimulation=true;
                }
                feedback+="\n\n";
            }

            if(!ChatBotFlag){
                feedback+="\nMissing ChatBot Class java file.";
            }
            if(!ChatBotPlatform){
                feedback+="\nMissing ChatBotPlatform Class java file.";
            }
            if(!ChatBotGenerator){
                feedback+="\nMissing ChatBotGenerator Class java file.";
            }
            if(!ChatBotSimulation){
                feedback+="\nMissing ChatBotSimulation Class java file.";
            }
            
            PdfGenerator createPDF = new PdfGenerator();
            createPDF.createPDF(sourceFolder +"\\" + file.getName()+"\\" + file.getName()+".pdf", feedback);

        }
    }
}
