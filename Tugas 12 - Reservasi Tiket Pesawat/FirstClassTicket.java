public class FirstClassTicket extends Ticket {
    public FirstClassTicket(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        double additionalCharge = 0.50; // Tambahan biaya 50%
        return baseFare * (1 + additionalCharge);
    }

    @Override
    public String getDetails() {
        String facilities = "Luxury seating, 40kg baggage limit, In-flight lounge access.";
        System.out.printf("%-15s %-15s %-10.2f %-15.2f %-50s%n", 
                        passengerName, 
                        "First Class", 
                        baseFare, 
                        calculateFare(), 
                        facilities);
        return null;
    }
}
