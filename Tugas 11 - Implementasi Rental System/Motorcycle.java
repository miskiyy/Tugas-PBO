public class Motorcycle extends Vehicle {
    private String type;
    
    public Motorcycle(String brand, String model, int year, String type) {
        super(brand, model, year);
        this.type = type;
    }

    @Override
    public String getInfo() {
        return "Motorcycle [ID: " + getId() + ", Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Type: " + type + "]";
    }

    public double calculateRentalCost(int days) {
        return days * 15; 
    }
}
