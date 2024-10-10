import java.util.Scanner;

public class InputReader {
    private Scanner reader;

    public InputReader() {
        reader = new Scanner(System.in);
    }

    public String getInput() {
        System.out.print("> "); // print prompt
        return reader.nextLine().toLowerCase();
    }
}
