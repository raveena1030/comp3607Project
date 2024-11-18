package comp3607_project;

import java.lang.reflect.*;

public class ChatBotGeneratorTester {
    private int score=0;
    private String feedback="";

    public String testGenerateChatBotLLM(Class<?> classInstance){

        try{
            Method generateChatBotLLM = classInstance.getDeclaredMethod("generateChatBotLLM", int.class);
            if(generateChatBotLLM.getReturnType().equals(String.class)){
                score+=7;
                feedback+="\ngenerateChatBotLLM passed score:7/7\ngenerateChatBotLLM returned the appropriate data type and modifier.";
            }else
                feedback+="\ngenerateChatBotLLM failed score:0/7\ngenerateChatBotLLM should be of type 'String', not " + generateChatBotLLM.getReturnType()+ " and should be a class method";
        }catch(NoSuchMethodException e){
            System.err.println("No Such Method Error");
            e.printStackTrace();
        }


        return  "\nCHATBOTGENERATOR CLASS\nscore:"+score+ "/7\n"+feedback;  
    }
}