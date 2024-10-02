public class Bid {
    private Person bidder;
    private long value;

    public Bid(Person bidder, long value) {
        this.bidder = bidder;
        this.value = value;
    }

    public Person getBidder() {
        return bidder;
    }

    public long getValue() {
        return value;
    }

    public String toString() {
        return "Bid by " + bidder.getName() + " for " + value;
    }
}
