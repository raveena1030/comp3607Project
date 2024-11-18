package comp3607_project;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class ChatBotSimulationTester {

    private int score = 0;
    private String feedback = "";

    public String testMain(Class<?> classInstance) {
        try {
            // Capture original System.out
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Get and invoke the main method
            Method mainMethod = classInstance.getDeclaredMethod("main", String[].class);
            mainMethod.invoke(null, (Object) new String[]{});

            // Restore original System.out
            System.setOut(originalOut);

            // Get the output
            String output = outputStream.toString();

            // 1. Check for "Hello World!" statement
            if (output.contains("Hello World!")) {
                score++;
                feedback += "\n'Hello World!' statement printed. Score: 1/1";
            } else {
                feedback += "\n'Hello World!' statement not printed. Score: 0/1";
            }

            // 2. Check for added chatbots
            int addChatBotCount = output.split("ChatBot\\[").length - 1;
            if (addChatBotCount == 7) {
                score += 2;
                feedback += "\nAdded 7 chatbots to chatBotPlatform. Score: 2/2";
            } else {
                feedback += "\nExpected 7 chatbots, but found " + addChatBotCount + ". Score: 0/2";
            }

            // 3. Check interactions with bots
            int interactionCount = output.split("Hey").length - 1;
            if (interactionCount == 15) {
                score += 4;
                feedback += "\nInteracted with bots 15 times. Score: 4/4";
            } else {
                feedback += "\nExpected 15 interactions, but found " + interactionCount + ". Score: 0/4";
            }

            // 4. Check final bot list printed
            if (output.contains("ChatBot[")) {
                score += 2;
                feedback += "\nFinal list of chatbots printed. Score: 2/2";
            } else {
                feedback += "\nFinal list of chatbots not printed. Score: 0/2";
            }

        } catch (Exception e) {
            feedback += "\nAn error occurred during testing: " + e.getMessage();
            e.printStackTrace();
        }

        return "\nCHATBOTSIMULATION CLASS\nScore: " + score + "/12\n" + feedback;
    }
}