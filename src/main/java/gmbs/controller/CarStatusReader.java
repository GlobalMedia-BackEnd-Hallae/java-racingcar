package gmbs.controller;

import gmbs.model.Car;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarStatusReader {
    private List<String> checkNameByPosition(Car car, int position) {
        List<String> carNames = new ArrayList<>();
        if (car.carPosition() == position) {
            carNames.add(car.carName());
        }
        return carNames;
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

    public List<String> readHeadPositionNames(List<Car> cars) {
        List<String> carNames = new ArrayList<>();
        int maxPosition = maxPosition(cars);
        for (Car car : cars) {
            carNames.addAll(checkNameByPosition(car, maxPosition));
        }
        return carNames;
    }
}
