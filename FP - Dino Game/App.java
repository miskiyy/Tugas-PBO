import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Dimensi dari board
        int boardWidth = 750;
        int boardHeight = 250;

        // Pilihan pemain yang akan ditampilkan di dialog box
        String[] options = {"Player 1", "Player 2", "Player 3"};
        
        // Menampilkan dialog untuk memilih pemain
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

        // Jika tidak memilih apapun, keluar aplikasi
        if (choice == -1) {
            System.exit(0); 
        }

        // Membuat frame untuk permainan
        JFrame frame = new JFrame("Chrome Dinosaur");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat objek permainan dengan pemain yang dipilih
        ChromeDinosaur chromeDinosaur = new ChromeDinosaur(choice);
        frame.add(chromeDinosaur);

        frame.pack();
        chromeDinosaur.requestFocus();
        frame.setVisible(true);
        
        ImageIcon backgroundIcon = new ImageIcon(App.class.getResource("./img/bg3.jpg"));
        chromeDinosaur.setBackgroundImage(backgroundIcon.getImage());
    }
}
