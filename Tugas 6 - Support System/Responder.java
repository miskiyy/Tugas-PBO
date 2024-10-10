import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response based on user input.
 */
public class Responder {
    private HashMap<String, String> responseMap;
    private ArrayList<String> responses;
    private Random randomGenerator;

    public Responder() {
        responseMap = new HashMap<>();
        responses = new ArrayList<>();
        randomGenerator = new Random();
        fillResponseMap();
        fillResponses();
    }

    /**
     * Generate a response based on input.
     * @return A string that should be displayed as the response.
     */
    public String generateResponse(String input) {
        // Normalize the input
        String normalizedInput = input.toLowerCase();

        // Check for each keyword in the normalized input
        for (String keyword : responseMap.keySet()) {
            if (normalizedInput.contains(keyword)) {
                return responseMap.get(keyword); // Return response for the first matching keyword
            }
        }

        // If no keyword matches, generate a random response
        int index = randomGenerator.nextInt(responses.size());
        return responses.get(index);
    }

    /**
     * Fill the response map with predefined keywords and responses.
     */
    private void fillResponseMap() {
        responseMap.put("slow",
            "I think this has to do with your hardware. " +
            "Upgrading your processor should solve all performance problems. " +
            "Have you got a problem with our software?");
        
        responseMap.put("bug",
            "Well, you know, all software has some bugs. " +
            "But our software engineers are working very hard to fix them. " +
            "Can you describe the problem a bit further?");
        
        responseMap.put("expensive",
            "The cost of our product is quite competitive. " +
            "Have you looked around and really compared our features?");

        responseMap.put("crash",
            "Experiencing crashes can be frustrating. " +
            "Make sure your software is updated to the latest version.");
    
        responseMap.put("install",
            "If you're having trouble with installation, " +
            "please check if your system meets the requirements.");
        
        responseMap.put("error",
            "Error messages can be cryptic. " +
            "What does the error message say?");
        
        responseMap.put("freeze",
            "If your application is freezing, try restarting it. " +
            "Make sure you save your work frequently.");
        
        responseMap.put("update",
            "Keeping your software up-to-date is crucial. " +
            "Have you checked for updates recently?");
        
        responseMap.put("internet",
            "If you have internet issues, try resetting your router. " +
            "Is your Wi-Fi connection stable?");
        
        responseMap.put("support",
            "We're here to help you! " +
            "Can you provide more details about your issue?");
        
        responseMap.put("feature",
            "New features are regularly added based on user feedback. " +
            "What features would you like to see?");
        
        responseMap.put("compatibility",
            "Compatibility issues can arise with different systems. " +
            "Can you specify your operating system?");
        
        responseMap.put("backup",
            "It's always a good idea to backup your data regularly. " +
            "Have you set up any backup solutions?");
        
        responseMap.put("performance",
            "If your system is performing poorly, " +
            "consider closing unnecessary applications.");
        
        responseMap.put("slow internet",
            "A slow internet connection can be frustrating. " +
            "Is there a specific time when it happens?");
        
        responseMap.put("security",
            "Security is very important. " +
            "Make sure you have a reliable antivirus installed.");
        
        responseMap.put("data loss",
            "Data loss can be catastrophic. " +
            "Have you checked your recycle bin or backup?");
        
        responseMap.put("settings",
            "Sometimes settings can affect performance. " +
            "What settings have you changed recently?");
        
        responseMap.put("configuration",
            "Configuration problems can cause issues. " +
            "Have you double-checked your settings?");
        
        responseMap.put("login",
            "If you're having login issues, check your credentials. " +
            "Did you forget your password?");

        responseMap.put("laper",
            "Makan la bang jgn cet ak");
        
        responseMap.put("sedih", 
            "UHHHH DON'T BE SADDD I'M RIGHT HERE BABE");

        responseMap.put("salting", 
            "hayoyooo gapapa si it's cannon event HAHAHAHA GOOD LUCK");

        responseMap.put("banting",
            "jangan dung mang km beli sendiri tu ha?");    
        
        responseMap.put("nangis", 
            "nangis mulu hpnya gw umpetin mau?");
        
    }

    /**
     * Fill the list of random responses.
     */
    private void fillResponses() {
        responses.add("That sounds odd. Could you describe \n" +
                "that problem in more detail?");
        responses.add("No other customer has ever \n" +
                "complained about this before. \n" +
                "What is your system configuration?");
        responses.add("That’s a known problem with Vista." +
                "Windows 7 is much better.");
        responses.add("I need a bit more information on that.");
        responses.add("Have you checked that you do not \n" +
                "have a dll conflict?");
        responses.add("That is explained in the manual. \n" +
                "Have you read the manual?");
        responses.add("Your description is a bit \n" +
                "wishy-washy. Have you got an expert \n" +
                "there with you who could describe \n" +
                "this more precisely?");
        responses.add("That’s not a bug, it’s a feature!");
        responses.add("Could you elaborate on that?");
        responses.add("I'm not sure I understand. Could you clarify?");
        responses.add("Have you checked if your system meets the requirements?");
        responses.add("Let's troubleshoot this step by step.");
        responses.add("Can you provide a screenshot of the issue?");
        responses.add("That shouldn't be happening. Let's investigate.");
        responses.add("It sounds like you're having a tough time. Let's sort it out.");
        responses.add("Have you tried rebooting your device?");
        responses.add("It's always good to have backups. Have you backed up your data?");
        responses.add("How long has this issue been occurring?");
        responses.add("Can you tell me what actions led to this problem?");
        responses.add("Let's try to isolate the issue. When did it start happening?");
        responses.add("Your input is valuable. I’ll pass it to our development team.");
    }
}
