package comp3607_project;

public class App 
{
    public static void main( String[] args )
    {

        FileHandler fileHandler = new FileHandler();
    
        
        fileHandler.extractFiles("submissions");

        TestSuite testSuite = new TestSuite();
        testSuite.runTests("submissions");
        
    }
}
