import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");

        String inputLine = reader.nextLine();
        String[] words = inputLine.trim().split(" ", 2);

        String word1 = words.length > 0 ? words[0] : null;
        String word2 = words.length > 1 ? words[1] : null;

        // Mengambil CommandWord dari CommandWords berdasarkan input
        CommandWords.CommandWord commandWord = commands.getCommandWord(word1);
        return new Command(commandWord, word2);
    }

    public void close() {
        reader.close();
    }
}
