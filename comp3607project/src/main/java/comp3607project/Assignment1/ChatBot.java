package comp3607project.Assignment1;

//Isaiah Hedley 816034024

public class ChatBot{
    
    private String chatBotName;
    private int numResponsesGenerated =0;
    private static int messageLimit =10;
    private static int messageNumber =0;
    
    public ChatBot(){
        this.chatBotName= ChatBotGenerator.generateChatBotLLM(0);
    }
    
    public ChatBot(int LLMCode){
        this.chatBotName= ChatBotGenerator.generateChatBotLLM(LLMCode);
    }
    
    public String getChatBotName(){
        return this.chatBotName;
    }
    
    public int getNumResponsesGenerated(){
        return this.numResponsesGenerated;
    }
    
    public static int getTotalResponsesGenerated(){
        return messageNumber;
    }
    
    public static int getTotalNumMessagesRemaining(){
        return messageLimit-messageNumber;
    }
    
    public static boolean limitReached(){
        return messageNumber>=messageLimit;
    }
    
    private String generateResponse(){
        this.numResponsesGenerated++;
        return "(Message# "+ (++messageNumber) + ") Response from " + this.getChatBotName() + "\t>>generatedTextHere";
    }
    
    public String prompt(String requestMessage){
        if(limitReached())
            return "Daily Limit Reached. Wait 24 hours to resume chatbot usage";
        return this.generateResponse();
    }
    
    public String toString(){
        return "ChatBot Name: " + this.getChatBotName() + "\tNumber Messages Used: " + this.getNumResponsesGenerated();
    }
}