import java.util.HashMap;

public class CommandWords {
    private HashMap<String, CommandWord> validCommands;

    public CommandWords() {
        validCommands = new HashMap<>();
        for (CommandWord command : CommandWord.values()) {
            validCommands.put(command.toString(), command);
        }
    }

    public CommandWord getCommandWord(String commandWord) {
        if (commandWord == null) {
            return CommandWord.UNKNOWN;
        }
        return validCommands.getOrDefault(commandWord.toLowerCase(), CommandWord.UNKNOWN);
    }

    public boolean isCommand(String command) {
        return validCommands.containsKey(command.toLowerCase());
    }

    public String getCommandList() {
        return String.join(", ", validCommands.keySet());
    }

    //avail command
    public enum CommandWord {
        GO, QUIT, HELP, UNKNOWN;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }
}
