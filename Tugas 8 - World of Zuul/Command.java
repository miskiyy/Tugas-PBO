public class Command {
    private CommandWords.CommandWord commandWord;
    private String secondWord;

    public Command(CommandWords.CommandWord commandWord, String secondWord) {
        this.commandWord = commandWord != null ? commandWord : CommandWords.CommandWord.UNKNOWN;
        this.secondWord = secondWord;
    }

    public CommandWords.CommandWord getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public boolean isUnknown() {
        return commandWord == CommandWords.CommandWord.UNKNOWN;
    }

    public boolean hasSecondWord() {
        return secondWord != null;
    }
}
