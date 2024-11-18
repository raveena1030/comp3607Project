package comp3607_project;

//lock

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;


import comp3607_project.submissions.Akash_Sagar_816025035.ChatBot;


//import comp3607_project.submissions.Akash_Sagar_816025035.ChatBot;

//import org.junit.jupiter.api.BeforeEach;

public class ChatBotJunitTest { 

    ChatBot chat = new ChatBot();
    ChatBot defaultBot = new ChatBot();
    ChatBot specificBot = new ChatBot(1);
    boolean updaterBool;
    //@BeforeEach
    //void setUp() {
        // defaultBot = new ChatBot(); // Default constructor
        // specificBot = new ChatBot(1); // Overloaded constructor
    //}
         
   
    
    // chatBotName default
  
    @Test
    public void testChatBotName() {
        String expectedName = "ChatGPT-3.5";
        
        
        ChatBot bot = new ChatBot(0); // Assuming this constructor sets the name to ChatGPT-3.5
    
        // boolean isEqual = expectedName.equals(bot.getChatBotName());
        // if (isEqual) {
        //     updaterBool =true;
        // } else {
        //     updaterBool= false;
        // }
     assertEquals(expectedName, bot.getChatBotName());
     assertEquals( "LLaMa", specificBot.getChatBotName());

    }     


    // this is a null test dw
    /* 
    @Test
    public void testGetChatBotName() {
        ChatBot bot = new ChatBot(0); // Creates a ChatGPT-3.5 bot
        String expectedName = "ChatGPT-3.5";

        // Custom comparison logic
        if (!expectedName.equals(bot.getChatBotName())) {
            System.out.println("Test failed: Expected <" + expectedName + "> but got <" + bot.getChatBotName() + ">");
            fail("ChatBot name mismatch");
        
        } else {
            System.out.println("Test passed!");
        }
    }
*/


// numResponsesGenerated
    @Test
    public void testNumResponsesGeneratedInitial() {
        assertEquals(0, chat.getNumResponsesGenerated());
    
    }

    // messageLimit
    @Test
    public void testLimitReachedInitial() {
        assertFalse(ChatBot.limitReached());
    }


    @Test
    public void testGetTotalNumResponsesGenerated() {
        // Static method that returns the total number of messages generated
        int initialTotal = ChatBot.getTotalNumResponsesGenerated();

        defaultBot.prompt("Message 1");
        specificBot.prompt("Message 2");
        assertEquals(initialTotal + 2, ChatBot.getTotalNumResponsesGenerated());
    
    }

//messsage Remaining
    @Test
    public void testGetTotalNumMessagesRemaining() {
        // Tests calculation of messages remaining
        int initialRemaining = ChatBot.getTotalNumMessagesRemaining();

        defaultBot.prompt("Message 1");
        assertEquals(initialRemaining - 1, ChatBot.getTotalNumMessagesRemaining());
    
    }

//
    @Test
    public void testGenerateResponseAndUpdateCounters() {
        ChatBot chat2 = new ChatBot();

        for (int i = 0; i < 10; i++) {
            assertNotNull(chat2.generateResponse());
            assertEquals(i + 1, chat2.getNumResponsesGenerated());
            assertEquals(i + 1, ChatBot.getTotalNumResponsesGenerated());
        }
        assertTrue(ChatBot.limitReached());
    }

//tes limit reached
    @Test
    public void testLimitReached() {
        // Static method to check if the total limit is reached
        while (ChatBot.getTotalNumMessagesRemaining() > 0) {
            defaultBot.prompt("Keep going...");
        }
        assertTrue(ChatBot.limitReached());
    }
    


    @Test
    public void testPromptUnderLimit() {
        String response = chat.prompt("Hello!");
        assertTrue(response.contains("ChatGPT-3.5"));
    }


    @Test
    public void testPromptLimitReached() {
        for (int i = 0; i < 10; i++) {
            chat.prompt("Hello!");
        }
        String response = chat.prompt("Hello again!");
        //assertEquals("Daily Limit Reached. Wait 24 hours to resume chatbot usage", response);
        
        //String response = defaultBot.prompt("What's the weather?");    
    // searching for certain words in a string
        assertTrue(response.contains("Daily"),response);
        assertTrue(response.contains("24"), response);
        assertTrue(response.contains("chatbot"), response);
        assertTrue(response.contains("usage"), response);
    }


    @Test
    public void testToString() {
        String toStringResult = chat.toString();
        assertTrue(toStringResult.contains("ChatGPT-3.5"));
    
    }








}

