public abstract class Vehicle {
    protected int id;
    protected String brand;
    protected String model;
    protected int year;
    protected String renter;
    protected boolean availability;

    // Constructor for Vehicle class
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.renter = "";
        this.availability = true;
    }

    // Abstract method to display vehicle info (to be implemented by subclasses)
    public abstract String getInfo();

    // Method to rent the vehicle
    public void rent(String renter) {
        this.availability = false;
        this.renter = renter;
    }

    // Method to return the vehicle
    public void returned() {
        this.availability = true;
        this.renter = "";  // Remove the renter's name when vehicle is returned
    }

    // Method to check availability of the vehicle
    public boolean isAvailable() {
        return this.availability;
    }

    // Method to get the ID (for reference in Rental system)
    public int getId() {
        return id;
    }

    // Set ID for the vehicle
    public void setId(int id) {
        this.id = id;
    }
}
