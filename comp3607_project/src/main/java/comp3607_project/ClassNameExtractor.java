package comp3607_project;

import java.io.File;
import java.util.ArrayList;

public class ClassNameExtractor {

    ArrayList<Class<?>> classInstances;

    public ArrayList<Class<?>> getClassInstance(File subFolder){

        ArrayList<Class<?>> classInstances = new ArrayList<>();

        File[] javaFiles = subFolder.listFiles();
        File parentFile= subFolder.getParentFile();
        String parentFolder = parentFile.getName();

        for(File javaFile: javaFiles){
            
            if(javaFile.isFile() && javaFile.getName().endsWith(".java")){

                try{
                    Class<?> c = Class.forName("comp3607_project."+ parentFolder+"." + subFolder.getName()+"." +javaFile.getName().replace(".java", ""));
                    classInstances.add(c);

                }catch(ClassNotFoundException e){
                    System.err.println("Error class not found");
                    e.setStackTrace(null);
                }
            }
        }
        
        return classInstances;
            

    }

}
