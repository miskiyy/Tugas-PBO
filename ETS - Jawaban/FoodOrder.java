import java.util.ArrayList;

public class FoodOrder {
    private ArrayList<Menu> menuItems;
    private double totalPrice;
    private boolean isPaid;

    public FoodOrder() {
        menuItems = new ArrayList<>();
        totalPrice = 0.0;
        isPaid = false;
    }

    public void addMenu(Menu menu) {
        menuItems.add(menu);
        totalPrice += menu.getPrice();
        System.out.println(menu.getName() + " berhasil ditambahkan dengan harga Rp" + menu.getPrice());
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void payOrder() {
        if (!isPaid) {
            isPaid = true;
            System.out.println("Pesanan telah dibayar.");
        } else {
            System.out.println("Pesanan sudah dibayar sebelumnya.");
        }
    }

    public void getOrderDetails() {
        System.out.println("Detail Pesanan:");
        for (Menu menu : menuItems) {
            System.out.println("- " + menu.getName() + " (Rp" + menu.getPrice() + ")");
        }
        System.out.println("Total Harga: Rp" + totalPrice);
        System.out.println("Status Pembayaran: " + (isPaid ? "Sudah Dibayar" : "Belum Dibayar"));
    }

    public static void main(String[] args) {
        FoodOrder order = new FoodOrder();

        Menu menu1 = new Menu("Nasi", 5000);
        Menu menu2 = new Menu("Ayam Bakar", 30000);
        Menu menu3 = new Menu("Es Teh", 5000);

        order.addMenu(menu1);
        order.addMenu(menu2);
        order.addMenu(menu3);

        order.getOrderDetails();
        System.out.println();
        order.payOrder();
        System.out.println();
        order.getOrderDetails();
    }
}
