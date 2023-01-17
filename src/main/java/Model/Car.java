package model;

public class Car {

    private final CarName carName;
    private final Position position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public void move(boolean advance) {
        position.move(advance);
    }

    public String carName() {
        return carName.getCarName();
    }

    public int carPosition() {
        return position.getPosition();
    }
}
