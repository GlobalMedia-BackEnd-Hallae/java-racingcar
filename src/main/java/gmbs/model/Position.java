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

    public int toInt() {
        return this.position;
    }

    @Override
    public String toString() {
        return ROAD.repeat(Math.max(0, this.position));
    }
}
