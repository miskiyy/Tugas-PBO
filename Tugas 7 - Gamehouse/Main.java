
/**
 * Write a description of class Main here.
 *
 * @author Frensnya Windah Basudara
 * @version 12/10/2024
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory persewaan = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Sistem Persewaan PS dan DVD Game ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Hapus Item");
            System.out.println("3. Tampilkan Item");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String namaItem = scanner.nextLine();
                    System.out.print("Masukkan jumlah item: ");
                    int jumlahItem = scanner.nextInt();
                    persewaan.tambahItem(namaItem, jumlahItem);
                    break;
                case 2:
                    System.out.print("Masukkan nama item yang ingin dihapus: ");
                    String itemHapus = scanner.nextLine();
                    persewaan.hapusItem(itemHapus);
                    break;
                case 3:
                    persewaan.tampilkanItem();
                    break;
                case 4:
                    System.out.println("Thank you and Good Bye!!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
