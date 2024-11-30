public class Car extends Vehicle {
    private String type; 

    public Car(String brand, String model, int year, String type) {
        super(brand, model, year); 
        this.type = type;
    }

    @Override
    public String getInfo() {
        return "Car [ID: " + getId() + ", Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Type: " + type + "]";
    }

    public double calculateRentalCost(int days) {
        return days * 20; 
    }
}
