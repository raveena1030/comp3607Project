package comp3607_project;

import java.lang.reflect.*;


public class ChatBotTester {
    
    public int score=0;
    public String feedback="";

    public String printer(Class<?> classInstance){
        testChatBotName(classInstance);
        testNumResponsesGenerated(classInstance);
        testMessageLimit(classInstance);
        testMessageNumber(classInstance);
        testDefaultChatBotConstructor(classInstance);
        testchatBotConstructor(classInstance);
        testGetChatBotName(classInstance);
        testGetNumResponsesGenerated(classInstance);
        testGetTotalNumResponsesGenerated(classInstance);
        testGetTotalNumMessagesRemaining(classInstance);
        testLimitReached(classInstance);
        testGenerateResponse(classInstance);
        testPromptMethod(classInstance);
        testToStringMethod(classInstance);
        //System.out.println("score:"+score+"/36");
        //System.out.println(feedback);

        return  "CHATBOT CLASS\nscore:"+score+ "/36\n"+feedback; 
    }

    public void testChatBotName(Class<?> classInstance){

        try{
            Field chatBotField= classInstance.getDeclaredField("chatBotName");
            if(chatBotField.getType().equals(String.class)){
                score++;
                feedback+="\ntestChatBotName passed score:1/1\nchatBotName has the appropriate data type.";
            }else
                feedback+="\ntestChatBotName failed score:0/1\nchatBotName should be of type 'String', not " + chatBotField.getType()+"\n";
            
            feedback+="\n";
        }catch(NoSuchFieldException e){
            System.err.println("No Such Field Error");
            e.printStackTrace();
        }
        
    }

    public void testNumResponsesGenerated(Class<?> classInstance){

        try{
            Field numResponsesGeneratedField= classInstance.getDeclaredField("numResponsesGenerated");
            if(numResponsesGeneratedField.getType().equals(int.class)){
                score++;
                feedback+="\ntestNumResponsesGenerated passed score:1/1\nnumResponsesGenerated has the appropriate data type.";
            }else
                feedback+="\ntestNumResponsesGenerated failed score:0/1\nnumResponsesGenerated should be of type 'int', not " + numResponsesGeneratedField.getType();
            
            feedback+="\n";
        }catch(NoSuchFieldException e){
            feedback+="\ntestNumResponsesGenerated failed score:0/1\nnumResponsesGenerated does not exist in class";
            e.printStackTrace();
        }
        
    }

    public void testMessageLimit(Class<?> classInstance){

        try{
            Field messageLimitField= classInstance.getDeclaredField("messageLimit");
            
            if(messageLimitField.getType().equals(int.class)){
                score+=3;
                feedback+="\ntestMessageLimit passed score:3/3\nmessageLimit has the appropriate data type, accessor  and value";

            }else
            feedback+="\ntestMessageLimit failed score:0/3\nmessageLimit has the wrong data type, expected 'int' got: "+messageLimitField.getType();
        
            feedback+="\n";
        }catch(NoSuchFieldException e){
            System.err.println("No Such Field Error");
            e.printStackTrace();
        }
        
    }

    public void testMessageNumber(Class<?> classInstance){

        try{
            Field messageNumberField= classInstance.getDeclaredField("messageNumber");

            if(messageNumberField.getType().equals(int.class)){
                score+=2;
                feedback+="\ntestMessageNumberpassed score:2/2\nmessageNumber has the appropriate data type and value";

            }else
            feedback+="\ntestMessageNumber failed score:0/3\nmessageNumber has the wrong data type, expected 'int' got: "+messageNumberField.getType();
        
            feedback+="\n";
        }catch(NoSuchFieldException e){
            System.err.println("No Such Field Error");
            e.printStackTrace();
        }
        
    }

