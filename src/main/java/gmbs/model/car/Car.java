package gmbs.model.car;

import gmbs.model.car.vo.Name;
import gmbs.model.car.vo.Position;

import java.util.List;

public class Car {

    private final Name name;
    private final Position position;

    public Car(final String value) {
        this.name = new Name(value);
        this.position = new Position();
    }

    private Car(final String nameValue, final int positionValue) {
        this.name = new Name(nameValue);
        this.position = Position.fromTest(positionValue);
    }

    public static Car ofTest(final String nameValue, final int positionValue) {
        return new Car(nameValue, positionValue);
    }

    public void moveForward(boolean movable) {
        if (movable) {
            position.increase();
        }
    }

    public boolean isFarthest(List<Car> allCars) {
        return allCars.stream()
                .allMatch(car -> position.isHigherThan(car.position));
    }

    public String getNameValue() {
        return name.getValue();
    }

    public int getPositionValue() {
        return position.getValue();
    }
}
