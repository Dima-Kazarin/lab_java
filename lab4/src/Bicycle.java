public class Bicycle implements Transport {
    private String registrationNumber;
    private String brand;
    private String model;
    private String vin;
    private String owner;
    private String fuelType;
    private int gearCount;

    public String getInfo() {
        return "Bicycle [Registration Number: " + registrationNumber + ", Brand: " + brand +
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
        System.out.println("Bicycles do not require refueling.");
    }

    public void repair() {
        System.out.println("Repairing the bicycle...");
    }

    public void service() {
        System.out.println("Servicing the bicycle...");
    }

    public void passInspection() {
        System.out.println("Bicycle passed inspection.");
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }
}