    public void testDefaultChatBotConstructor(Class<?> classInstance){
        try{
            Object instanceOject= classInstance.getConstructor().newInstance();
            Field chatBotNamField= classInstance.getDeclaredField("chatBotName");
            chatBotNamField.setAccessible(true);
            if(instanceOject.toString().contains("ChatGPT-3.5")){
                score+=3;
                feedback+="\nDefaultChatBotConstructor initialized a chatBot using the chatBotGenerator based on the inputted integer. Score: 3/3\n";
            }else
            feedback+="\nDefaultChatBotConstructor failed to initialize a chatBot using the chatBotGenreator based on the inputted integer. Score: 0/3\n";  
            
        }catch(NoSuchMethodException e) {
            System.err.println("No such Method Error");
            e.printStackTrace();
        }catch(NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace(); 
        }catch (InstantiationException e) {
            System.err.println("Instantiation Error");
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            System.err.println("llegal Access Error");
            e.printStackTrace();
        }catch (IllegalArgumentException e) {
            System.err.println("Illegal Argument Error");
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            System.err.println("Invocation Target Error");
            e.printStackTrace();
        }
    }

    public void testchatBotConstructor(Class<?> classInstance) {
        try{
            Object instanceOject= classInstance.getConstructor(int.class).newInstance(1);
            Field chatBotNamField= classInstance.getDeclaredField("chatBotName");
            chatBotNamField.setAccessible(true);

            if(instanceOject.toString().contains("LLaMa")){
                score+=3;
                feedback+="\nOverloaded chatBotConstructor initialized a chatBot using the chatBotGenerator based on the inputted integer. Score: 3/3\n";
            }else
            feedback+="\nOverloaded chatBotConstructor failed to initialize a chatBot using the chatBotGenreator based on the inputted integer. Score: 0/3\n";  
            
        }catch(NoSuchMethodException e) {
            System.err.println("No such Method Error");
            e.printStackTrace();
        }catch(NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace(); 
        }catch (InstantiationException e) {
            System.err.println("Instantiation Error");
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            System.err.println("llegal Access Error");
            e.printStackTrace();
        }catch (IllegalArgumentException e) {
            System.err.println("Illegal Argument Error");
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            System.err.println("Invocation Target Error");
            e.printStackTrace();
        }
    }

    public void testGetChatBotName(Class<?> classInstance) {
        try{
            Method getChatBotName = classInstance.getDeclaredMethod("getChatBotName");
            Constructor<?> defaultConstructor = classInstance.getConstructor();
            Object instance = defaultConstructor.newInstance();
            Field chatBotName = classInstance.getDeclaredField("chatBotName");
            chatBotName.setAccessible(true);
            if(getChatBotName.invoke(instance).equals(chatBotName.get(instance)) && getChatBotName.getReturnType().equals(String.class)) {
                score++;
                feedback+="\ngetChatBotName accessess the appropriate chatBotName. Score: 1/1\n";
            }
            else
                feedback+="\ngetChatBotName failed to access the appropriate chatBotName. Score:0/1\n";
        }
        catch(NoSuchMethodException e) {
            System.err.println("No such Method Error");
            e.printStackTrace();
        }catch(NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace();
        }catch (InstantiationException e) {
            System.err.println("Instantiation Error");
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            System.err.println("Illegal Access Error");
            e.printStackTrace();
        }catch (IllegalArgumentException e) {
            System.err.println("Illegal Argument Error");
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            System.err.println("Invocation Target Error");
            e.printStackTrace();
        }
    }

    public void testGetNumResponsesGenerated(Class<?> classInstance) {
        try{
            Method getNumResponsesGenerated = classInstance.getDeclaredMethod("getNumResponsesGenerated");
            Constructor<?> defaultConstructor = classInstance.getConstructor();
            Object instance = defaultConstructor.newInstance();
            Field numResponsesGenerated = classInstance.getDeclaredField("numResponsesGenerated");
            numResponsesGenerated.setAccessible(true);
            if(getNumResponsesGenerated.invoke(instance).equals(numResponsesGenerated.get(instance)) && getNumResponsesGenerated.getReturnType().equals(int.class)) {
                score++;
                feedback+="\ngetNumResponsesGenerated returns the accurate amount of responses generated. Score: 1/1\n";
            }
            else
                feedback+="\ngetNumResponsesGenerated failed to return the accurate amount of responses generated. Score: 0/1\\n";
        }
        catch(NoSuchMethodException e) {
            System.err.println("No such Method Error");
            e.printStackTrace();
        }catch(NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace();
        }catch (InstantiationException e) {
            System.err.println("Instantiation Error");
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            System.err.println("Illegal Access Error");
            e.printStackTrace();
        }catch (IllegalArgumentException e) {
            System.err.println("Illegal Argument Error");
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            System.err.println("Invocation Target Error");
            e.printStackTrace();
        }
    }

