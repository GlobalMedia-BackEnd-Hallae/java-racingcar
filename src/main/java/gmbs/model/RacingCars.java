package gmbs.model;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {

    private static final int GENERATE_NUMBER_RANGE_START = 0;
    private static final int GENERATE_NUMBER_RANGE_END = 9;
    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<CarName> carNames) {
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void updateStatus(NumberGenerator generator) {
        for (Car car : cars) {
            int num = generator.generate(GENERATE_NUMBER_RANGE_START, GENERATE_NUMBER_RANGE_END);
            car.moveByCondition(num);
        }
    }

    private List<Car> getHeadPositionCars() {
        int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::carPosition))
                .get()
                .carPosition();
        return cars.stream()
                .filter(car -> car.carPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<String> getHeadPositionNames() {
        List<String> names = new ArrayList<>();
        for (Car car : getHeadPositionCars()) {
            names.add(car.carName());
        }
        return names;
    }

    public Map<String, Integer> getCurrentCarsStatus() {
        Map<String, Integer> currentStatus = new LinkedHashMap<>();
        for (Car car : cars) {
            currentStatus.put(car.carName(), car.carPosition());
        }
        return currentStatus;
    }
}
