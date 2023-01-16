package gmbs.model.car.collection;

import gmbs.model.car.Car;
import gmbs.model.condition.Condition;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final String[] carNames) {
        cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public void race(Condition condition) {
        cars.forEach(car -> car.moveForward(condition.isMovable()));
    }

    public List<String> getWinnerCarName() {
        return cars.stream()
                .filter(car -> car.isFarthest(cars))
                .map(Car::getNameValue)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
