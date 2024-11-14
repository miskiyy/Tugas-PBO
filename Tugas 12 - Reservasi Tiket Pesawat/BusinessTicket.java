public class BusinessTicket extends Ticket {
    public BusinessTicket(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        double additionalCharge = 0.25; // Tambahan biaya 25%
        return baseFare * (1 + additionalCharge);
    }

    @Override
    public String getDetails() {
        String facilities = "Spacious seating, 30kg baggage limit, Priority boarding.";
        System.out.printf("%-15s %-15s %-10.2f %-15.2f %-50s%n", 
                        passengerName, 
                        "Business", 
                        baseFare, 
                        calculateFare(), 
                        facilities);
        return null;
    }
}
