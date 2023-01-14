package gmbs.controller;

import gmbs.model.Car;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarStatusReader {
    private Map<String, Integer> readStatusByPosition(Car car, int position) {
        LinkedHashMap<String, Integer> cars = new LinkedHashMap<>();
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
        LinkedHashMap<String, Integer> currentStatus = new LinkedHashMap<>();
        for (Car car : cars) {
            currentStatus.put(car.carName(), car.carPosition());
        }
        return currentStatus;
    }

    public Map<String, Integer> readHeadPosition(List<Car> cars) {
        LinkedHashMap<String, Integer> headPosition = new LinkedHashMap<>();
        int maxPosition = maxPosition(cars);
        for (Car car : cars) {
            headPosition.putAll(readStatusByPosition(car, maxPosition));
        }
        return headPosition;
    }
}
