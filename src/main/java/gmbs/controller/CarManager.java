package gmbs.controller;

import gmbs.model.Car;
import gmbs.model.CarPositionGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private static final CarPositionGenerator positionGenerator = new CarPositionGenerator();

    public List<Car> createCar(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private List<Car> updateStatus(List<Car> currentStatus) {
        List<Car> updateStatus = new ArrayList<>();
        for (Car car : currentStatus) {
            updateStatus.add(positionGenerator.updatePosition(car));
        }
        return updateStatus;
    }

    public List<Car> repeatUpdateStatus(List<Car> currentStatus, int repeatCount) {
        List<Car> repeatUpdateStatus = new ArrayList<>();
        for (int i = 0; i < repeatCount; i++) {
            repeatUpdateStatus = updateStatus(currentStatus);
        }
        return repeatUpdateStatus;
    }

}
