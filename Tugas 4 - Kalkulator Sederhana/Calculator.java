import javax.swing.*;

public class Calculator {

    public static void main(String[] args) {
        while (true) {
            // Tampilkan dialog untuk memilih operasi
            String[] options = {"Addition (+)", "Subtraction (-)", "Multiplication (*)", "Division (/)", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an operation:", "Simple Calculator",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 4) {
                break;  // Jika memilih "Exit", keluar dari program
            }

            // Meminta input dari pengguna
            double num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the first number:"));
            double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the second number:"));

            double result = 0;

            // Menggunakan class per operasi untuk menghitung hasil
            switch (choice) {
                case 0:  // Addition
                    Add addition = new Add();
                    result = addition.calculate(num1, num2);
                    break;
                case 1:  // Subtraction
                    Subtract subtraction = new Subtract();
                    result = subtraction.calculate(num1, num2);
                    break;
                case 2:  // Multiplication
                    Multiply multiplication = new Multiply();
                    result = multiplication.calculate(num1, num2);
                    break;
                case 3:  // Division
                    Divide division = new Divide();
                    result = division.calculate(num1, num2);
                    break;
            }

            // Tampilkan hasil
            JOptionPane.showMessageDialog(null, "Result: " + result);
        }
    }
}
