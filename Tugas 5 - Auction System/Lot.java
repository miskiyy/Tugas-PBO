public class Lot {
    private int number;
    private String description;
    private Bid highestBid;

    public Lot(int number, String description) {
        this.number = number;
        this.description = description;
        this.highestBid = null; // No bids yet
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public boolean bidFor(Bid bid) {
        if (highestBid == null) {
            // There is no previous bid.
            highestBid = bid;
            return true;
        } else if (bid.getValue() > highestBid.getValue()) {
            // The bid is better than the previous one.
            highestBid = bid;
            return true;
        } else {
            // The bid is not better.
            return false;
        }
    }

    public String toString() {
        if (highestBid != null) {
            return "Lot " + number + ": " + description + " (Highest bid: " + highestBid.getValue() + " by " + highestBid.getBidder().getName() + ")";
        } else {
            return "Lot " + number + ": " + description + " (No bids yet)";
        }
    }
}
