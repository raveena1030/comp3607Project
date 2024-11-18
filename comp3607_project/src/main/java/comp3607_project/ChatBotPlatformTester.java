package comp3607_project;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;

public class ChatBotPlatformTester {

    private int score=0;
    private String feedback="";

    public String runner(Class<?>classInstance){
        testBots(classInstance);
        testChatBotPlatformConstructor(classInstance);
        testAddChatBot(classInstance);
        testGetChatBotList(classInstance);
        testInteractWithBot(classInstance);

        return  "\nCHATBOTPLATFORM CLASS\nscore:"+score+ "/20\n"+feedback; 
    }

    public void testBots(Class<?> classInstance){
        try{
            Field bots = classInstance.getDeclaredField("bots");
            if(bots.getType().equals(ArrayList.class)){
                score+=2;
                feedback+="\ntestBots passed score:2/2\ntestBots has the appropriate data type.";
            }else
                feedback+="\ntestBots failed score:0/2\ntestBots should be an ArrayList, not " + bots.getType()+"\n";
            
            feedback+="\n";
        }catch(NoSuchFieldException e){
            System.err.println("No Such Field Error");
            e.printStackTrace();
        }  
    }

    public void testChatBotPlatformConstructor(Class<?> classInstance){
        try{
            
            Field arrayListInstance= classInstance.getDeclaredField("bots");
            arrayListInstance.setAccessible(true);
            Object instance = classInstance.getConstructor().newInstance();
            Object fieldValue = arrayListInstance.get(instance); 
            if (fieldValue instanceof Collection) {
                score+=2; 
                feedback+="\ntestChatBotPlatformConstructor test passed score:2/2\ntestChatBotPlatformConstructor initializes the arrayList";
            } 
            else 
                feedback+="\ntestChatBotPlatformConstructor test failed score:0/2\ntestChatBotPlatformConstructor did not initialize the arrayList";
        }catch(NoSuchFieldException e){
            e.setStackTrace(null);
        } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
    }


    public void testAddChatBot(Class<?> classInstance) {
        try{
            Method addChatBot = classInstance.getDeclaredMethod("addChatBot", int.class);
            //System.out.println(addChatBot);
            if(addChatBot.getReturnType().equals(boolean.class)) {
                score++;
                feedback+="\naddChatBot returned the appropriate data type. Score: 1/1\n";
            }
            else
                feedback+="\naddChatBot failed to return the approperiate data type. Score:0/1\n";

            //Method limitReached = classInstance.getDeclaredMethod("limitReached");
            if(addChatBot.toString().contains("limitReached")) {
                score++;
                feedback+="\naddChatBot checks to see if the chatBot has reached its limit of messages. Score: 1/1\n";
            }
            else
                feedback+="\baddChatBot failed to check if the chatBot has reached its limit of messages. Score: 0/1\n";
            
            Field bots = classInstance.getDeclaredField("bots");
            if(bots.getType().equals(ArrayList.class) && bots!=null) {
                score++;
                feedback+="\naddChatBot utilized the bots arrayList. Score: 1/1\n";
            }
            else
                feedback+="\naddChatBot failed to utilize the bots arrayList. Score: 0/1\n";
              
            if(addChatBot.toString().contains("new chatBot")) {
                score++;
                feedback+="\naddChatBot successfully created a new chatBot. Score 1/1\n";
            }
            else
                feedback+="\naddChatBot failed to create a new chatBot. Score 0/1\n";

            if(addChatBot.toString().contains("add")) {
                score++;
                feedback+="\naddChatBot successfully added the newly created chatBot to the arrayList of chatBots. Score: 1/1\n";
            }
            else
                feedback+="\baddChatBot failed to add the newly created chatBot to the arrayList of chatBots. Score: 1/1\n";
        }
        catch(NoSuchMethodException e) {
            System.err.println("No such Method Error");
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace();
        } 
    }

    public void testGetChatBotList(Class<?> classInstance) {
        try {
            Method getChatBotList = classInstance.getDeclaredMethod("getChatBotList");
            score++;
            feedback+="\ngetChatBotList Method was used in the application. Score: 1/1\n";

            if(getChatBotList.getReturnType().equals(String.class)) {
                score++;
                feedback+="\ngetChatBotList returns the appropriate return type of " + getChatBotList.getReturnType() + ". Score: 1/1\n";
            }
            else 
                feedback+="\ngetChatBotList failed to return the appropriate return type of String, instead it returns type " + getChatBotList.getReturnType() + ". Score: 0/1\n";
            
            Field bots = classInstance.getDeclaredField("bots");
            if(bots.getType().equals(ArrayList.class) && bots!=null) {
                score++;
                feedback+="\ngetChatBotList utilized the bots arrayList. Score: 1/1\n";
            }
            else
                feedback+="\ngetChatBotList failed to utilize the bots arrayList. Score: 0/1\n";

            if (getChatBotList.toString().contains("toString")) {
                score++;
                feedback+="\ngetChatBotList utilized the toString() method. Score:1/1\n";
            } 
            else 
                feedback+="\ngetChaBotList failed to utilize the toString() method. Score: 0/1\n";
            
            if(getChatBotList.toString().contains("ChatBot.getTotalResponsesGenerated()")) {
                score++;
                feedback+="\ngetChatBotList shows the number of messages the chatBot used. Score: 1/1\n";
            }
            else
                feedback+="\ngetChatBotList failed to show the number of messages the chatBot used. Score: 0/1\n";
            
            if(getChatBotList.toString().contains("ChatBot.getTotalNumMessagesRemaining()")) {
                score++;
                feedback+="\ngetChatBotList shows the number of messages the chatBot has remaining. Score: 1/1\n";
            }
            else
                feedback+="\ngetChatBotList failed to show the number of messages the chatBot has remaining. Score: 0/1\n";
        }
        catch(NoSuchMethodException e) {
            System.err.println("No such Method Error");
            e.printStackTrace();
        }catch(NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace();
        }
    }

    public void testInteractWithBot(Class<?> classInstance) {
        try {
            Method interactWithBot = classInstance.getDeclaredMethod("interactWithBot", int.class, String.class);

            if (interactWithBot.getReturnType().equals(String.class)) {
                score++;
                feedback+="\ninteractWtihBoth returned the appropriate data type of String. Score: 1/1\n";
            } 
            else
                feedback+="\ninteractWithBot failed to return the appropriate data type of String. Instead, it returned of type " + interactWithBot.getReturnType() +". Score: 0/1\n";
            
            Field bots = classInstance.getDeclaredField("bots");
            if(bots.getType().equals(ArrayList.class) && bots!=null) {
                score++;
                feedback+="\ninteractWithBot utilized the bots arrayList. Score: 1/1\n";
            }
            else
                feedback+="\ninteractWithBot failed to utilize the bots arrayList. Score: 0/1\n";
            
            if (interactWithBot.toString().contains("botNumber >=")) {
                score++;
                feedback+="\ninteractWithBot checked for invalid bot numbers entered as parameters. Score: 1/1\n";
            } 
            else
                feedback+="\ninteractWithbot failed to check for invalid bot numbers entered in parameters. Score: 0/1\n";

            if(interactWithBot.toString().contains("prompt")) {
                score+=2;
                feedback+="\ninteractWithBot utilized the 'prompt' method for chatBot. Score: 2/2";
            }
            else
                feedback+="\ninteractWithBot failed to utilzie the 'prompt' method for chatBot. Score: 0/2";
        }
        catch(NoSuchMethodException e) {
            System.err.println("No such Method Error");
            e.printStackTrace();
        }catch(NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace();
        }
    }
}
