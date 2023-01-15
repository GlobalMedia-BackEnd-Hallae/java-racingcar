package gmbs.model;

public class Car {
    private static final int MOVING_DISTANCE = 1;
    private static final int FORWARD_NUMBER = 4;

    private final Name name;
    private final Position position;

    public Car(String nameString) {
        this.name = new Name(nameString);
        this.position = new Position();
    }

    public void move(int random) {
        if (random >= FORWARD_NUMBER) {
            position.move(MOVING_DISTANCE);
        }
    }

    public String getName() {
        return this.name.toString();
    }

    public int getPosition() {
        return this.position.toInt();
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }
}
