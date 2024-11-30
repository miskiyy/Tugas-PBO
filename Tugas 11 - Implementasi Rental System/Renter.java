public class Renter {
    private String name;
    private Vehicle rentedVehicle;

    public Renter(String name, Vehicle rentedVehicle) {
        this.name = name;
        this.rentedVehicle = rentedVehicle;
    }

    public String getName() {
        return name;
    }

    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }

    public String toString() {
        return "Renter: " + name + ", Vehicle: " + rentedVehicle.getInfo();
    }
}
