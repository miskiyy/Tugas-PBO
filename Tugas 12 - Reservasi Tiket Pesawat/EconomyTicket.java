public class EconomyTicket extends Ticket {
    public EconomyTicket(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        double discount = 0.10; // 10% diskon
        return baseFare * (1 - discount);
    }

    @Override
    public String getDetails() {
        String facilities = "Standard seating, 15kg baggage limit.";
        System.out.printf("%-15s %-15s %-10.2f %-15.2f %-50s%n", 
                        passengerName, 
                        "Economy", 
                        baseFare, 
                        calculateFare(), 
                        facilities);
        return null;
    }
}
