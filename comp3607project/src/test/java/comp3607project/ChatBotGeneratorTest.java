package comp3607project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import comp3607project.Assignment1.ChatBotGenerator;


public class ChatBotGeneratorTest {
    
    private int score = 0;
    private String feedback = "";

    @Test
    public void testGenerateChatBotLLM() {
        try{
            assertEquals("LLaMa", ChatBotGenerator.generateChatBotLLM(1), "LLM Code 1 should generate 'LLaMa'.");
            assertEquals("Mistral7B", ChatBotGenerator.generateChatBotLLM(2), "LLM Code 2 should generate 'Mistral7B'.");
            assertEquals("Bard", ChatBotGenerator.generateChatBotLLM(3), "LLM Code 3 should generate 'Bard'.");
            assertEquals("Claude", ChatBotGenerator.generateChatBotLLM(4), "LLM Code 4 should generate 'Claude'.");
            assertEquals("Solar", ChatBotGenerator.generateChatBotLLM(5), "LLM Code 5 should generate 'Solar'.");
            assertEquals("ChatGPT-3.5", ChatBotGenerator.generateChatBotLLM(99), "Unknown code should default to 'ChatGPT-3.5'.");
    
            score += 7;
            feedback += "\ntestGenerateChatBotLLM passed scored 7/7.";
        }catch (AssertionError e){
            feedback += "\ntestGenerateChatBotLLM failed scored 0/7. " +e.getMessage();
        }
        
    }
    
}
