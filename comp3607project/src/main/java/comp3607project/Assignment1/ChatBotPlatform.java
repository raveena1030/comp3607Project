package comp3607project.Assignment1;

//Isaiah Hedley 816034024

import java.util.ArrayList;

public class ChatBotPlatform{
    
    private ArrayList<ChatBot> bots;
    
    public ChatBotPlatform(){
         this.bots = new ArrayList<ChatBot>();
    }
    
    public boolean addChatBot(int LLMCode){
        if(ChatBot.limitReached())
            return false;
        ChatBot bot= new ChatBot(LLMCode);
        this.bots.add(bot);
        return true;
    }
    
    public String getChatBotList(){
        int counter=0;
        String list ="--------------------------------------------------------------------------------\n";
        
        for(ChatBot bot:this.bots)
            list+= ("Bot Number: " + (counter++) + " " + bot.toString() + "\n"); 
        
        list+= "Total Messages Used: " + ChatBot.getTotalResponsesGenerated() + "\nTotal Messages Remaining: " + ChatBot.getTotalNumMessagesRemaining();
        return list + "\n--------------------------------------------------------------------------------";
    }
    
    public String interactWithBot(int botNumber,String message){
        if(botNumber >= this.bots.size())
            return "Incorrect Bot Number(" + botNumber+ ") Selected. Try again.";
        
        return this.bots.get(botNumber).prompt(message);
    }
}