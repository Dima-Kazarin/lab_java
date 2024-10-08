public class Car implements Transport {
    private String registrationNumber;
    private String brand;
    private String model;
    private String vin;
    private String owner;
    private String fuelType;
    private int engineVolume;

    public String getInfo() {
        return "Car [Registration Number: " + registrationNumber + ", Brand: " + brand +
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
        System.out.println("Refueling the car...");
    }

    public void repair() {
        System.out.println("Repairing the car...");
    }

    public void service() {
        System.out.println("Servicing the car...");
    }

    public void passInspection() {
        System.out.println("Car passed inspection.");
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }
}
