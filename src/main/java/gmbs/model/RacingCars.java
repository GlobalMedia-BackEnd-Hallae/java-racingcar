package gmbs.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCars {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(0, 9);
    private final List<Car> cars = new ArrayList<>();
    private int headPositionValue;

    public RacingCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private void headPositionUpdate(int position) {
        if (position >= headPositionValue) {
            headPositionValue = position;
        }
    }

    public void updateStatus() {
        for (Car car : cars) {
            car.moveByCondition(randomNumberGenerator.generate());
            headPositionUpdate(car.carPosition());
        }
    }

    private List<Car> getHeadPositionCars() {
        return cars.stream().filter(car -> car.carPosition() == headPositionValue).collect(Collectors.toList());
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
