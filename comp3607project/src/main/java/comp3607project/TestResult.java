package comp3607project;

public class TestResult {
    String testName;
    boolean passed;
    String feedback;
    int score;

    public TestResult(String testName, boolean passed, String feedback, int score){
        this.testName= testName;
        this.passed= passed;
        this.feedback = feedback;
        this.score= score;
    }
}
