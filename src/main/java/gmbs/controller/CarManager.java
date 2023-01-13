package gmbs.controller;

import gmbs.model.Car;
import gmbs.model.CarPositionGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarManager {
    private static final CarPositionGenerator positionGenerator = new CarPositionGenerator();

    public List<Car> createCar(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> updateStatus(List<Car> currentStatus) {
        List<Car> updateStatus = new ArrayList<>();
        for (Car car : currentStatus) {
            updateStatus.add(positionGenerator.updatePosition(car));
        }
        return updateStatus;
    }

    public Map<String, Integer> currentStatus(List<Car> cars) {
        HashMap<String, Integer> currentStatus = new HashMap<>();
        for (Car car : cars) {
            currentStatus.put(car.carName(), car.carPosition());
        }
        return currentStatus;
    }
}
