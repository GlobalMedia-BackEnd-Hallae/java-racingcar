package gmbs.controller;

import gmbs.model.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarStatusReader {
    private Map<String, Integer> readStatusByPosition(Car car, int position) {
        HashMap<String, Integer> cars = new HashMap<>();
        if (car.carPosition() == position) {
            cars.put(car.carName(), car.carPosition());
        }
        return cars;
    }

    private int maxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.carPosition());
        }
        return maxPosition;
    }

    public Map<String, Integer> readCurrentStatus(List<Car> cars) {
        HashMap<String, Integer> currentStatus = new HashMap<>();
        for (Car car : cars) {
            currentStatus.put(car.carName(), car.carPosition());
        }
        return currentStatus;
    }

    public Map<String, Integer> readHeadPosition(List<Car> cars) {
        HashMap<String, Integer> headPosition = new HashMap<>();
        int maxPosition = maxPosition(cars);
        for (Car car : cars) {
            headPosition.putAll(readStatusByPosition(car, maxPosition));
        }
        return headPosition;
    }
}
