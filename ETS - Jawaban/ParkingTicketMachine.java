public class ParkingTicketMachine {
    private int balance;
    private int ticketPrice;
    private int ticketTime;

    public ParkingTicketMachine(int ticketPrice) {
        this.ticketPrice = ticketPrice;
        this.balance = 0;
        this.ticketTime = 0;
    }

    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rp" + amount + " berhasil dimasukkan.");
            System.out.println("Saldo : Rp" + balance);
        } else {
            System.out.println("Nominal tidak valid.");
        }
    }

    public void issueTicket() {
        if (balance >= ticketPrice) {
            ticketTime = balance / ticketPrice;
            balance = balance % ticketPrice;
            System.out.println("Tiket berhasil dikeluarkan.");
            System.out.println("Waktu parkir: " + ticketTime + " jam.");
            System.out.println("Sisa saldo: Rp" + balance);
        } else {
            System.out.println("Saldo tidak cukup.");
        }
    }

    public void getTimePurchased() {
        System.out.println("Waktu parkir: " + ticketTime + " jam.");
    }
}