    public void testGetTotalNumResponsesGenerated(Class<?> classInstance) {
        try{
            Method getTotalNumResponsesGenerated = classInstance.getDeclaredMethod("getTotalNumResponsesGenerated");
            Constructor<?> defaultConstructor = classInstance.getConstructor();
            Object instance = defaultConstructor.newInstance();
            Field messageNumber = classInstance.getDeclaredField("messageNumber");
            messageNumber.setAccessible(true);
            if(getTotalNumResponsesGenerated.invoke(instance).equals(messageNumber.get(instance)) && getTotalNumResponsesGenerated.getReturnType().equals(int.class)) {
                score++;
                feedback+="\ngetNumResponsesGenerated returns the total number of responses generated by the ChatBot. Score: 1/1\n";
            }
            else
                feedback+="\ngetNumResponsesGenerated failed to return the total number of responses generated by the chatBot. Score: 0/1\\n";
            
            if(Modifier.isStatic(getTotalNumResponsesGenerated.getModifiers())) {
                score++;
                feedback+="\ngetNumResponsesGenerated is a class method. Score: 1/1\n";
            }
            else
                feedback+="\ngetNumResponsesGenertaed is not a class method. Score: 0/1\n";
            
        }
        catch(NoSuchMethodException e) {
            feedback+="\ntestGetTotalNumResponsesGenerated method not found in class, test failed score 0/2\n";
        }catch(NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace();
        }catch (InstantiationException e) {
            System.err.println("Instantiation Error");
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            System.err.println("Illegal Access Error");
            e.printStackTrace();
        }catch (IllegalArgumentException e) {
            System.err.println("Illegal Argument Error");
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            System.err.println("Invocation Target Error");
            e.printStackTrace();
        }
    }

    public void testGetTotalNumMessagesRemaining(Class<?> classInstance) {
        try{
            Method getTotalNumMessagesRemaining = classInstance.getDeclaredMethod("getTotalNumMessagesRemaining");
            Constructor<?> defaultConstructor = classInstance.getConstructor();
            Object instance = defaultConstructor.newInstance();
            Field messageNumber = classInstance.getDeclaredField("messageNumber");
            messageNumber.setAccessible(true);
            if(getTotalNumMessagesRemaining.invoke(instance).equals(10-(int)messageNumber.get(instance)) && getTotalNumMessagesRemaining.getReturnType().equals(int.class)) {
                score++;
                feedback+="\ngetNumResponsesGenerated returns the total number of responses generated by the ChatBot. Score: 1/1\n";
            }
            else
                feedback+="\ngetNumResponsesGenerated failed to return the total number of responses generated by the chatBot. Score: 0/1\n";
            
            if(Modifier.isStatic(getTotalNumMessagesRemaining.getModifiers())) {
                score++;
                feedback+="\ngetNumResponsesGenerated is a class method. Score: 1/1\n";
            }
            else
                feedback+="\ngetNumResponsesGenertaed is not a class method. Score: 0/1\n";
            
        }
        catch(NoSuchMethodException e) {
            System.err.println("No such Method Error");
            e.printStackTrace();
        }catch(NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace();
        }catch (InstantiationException e) {
            System.err.println("Instantiation Error");
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            System.err.println("Illegal Access Error");
            e.printStackTrace();
        }catch (IllegalArgumentException e) {
            System.err.println("Illegal Argument Error");
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            System.err.println("Invocation Target Error");
            e.printStackTrace();
        }
    }

