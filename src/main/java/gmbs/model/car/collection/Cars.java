package gmbs.model.car.collection;

import gmbs.model.car.Car;
import gmbs.model.condition.Condition;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> values;

    public Cars(final String[] carNames) {
        values = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public void race(Condition condition) {
        values.forEach(car -> car.moveForward(condition.isMovable()));
    }

    public List<String> getWinnerCarName() {
        return values.stream()
                .filter(car -> car.isFarthest(values))
                .map(Car::getNameValue)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return values;
    }
}
