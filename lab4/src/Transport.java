public interface Transport {
    String getInfo();
    void setInfo(String registrationNumber, String brand, String model, String vin, String owner, String fuelType);
    void refuel();
    void repair();
    void service();
    void passInspection();
}

