package gmbs.model;

public class Position {
    private static final String ROAD = "-";
    private static final int INITIAL_POSITION = 0;

    private int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public void move(int distance) {
        this.position += distance;
    }

    public int value() {
        return this.position;
    }

    @Override
    public String toString() {
        return ROAD.repeat(this.position);
    }
}
