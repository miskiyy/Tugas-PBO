public class Bike extends Vehicle {
    private String bikeType; 

    public Bike(String brand, String model, int year, String bikeType) {
        super(brand, model, year);
        this.bikeType = bikeType;
    }

    @Override
    public String getInfo() {
        return "Bike [ID: " + getId() + ", Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Type: " + bikeType + "]";
    }

    public double calculateRentalCost(int days) {
        return days * 5;
    }
}