    public void testPromptMethod(Class<?> classInstance) {

        try {
            // Check the `prompt` method exists
            Method promptMethod = classInstance.getDeclaredMethod("prompt", String.class);
            if (promptMethod.getReturnType().equals(String.class)) {
                score += 1;
                feedback += "\n'prompt' method exists with the correct signature. Test Passed. Score: 1/1";
            } else {
                feedback += "\n'prompt' method has incorrect return type. Test Failed. Score: 0/1";
            }
                feedback+='\n';
            // Access static fields to test behavior
            Field messageNumberField = classInstance.getDeclaredField("messageNumber");
            Field messageLimitField = classInstance.getDeclaredField("messageLimit");

            // Set fields accessible to manipulate static state
            messageNumberField.setAccessible(true);
            messageLimitField.setAccessible(true);

            // Create an instance of ChatBot
            Object chatBotInstance = classInstance.getDeclaredConstructor().newInstance();

            // Test Case 1: When limit is NOT reached
            messageNumberField.set(null, 0); // Reset message count
            messageLimitField.set(null, 10); // Set limit to 10
            String normalResponse = (String) promptMethod.invoke(chatBotInstance, "Hello");

            if (!normalResponse.toLowerCase().contains("daily limit reached")) {
                score += 2;
                feedback += "\n'prompt' method processes valid requests correctly. Test Passed. Score: 2/2";
            } else {
                feedback += "\n'prompt' method incorrectly returned limit message for valid request. Test Failed. Score: 0/2";
            }
            feedback+='\n';
            // Test Case 2: When limit IS reached
            messageNumberField.set(null, 10); // Set message count to limit
            String limitResponse = (String) promptMethod.invoke(chatBotInstance, "Hello");

            if (limitResponse.toLowerCase().contains("daily limit reached") &&
                limitResponse.toLowerCase().contains("wait 24 hours")) {
                score += 3;
                feedback += "\n'prompt' method correctly returns limit message. Test Passed. Score: 3/3";
            } else {
                feedback += "\n'prompt' method failed to return correct limit message. Test Failed. Score: 0/3";
            }
            feedback+='\n';
        } catch (NoSuchMethodException e) {
            feedback += "\nError: 'prompt' method not found. Test Failed. Score: 0/4";
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            feedback += "\nError: Static fields 'messageNumber' or 'messageLimit' not found. Test Failed. Score: 0/4";
            e.printStackTrace();
        } catch (Exception e) {
            feedback += "\nAn unexpected error occurred during testing: " + e.getMessage() + ". Test Failed. Score: 0/4";
            e.printStackTrace();
        }
    }

    public void testToStringMethod(Class<?> classInstance) {
        int maxScore = 4; // Maximum score for this test

        try {
            // Check if `toString` method exists
            Method toStringMethod = classInstance.getDeclaredMethod("toString");
            if (toStringMethod.getReturnType().equals(String.class)) {
                score += 1;
                feedback += "\n'toString' method exists with the correct signature. Test Passed. Score: 1/1\n";
            } else {
                feedback += "\n'toString' method has incorrect return type. Test Failed. Score: 0/1";
            }
            feedback+='\n';
            // Create an instance of ChatBot
            Object chatBotInstance = classInstance.getDeclaredConstructor().newInstance();

            // Invoke the `toString` method
            String toStringOutput = (String) toStringMethod.invoke(chatBotInstance);

            // Check the output format
            if (toStringOutput.contains("ChatBot Name:") && toStringOutput.contains("Number Messages Used:")) {
                score += 3;
                feedback += "\nCorrect format detected in 'toString' output. Test Passed. Score: 3/3";
            } else {
                feedback += "\nIncorrect format detected in 'toString' output. Test Failed. Score: 0/3";
            }
            feedback+='\n';
        } catch (NoSuchMethodException e) {
            feedback += "\nError: 'toString' method not found. Test Failed. Score: 0/" + maxScore;
            e.printStackTrace();
        } catch (Exception e) {
            feedback += "\nAn unexpected error occurred during testing: " + e.getMessage() + ". Test Failed. Score: 0/" + maxScore;
            e.printStackTrace();
        }
    }
    
