public class Motorcycle implements Transport {
    private String registrationNumber;
    private String brand;
    private String model;
    private String vin;
    private String owner;
    private String fuelType;
    private boolean hasSideCar;

    public String getInfo() {
        return "Motorcycle [Registration Number: " + registrationNumber + ", Brand: " + brand +
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
        System.out.println("Refueling the motorcycle...");
    }

    public void repair() {
        System.out.println("Repairing the motorcycle...");
    }

    public void service() {
        System.out.println("Servicing the motorcycle...");
    }

    public void passInspection() {
        System.out.println("Motorcycle passed inspection.");
    }

    public void setHasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }
}

