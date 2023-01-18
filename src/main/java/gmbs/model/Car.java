package gmbs.model;

public class Car {
    private static final int DO_NOTHING_THRESHOLD = 4;
    private static final int TRAVEL_DISTANCE_UNIT = 1;

    private final CarName carName;
    private int position = 0;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    private Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = position;
    }

    public Car moveByCondition(int givenNumber) {
        if (givenNumber > DO_NOTHING_THRESHOLD) {
            return new Car(this.carName.name(), this.position + TRAVEL_DISTANCE_UNIT);
        }
        return this;
    }

    public String carName() {
        return this.carName.name();
    }

    public int carPosition() {
        return this.position;
    }
}
