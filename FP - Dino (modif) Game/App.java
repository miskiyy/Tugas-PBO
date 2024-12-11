import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 750;
        int boardHeight = 250;

        // Pilihan pemain
        String[] options = {"Player 1", "Player 2", "Player 3"};
        
        int choice = JOptionPane.showOptionDialog(
            null,
            "Pilih pemain Anda:",
            "Pilih Pemain",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
        );

        if (choice == -1) {
            System.exit(0); // Tutup program jika tidak ada pilihan
        }

        // Luncurkan game dengan pilihan pemain
        JFrame frame = new JFrame("Chrome Dinosaur");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ChromeDinosaur chromeDinosaur = new ChromeDinosaur(choice);
        frame.add(chromeDinosaur);
        frame.pack();
        chromeDinosaur.requestFocus();
        frame.setVisible(true);
    }
}
