package model;

import java.util.List;

public class CarNameSplit {

    public List<String> splitCarName(String carNames) {
        final String CAR_NAME_SPLIT = ",";

        return List.of(carNames.split(CAR_NAME_SPLIT));
    }
}
