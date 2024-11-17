package comp3607project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import comp3607project.Assignment1.ChatBot;

public class ChatBotTest { 

    private int score=0;
    private String feedback="";

    ChatBot chat = new ChatBot();
   
@Test
public void testChatBotName() {
    String expectedName = "ChatGPT-3.5";
    String actualName = chat.getChatBotName();
    
    try {
        assertEquals(expectedName, actualName);
        score += 1;
        feedback += "\n chatBotName test passed scored: 1/1";
    } catch (AssertionError e) {
        feedback += "\n chatBotName test failed scored: 0/1. Expected: " + expectedName + ", but got: " + actualName;
    }
}

@Test
public void testMessageLimit() {
    try {
        assertEquals(10, ChatBot.getTotalNumMessagesRemaining());
        score += 3;
        feedback += "\ntest NumResponsesGenerated passed scored:3/3";
    } catch (AssertionError e) {
        feedback += "\ntest NumResponsesGenerated failed scored:0/3. Expected: 10, but got: " + chat.getNumResponsesGenerated();
    }
}

@Test
public void defaultChatBotNameTest() {
    String expectedName = "ChatGPT-3.5";
    String actualName = chat.getChatBotName();
    
    try {
        assertEquals(expectedName, actualName);
        score += 3;
        feedback += "\ndefaultChatBotNameTest passed scored:3/3";
    } catch (AssertionError e) {
        feedback += "\ndefaultChatBotNameTest failed scored:0/3. Expected: " + expectedName + ", but got: " + actualName;
    }
}

@Test
public void testChatBotNameCustomLLM() {
    var chatBot = new ChatBot(1); // LLM code 1 corresponds to LLaMa
    try {
        assertEquals("LLaMa", chatBot.getChatBotName());
        score += 3;
        feedback += "\ntest ChatBotNameCustomLLM passed scored:3/3";
    } catch (AssertionError e) {
        feedback += "\ntest ChatBotNameCustomLLM failed scored:0/3. Expected: LLaMa, but got: " + chatBot.getChatBotName();
    }
}


@Test
public void testNumResponsesGeneratedInitial() {
    try {
        assertEquals(0, chat.getNumResponsesGenerated());
        score += 1;
        feedback += "\ntest NumResponsesGenerated passed scored:2/2";
    } catch (AssertionError e) {
        feedback += "\ntest NumResponsesGenerated failed scored:1/2. Expected: 0, but got: " + chat.getNumResponsesGenerated();
    }
}

@Test
public void testGetTotalNumResponsesGenerated() {
    // Static method that returns the total number of messages generated
    int initialTotal = ChatBot.getTotalResponsesGenerated();

    chat.prompt("Message 1");
    chat.prompt("Message 2");
    
    try{
        assertEquals(initialTotal + 2, ChatBot.getTotalResponsesGenerated());
        score += 2;
        feedback += "\ntest GetTotalNumResponsesGenerated  passed scored:4/4";
    } catch (AssertionError e) {
        feedback += "\ntest GetTotalNumResponsesGenerated failed scored:2/4. Expected: 2, but got: " + chat.getNumResponsesGenerated();
    }
}

@Test
    public void testGetTotalNumMessagesRemaining() {
        // Tests calculation of messages remaining
        int initialRemaining = ChatBot.getTotalNumMessagesRemaining();

        chat.prompt("Message 1");
        try{
            assertEquals(initialRemaining - 1, ChatBot.getTotalNumMessagesRemaining());
            score+=3;
            feedback+="\n test GetTotalNumMessagesRemaining passed scored 3/3";
        }catch (AssertionError e){
            feedback+="\n test GetTotalNumMessagesRemaining failed scored 0/3. Expected 9, got: " + ChatBot.getTotalNumMessagesRemaining();
        }
    }

@Test
public void testLimitReachedInitial() {
    try {
        assertFalse(ChatBot.limitReached());
        score += 3;
        feedback += "\ntestLimitReachedInitial passed scored 3/3";
    } catch (AssertionError e) {
        feedback += "\ntestLimitReachedInitial failed scored 0/3. Limit should not be reached initially.";
    }
}

@Test
public void testPromptUnderLimit() {
    String response = chat.prompt("Hello!");
    try {
        assertTrue(response.contains("ChatGPT-3.5"));
        score += 2;
        feedback += "\ntestPromptUnderLimit passed scored 2/2";
    } catch (AssertionError e) {
        feedback += "\ntestPromptUnderLimit failed scored 0/2. Expected response to contain 'ChatGPT-3.5', but got: " + response;
    }
}

@Test
public void testPromptLimitReached() {
    try {
        for (int i = 0; i < 10; i++) {
            chat.prompt("Hello!");
        }
        String response = chat.prompt("Hello again!");
        assertEquals("Daily Limit Reached. Wait 24 hours to resume chatbot usage", response);
        score += 2;
        feedback += "\ntestPromptLimitReached passed scored 2/2";
    } catch (AssertionError e) {
        feedback += "\ntestPromptLimitReached failed scored 0/2. Limit message not returned as expected.";
    }
}

    @Test
    public void testToString() {

        String toStringResult = chat.toString();
       
        try{
            assertTrue(toStringResult.contains("ChatGPT-3.5"));
            score+=4;
            feedback+= "\ntoString() Test case passed scored 4/4";
        }catch(AssertionError e){
            feedback+= "\ntoString() Test case did not pass scored 0/4. String should contain 'ChatGPT-3.5'";
        }

    }


    public int getScore(){
        return score;
    }

    public String getFeedback(){
        return feedback;
    }

}