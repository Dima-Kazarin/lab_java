public class Scooter implements Transport {
    private String registrationNumber;
    private String brand;
    private String model;
    private String vin;
    private String owner;
    private String fuelType;
    private int maxSpeed;

    public String getInfo() {
        return "Scooter [Registration Number: " + registrationNumber + ", Brand: " + brand +
                ", Model: " + model + ", VIN: " + vin + ", Owner: " + owner + ", Fuel Type: " + fuelType + "]";
    }

    public void setInfo(String registrationNumber, String brand, String model, String vin, String owner, String fuelType) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.vin = vin;
        this.owner = owner;
        this.fuelType = fuelType;
    }

    public void refuel() {
        System.out.println("Refueling the scooter...");
    }

    public void repair() {
        System.out.println("Repairing the scooter...");
    }

    public void service() {
        System.out.println("Servicing the scooter...");
    }

    public void passInspection() {
        System.out.println("Scooter passed inspection.");
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

