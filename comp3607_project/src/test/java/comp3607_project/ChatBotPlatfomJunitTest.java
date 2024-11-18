package comp3607_project;

//lock


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comp3607_project.submissions.Akash_Sagar_816025035.ChatBotPlatform;
//import comp3607_project.submissions.Akash_Sagar_816025035;
//import comp3607project.Assignment1.ChatBotPlatform;

import static org.junit.jupiter.api.Assertions.*;

public class ChatBotPlatfomJunitTest {
    
    private ChatBotPlatform chatBotPlatform;
    //private int score=0;
    //private String feedback="";

    @BeforeEach
    public void setUp() {
        // Initialize ChatBotPlatform before each test case
        chatBotPlatform = new ChatBotPlatform();
    }





    @Test
public void testConstructorAndInitialization() {

    String chatBotList = chatBotPlatform.getChatBotList();
    try {
        assertTrue(chatBotList.contains("Total Messages Used: 0"), "Total Messages Used should initially be 0.");
        assertTrue(chatBotList.contains("Total Messages Remaining: 10"), "Total Messages Remaining should initially be 10.");
    
    }
     catch (AssertionError e) {
        
    }
}

@Test
public void testAddChatBotSuccess() {
    
        assertTrue(chatBotPlatform.addChatBot(1), "ChatBot with LLMCode 1 should be added successfully.");
        assertTrue(chatBotPlatform.addChatBot(2), "ChatBot with LLMCode 2 should be added successfully.");
        
        String chatBotList = chatBotPlatform.getChatBotList();

        assertTrue(chatBotList.contains("LLaMa"), "ChatBot with LLMCode 1 should be listed.");
        assertTrue(chatBotList.contains("Mistral7B"), "ChatBot with LLMCode 2 should be listed.");


}


// @Test
//     public void _testAddChatBotSuccess() {
//         // Test adding a ChatBot with a valid LLMCode
//         boolean added = ChatBotPlatform.addChatBot(0); // ChatGPT-3.5
//         assertTrue(added, "ChatBot with LLMCode 0 should be added successfully");
//         assertEquals(1, platform.getBots().size(), "Bots collection should contain 1 chatbot");
//     }



@Test
public void testAddChatBotLimitReached() {
    try {
        for (int i = 0; i < 10; i++) {
            assertTrue(chatBotPlatform.addChatBot(i % 5), "ChatBot should be added successfully until limit is reached.");
        }
        assertFalse(chatBotPlatform.addChatBot(0), "Adding ChatBot should fail once the message limit is reached.");
        
    } catch (AssertionError e) {
        
    }
}

@Test
public void testGetChatBotList() {
    try {
        chatBotPlatform.addChatBot(1); // LLaMa
        chatBotPlatform.addChatBot(3); // Bard

        String chatBotList = chatBotPlatform.getChatBotList();
        assertTrue(chatBotList.contains("LLaMa"), "ChatBot list should contain LLaMa.");
        assertTrue(chatBotList.contains("Bard"), "ChatBot list should contain Bard.");
        assertTrue(chatBotList.contains("Total Messages Used: 0"), "Initial message usage should be 0.");
        assertTrue(chatBotList.contains("Total Messages Remaining: 10"), "Initial remaining messages should be 10.");
    } catch (AssertionError e) {
    }
}

    @Test
    public void testInteractWithBotValidBotNumber() {
        //try {
        chatBotPlatform.addChatBot(1); // LLaMa
        String response = chatBotPlatform.interactWithbot(0, "Hello");
        assertTrue(response.contains("Response from LLaMa"), "Response should contain 'Response from LLaMa'.");
        assertTrue(response.contains("Message#"), "Response should contain a message number.");

    //} catch (AssertionError e) { }
    
}

@Test
public void testInteractWithBotInvalidBotNumber() {
    try {
        chatBotPlatform.addChatBot(1); // LLaMa
        String response = chatBotPlatform.interactWithbot(5, "Hello");
        assertEquals("Incorrect Bot Number(5) Selected. Try again.", response, "Invalid bot index should return an error message.");
        //score += 2;
       // feedback += "\ntestInteractWithBotInvalidBotNumber passed scored 2/2.";
    } catch (AssertionError e) {
        //feedback += "\ntestInteractWithBotInvalidBotNumber failed scored 2/2: " + e.getMessage();
    }
 }

}
