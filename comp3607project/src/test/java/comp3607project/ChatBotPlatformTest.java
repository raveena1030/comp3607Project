package comp3607project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comp3607project.Assignment1.ChatBotPlatform;

import static org.junit.jupiter.api.Assertions.*;

public class ChatBotPlatformTest {
    
    private ChatBotPlatform chatBotPlatform;
    private int score=0;
    private String feedback="";

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
        score += 2;
        feedback += "\ntestConstructorAndInitialization passed scored 2/2.";
    } catch (AssertionError e) {
        feedback += "\ntestConstructorAndInitialization failed scored 0/2: " + e.getMessage();
    }
}

@Test
public void testAddChatBotSuccess() {
    try {
        assertTrue(chatBotPlatform.addChatBot(1), "ChatBot with LLMCode 1 should be added successfully.");
        assertTrue(chatBotPlatform.addChatBot(2), "ChatBot with LLMCode 2 should be added successfully.");
        String chatBotList = chatBotPlatform.getChatBotList();
        assertTrue(chatBotList.contains("LLaMa"), "ChatBot with LLMCode 1 should be listed.");
        assertTrue(chatBotList.contains("Mistral7B"), "ChatBot with LLMCode 2 should be listed.");
        score += 3;
        feedback += "\ntestAddChatBotSuccess passed scored 3/3. ";
    } catch (AssertionError e) {
        feedback += "\ntestAddChatBotSuccess failed scored 0/3: " + e.getMessage();
    }
}

@Test
public void testAddChatBotLimitReached() {
    try {
        for (int i = 0; i < 10; i++) {
            assertTrue(chatBotPlatform.addChatBot(i % 5), "ChatBot should be added successfully until limit is reached.");
        }
        assertFalse(chatBotPlatform.addChatBot(0), "Adding ChatBot should fail once the message limit is reached.");
        score += 2;
        feedback += "\ntestAddChatBotLimitReached passed scored 2/2.";
    } catch (AssertionError e) {
        feedback += "\ntestAddChatBotLimitReached failed scored 0/2: " + e.getMessage();
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
        score += 6;
        feedback += "\ntestGetChatBotList passed scored 6/6.";
    } catch (AssertionError e) {
        feedback += "\ntestGetChatBotList failed scored 0/6: " + e.getMessage();
    }
}

@Test
public void testInteractWithBotValidBotNumber() {
    try {
        chatBotPlatform.addChatBot(1); // LLaMa
        String response = chatBotPlatform.interactWithBot(0, "Hello");
        assertTrue(response.contains("Response from LLaMa"), "Response should contain 'Response from LLaMa'.");
        assertTrue(response.contains("Message#"), "Response should contain a message number.");
        score += 3;
        feedback += "\ntestInteractWithBotValidBotNumber passed scored 3/3.";
    } catch (AssertionError e) {
        feedback += "\ntestInteractWithBotValidBotNumber failed scored 0/3: " + e.getMessage();
    }
}

@Test
public void testInteractWithBotInvalidBotNumber() {
    try {
        chatBotPlatform.addChatBot(1); // LLaMa
        String response = chatBotPlatform.interactWithBot(5, "Hello");
        assertEquals("Incorrect Bot Number(5) Selected. Try again.", response, "Invalid bot index should return an error message.");
        score += 2;
        feedback += "\ntestInteractWithBotInvalidBotNumber passed scored 2/2.";
    } catch (AssertionError e) {
        feedback += "\ntestInteractWithBotInvalidBotNumber failed scored 2/2: " + e.getMessage();
    }
}


}
