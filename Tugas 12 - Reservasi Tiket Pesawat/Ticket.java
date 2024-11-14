public class Ticket {
    protected double baseFare;
    protected String passengerName;

    public Ticket(String passengerName, double baseFare) {
        this.passengerName = passengerName;
        this.baseFare = baseFare;
    }

    public double calculateFare() {
        return baseFare; 
    }

    public String getDetails() {
        return "Passenger: " + passengerName + ", Base Fare: " + baseFare;
    }
}
