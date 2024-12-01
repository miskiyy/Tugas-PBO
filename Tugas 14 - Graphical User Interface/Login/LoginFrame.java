import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";

    public LoginFrame() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(102, 0, 153)); // Warna ungu

        // Panel untuk form
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBackground(new Color(102, 0, 153));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE); // Warna teks
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(102, 0, 153));

        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(153, 102, 204)); // Warna ungu terang
        loginButton.setForeground(Color.WHITE);
        buttonPanel.add(loginButton);

        // Tambahkan panel ke mainPanel
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Tambahkan mainPanel ke frame
        add(mainPanel);

        // Menambahkan aksi pada tombol login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                if (username.equals(VALID_USERNAME) && new String(password).equals(VALID_PASSWORD)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
