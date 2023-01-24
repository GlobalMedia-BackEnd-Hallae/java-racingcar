package gmbs.model;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();
    private int headPositionValue;

    public RacingCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void updateStatus(NumberGenerator generator) {
        for (Car car : cars) {
            int num = generator.generate();
            car.moveByCondition(num);
        }
    }

    private List<Car> getHeadPositionCars() {
        int maxPosition = cars.stream().max(Comparator.comparingInt(Car::carPosition)).get().carPosition();
        return cars.stream().filter(car -> car.carPosition() == maxPosition).collect(Collectors.toList());
    }

    public List<String> getHeadPositionNames() {
        List<String> names = new ArrayList<>();
        for (Car car : getHeadPositionCars()) {
            names.add(car.carName());
        }
        return names;
    }

    public Map<String, Integer> getCurrentCarsStatus() {
        LinkedHashMap<String, Integer> currentStatus = new LinkedHashMap<>();
        for (Car car : cars) {
            currentStatus.put(car.carName(), car.carPosition());
        }
        return currentStatus;
    }
}
