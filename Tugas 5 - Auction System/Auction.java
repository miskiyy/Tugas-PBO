import java.util.ArrayList;

public class Auction {
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    
    // The number that will be given to the next lot entered into this auction.
    private int nextLotNumber;

    public Auction() {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    public void showLots() {
        for (Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    public void makeABid(int lotNumber, Person bidder, long value) {
        Lot selectedLot = getLot(lotNumber);
        if (selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if (successful) {
                System.out.println("The bid for lot number " + lotNumber + " was successful.");
            } else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber + " already has a bid of: " + highestBid.getValue());
            }
        }
    }

    public Lot getLot(int lotNumber) {
        if ((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            // The number seems to be reasonable.
            Lot selectedLot = lots.get(lotNumber - 1);
            // Include a confidence check to be sure we have the right lot.
            if (selectedLot.getNumber() != lotNumber) {
                System.out.println("Internal error: Lot number " + selectedLot.getNumber() +
                        " was returned instead of " + lotNumber);
                selectedLot = null;
            }
            return selectedLot;
        } else {
            System.out.println("Lot number: " + lotNumber + " does not exist.");
            return null;
        }
    }
}
