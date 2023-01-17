package model;

import java.util.ArrayList;
import java.util.List;

public class CarNameCheck {

    private String[] splitCarName(String car) {
        final String CAR_NAME_SPLIT = ",";
        return car.split(CAR_NAME_SPLIT);
    }

    private List<String> saveCarName(String[] carNames) {
        return List.of(carNames);
    }

    private void checkCarNameLength(String carName) {
        final int CAR_NAME_LIMIT = 5;

        if (carName.length() > CAR_NAME_LIMIT) {
            throw new IllegalStateException();
        }
    }

    public List<String> checkCarName(String car) {
        List<String> carName = new ArrayList<>();
        carName.addAll(saveCarName(splitCarName(car)));

        for (int index = 0; index < carName.size(); index++) {
            checkCarNameLength(carName.get(index));
        }

        return carName;
    }
}
