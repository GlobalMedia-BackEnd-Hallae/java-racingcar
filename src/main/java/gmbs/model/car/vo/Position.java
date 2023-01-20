package gmbs.model.car.vo;

import java.util.Objects;

public class Position {

    private static final int DEFAULT_POSITION = 0;

    private int value;

    public Position() {
        value = DEFAULT_POSITION;
    }

    private Position(final int position) {
        value = position;
    }

    public static Position fromTest(final int position) {
        return new Position(position);
    }

    public void increase() {
        value++;
    }

    public boolean isHigherThan(Position anotherCarPosition) {
        return value >= anotherCarPosition.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
