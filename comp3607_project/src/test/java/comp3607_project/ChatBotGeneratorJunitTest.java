package comp3607_project;

//lock
import org.junit.jupiter.api.Test;

/////import comp3607_project.submissions.Isaiah_Hedley_816034024.ChatBotGenerator;
import comp3607_project.submissions.Akash_Sagar_816025035.ChatBotGenerator;

import static org.junit.jupiter.api.Assertions.*;



public class ChatBotGeneratorJunitTest  {

    @Test
    public void testGenerateChatBotLLM_LLaMa() {
        ChatBotGenerator generator = new ChatBotGenerator();
        String result = generator.generateChatBotLLM(1);
        assertEquals("LLaMA", result, "The LLM name should be LLaMa when code 1 is passed");
    }

    @Test
    public void testGenerateChatBotLLM_Mistral7B() {
        ChatBotGenerator generator = new ChatBotGenerator();
        String result = generator.generateChatBotLLM(2);
        assertEquals("Mistral7B", result, "The LLM name should be Mistral7B when code 2 is passed");
    }

    @Test
    public void testGenerateChatBotLLM_Bard() {
        ChatBotGenerator generator = new ChatBotGenerator();
        String result = generator.generateChatBotLLM(3);
        assertEquals("Bard", result, "The LLM name should be Bard when code 3 is passed");
    }

    @Test
    public void testGenerateChatBotLLM_Claude() {
        ChatBotGenerator generator = new ChatBotGenerator();
        String result = generator.generateChatBotLLM(4);
        assertEquals("Claude", result, "The LLM name should be Claude when code 4 is passed");
    }

    @Test
    public void testGenerateChatBotLLM_Solar() {
        ChatBotGenerator generator = new ChatBotGenerator();
        String result = generator.generateChatBotLLM(5);
        assertEquals("Solar", result, "The LLM name should be Solar when code 5 is passed");
    }

    @Test
    public void testGenerateChatBotLLM_Default() {
        ChatBotGenerator generator = new ChatBotGenerator();
        String result = generator.generateChatBotLLM(999); // any number other than 1-5
        assertEquals("ChatGPT-3.5", result, "The default LLM name should be ChatGPT-3.5 for unrecognized codes");
    }


}


