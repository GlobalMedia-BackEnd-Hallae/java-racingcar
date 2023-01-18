package gmbs.model;

public class Car {

    private static final int DO_NOTHING_THRESHOLD = 4;
    private static final int TRAVEL_DISTANCE_UNIT = 1;
    private final CarName carName;
    private int position = 0;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public void moveByCondition(int givenNumber) {
        if (givenNumber > DO_NOTHING_THRESHOLD) {
            position += TRAVEL_DISTANCE_UNIT;
        }
    }

    public String carName() {
        return this.carName.name();
    }

    public int carPosition() {
        return this.position;
    }
}
