package gmbs.model;

public class Car {
    private static final int MOVING_DISTANCE = 1;
    private static final int FORWARD_NUMBER = 4;

    private final String name;
    private final Position position;

    public Car(final String name) {
        this.name = name;
        this.position = new Position();
    }

    public void move(int random) {
        if (random >= FORWARD_NUMBER) {
            position.move(MOVING_DISTANCE);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position.value();
    }
}
