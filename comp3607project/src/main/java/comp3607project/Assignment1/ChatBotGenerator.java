package comp3607project.Assignment1;

//Isaiah Hedley 816034024

public class ChatBotGenerator{
    public static String generateChatBotLLM(int LLMCodeNumber){
        if(LLMCodeNumber==1)
            return "LLaMa";
        if(LLMCodeNumber==2)
            return "Mistral7B";
        if(LLMCodeNumber==3)
            return "Bard";
        if(LLMCodeNumber==4)
            return "Claude";
        if(LLMCodeNumber==5)
            return "Solar";
        return "ChatGPT-3.5";
    }
}