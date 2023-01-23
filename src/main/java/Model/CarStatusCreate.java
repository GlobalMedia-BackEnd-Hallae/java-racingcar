package model;

import java.util.ArrayList;
import java.util.List;

public class CarStatusCreate {

    public List<Car> createCarStatus(List<String> carName) {
        List<Car> carStatus = new ArrayList<>();

        for (int index = 0; index < carName.size(); index++) {
            carStatus.add(new Car(carName.get(index)));
        }

        return carStatus;
    }
}
