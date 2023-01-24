package gmbs.model;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int TRAVEL_DISTANCE_UNIT = 1;
    private final CarName carName;
    private int position = 0;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void moveByCondition(int givenNumber) {
        if (givenNumber >= MOVE_THRESHOLD) {
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
