package comp3607project.Assignment1;

//Isaiah Hedley 816034024

import java.util.Random;

public class ChatBotSimulation{
    public static void main(String[] args){
        System.out.println("Hello World!");
        ChatBotPlatform chatBotPlatform = new ChatBotPlatform();
        
        for(int i=0;i<7;i++)
            chatBotPlatform.addChatBot(i);
        
        System.out.println(chatBotPlatform.getChatBotList()); 
        
        Random random = new Random();
        
        for(int i=0;i<15;i++)
            System.out.println(chatBotPlatform.interactWithBot(random.nextInt(8),"Hey"));
            
        System.out.println(chatBotPlatform.getChatBotList()); 
        
        
    }
}