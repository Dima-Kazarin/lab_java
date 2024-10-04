import java.util.ArrayList;
import java.util.List;

abstract class Aircraft {
    protected String model;

    public Aircraft(String model) {
        this.model = model;
    }

    public abstract void fly();
}


class Airplane extends Aircraft {

    public Airplane(String model) {
        super(model);
    }

    public void fly() {
        System.out.println("Літак " + model + " летить.");
    }
}


class Helicopter extends Aircraft {

    public Helicopter(String model) {
        super(model);
    }

    public void fly() {
        System.out.println("Вертоліт " + model + " летить.");
    }
}


class Airline {
    private List<Aircraft> fleet = new ArrayList<>();


    public void addAircraft(Aircraft aircraft) {
        fleet.add(aircraft);
    }


    public int countAirplanes() {
        int count = 0;
        for (Aircraft aircraft : fleet) {
            if (aircraft instanceof Airplane)
                count++;
        }
        return count;
    }


    public int countHelicopters() {
        int count = 0;
        for (Aircraft aircraft : fleet) {
            if (aircraft instanceof Helicopter)
                count++;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {

        Airline airline = new Airline();


        airline.addAircraft(new Airplane("Airplane 1"));
        airline.addAircraft(new Airplane("Airplane 2"));
        airline.addAircraft(new Airplane("Airplane 3"));
        airline.addAircraft(new Helicopter("Helicopter 1"));
        airline.addAircraft(new Helicopter("Helicopter 2"));


        System.out.println("Кількість літаків: " + airline.countAirplanes());
        System.out.println("Кількість вертольотів: " + airline.countHelicopters());
    }
}
