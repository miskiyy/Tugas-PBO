import java.util.ArrayList;

public class Rental {
    private ArrayList<Vehicle> vehicleList;
    private ArrayList<Renter> renterList;

    // Constructor for Rental system
    public Rental() {
        vehicleList = new ArrayList<>();
        renterList = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicle.setId(vehicleList.size() + 1);  // Automatically assign an ID
        vehicleList.add(vehicle);
    }

    public Vehicle getVehicle(int id) {
        if (id >= 0 && id < vehicleList.size()) {
            return vehicleList.get(id);
        }
        return null;
    }

    public void addRenter(Renter renter) {
        renterList.add(renter);
    }

    public boolean returnVehicle(String renterName) {
        for (Renter renter : renterList) {
            if (renter.getName().equals(renterName)) {
                Vehicle rentedVehicle = renter.getRentedVehicle();
                rentedVehicle.returned();
                renterList.remove(renter);
                return true;
            }
        }
        return false;  // If no renter found
    }

    public void showVehicle() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.isAvailable()) {
                System.out.println(vehicle.getInfo());
            }
        }
    }

    public void showRenter() {
        if (renterList.isEmpty()) {
            System.out.println("No renters available.");
        } else {
            for (Renter renter : renterList) {
                System.out.println(renter);
            }
        }
    }
}