    public void testGenerateResponse(Class<?> classInstance) {
        try{
            Method generateResponse = classInstance.getDeclaredMethod("generateResponse");
            Constructor<?> defaultConstructor = classInstance.getConstructor();
            Object instance = defaultConstructor.newInstance();
            Field numResponsesGeneratedField = classInstance.getDeclaredField("numResponsesGenerated");
            numResponsesGeneratedField.setAccessible(true);
            int numResponsesGenerated = (int)numResponsesGeneratedField.get(instance);
            Field chatBotNameField = classInstance.getDeclaredField("chatBotName");
            chatBotNameField.setAccessible(true);
            String chatBotName = (String)chatBotNameField.get(instance);
            
            if(Modifier.isPrivate(generateResponse.getModifiers())) {
                score++;
                feedback+="\ngenerateResponse is a private method. Score: 1/1\n";
            }
            else
                feedback+="\ngenerateResponse is not a private method. Score: 0/1\n";

            if(numResponsesGenerated==numResponsesGenerated++ && generateResponse.getReturnType().equals(String.class)) {
                score+=2;
                feedback+="\ngenerateResponse incraments the number of generated responses. Score: 2/2\n";
            }
            else
                feedback+="\ngenerateResponse failes to incrament the number of generated responses. Score: 0/2\\n";

            if(generateResponse.toString().contains("messagenumber") || generateResponse.toString().contains("message#")) {
                score++;
                feedback+="\ngenerateResponse prints a unique message number. Score: 1/1\n";
            }
            else
                feedback+="\ngenerateResponse failed to print a unique message number. Score: 0/1\n";

            if(generateResponse.toString().contains(chatBotName)) {
                score++;
                feedback+="\ngenerateResponse prints the appropriate respective chatBotName. Score: 1/1\n";
            }
            else
                feedback+="\ngenerateResponse failed to print the appropriate respective chatBotName. Score: 0/1\n";
        }
        catch(NoSuchMethodException e) {
            System.err.println("No such Method Error");
            e.printStackTrace();
        }catch(NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace();
        }catch (InstantiationException e) {
            System.err.println("Instantiation Error");
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            System.err.println("Illegal Access Error");
            e.printStackTrace();
        }catch (IllegalArgumentException e) {
            System.err.println("Illegal Argument Error");
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            System.err.println("Invocation Target Error");
            e.printStackTrace();
        }
    }

    public void testLimitReached(Class<?> classInstance) {
        try{
            Method limitReached = classInstance.getDeclaredMethod("limitReached");
            Constructor<?> defaultConstructor = classInstance.getConstructor();
            Object instance = defaultConstructor.newInstance();
            Field messageNumberField = classInstance.getDeclaredField("messageNumber");
            messageNumberField.setAccessible(true);
            int messageNumber = (int)messageNumberField.get(instance);
            int messageLimit = 10;
            
            if(messageNumber<=messageLimit && limitReached.getReturnType().equals(boolean.class)) {
                score+=2;
                feedback+="\nlimitReached returns true if the limit is reached and false otherwise. Score: 2/2\n";
            }
            else
                feedback+="\nlimitReached fails to return true if the limit is reached and false otherwise. Score: 0/2\n";
            
            if(Modifier.isStatic(limitReached.getModifiers())) {
                score++;
                feedback+="\nlimitReached is a class method. Score: 1/1\n";
            }
            else
                feedback+="\nlimitReached is not a class method. Score: 0/1\n";
        }
        catch(NoSuchMethodException e) {
            System.err.println("No such Method Error");
            e.printStackTrace();
        }catch(NoSuchFieldException e) {
            System.err.println("No such Field Error");
            e.printStackTrace();
        }catch (InstantiationException e) {
            System.err.println("Instantiation Error");
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            System.err.println("Illegal Access Error");
            e.printStackTrace();
        }catch (IllegalArgumentException e) {
            System.err.println("Illegal Argument Error");
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            System.err.println("Invocation Target Error");
            e.printStackTrace();
        }
    }

}
