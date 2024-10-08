public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Scooter scooter = new Scooter();
        Motorcycle motorcycle = new Motorcycle();
        ATV atv = new ATV();

        car.setInfo("number1", "Brand1", "Model1", "vin1", "owner1", "Diesel");
        System.out.println(car.getInfo());
        car.refuel();
        car.repair();
        car.service();
        car.passInspection();
        car.setEngineVolume(200);

        System.out.println();

        bicycle.setInfo("number2", "Brand2", "Model2", "1213", "owner2", null);
        System.out.println(bicycle.getInfo());
        bicycle.refuel();
        bicycle.repair();
        bicycle.service();
        bicycle.passInspection();
        bicycle.setGearCount(4);

        System.out.println();

        scooter.setInfo("number3", "Brand3", "Model3", "121", "owner3", "Electricity");
        System.out.println(scooter.getInfo());
        scooter.refuel();
        scooter.repair();
        scooter.service();
        scooter.passInspection();
        scooter.setMaxSpeed(20);

        System.out.println();

        motorcycle.setInfo("mc123", "Brand4", "Model4", "vin123", "owner3", "Gasoline");
        System.out.println(motorcycle.getInfo());
        motorcycle.refuel();
        motorcycle.repair();
        motorcycle.service();
        motorcycle.passInspection();
        motorcycle.setHasSideCar(true);

        System.out.println();

        atv.setInfo("ATV123", "Brand5", "Model5", "213", "owner3", "Gasoline");
        System.out.println(atv.getInfo());
        atv.refuel();
        atv.repair();
        atv.service();
        atv.passInspection();
        atv.setPassengerCapacity(3);
    }
}
