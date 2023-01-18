package gmbs.model;

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

    public List<Car> updateStatus(List<Car> currentStatus) {
        List<Car> updateStatus = new ArrayList<>();
        for (Car car : currentStatus) {
            updateStatus.add(positionGenerator.updatePosition(car));
        }
        return updateStatus;
    }
}
