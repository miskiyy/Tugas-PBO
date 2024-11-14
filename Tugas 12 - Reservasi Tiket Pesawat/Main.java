import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ticket> tickets = new ArrayList<>();

        tickets.add(new EconomyTicket("Miski", 1000));
        tickets.add(new EconomyTicket("Faiz", 1500));
        tickets.add(new BusinessTicket("Vius", 1200));
        tickets.add(new FirstClassTicket("Windut", 1500));

        System.out.printf("%-15s %-15s %-10s %-15s %-50s%n", 
                          "Passenger Name", "Ticket Type", "Base Fare", "Final Fare", "Facilities");
        System.out.println("=".repeat(100));

        for (Ticket ticket : tickets) {
            ticket.getDetails();
        }
    }
}
