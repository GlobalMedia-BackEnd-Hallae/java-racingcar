package Model;

import java.util.ArrayList;
import java.util.List;

public class CarCheck {

    private static final int CAR_NAME_LIMIT = 5;
    private static final String CAR_NAME_SPLIT = ",";

    private List<String> carList = new ArrayList<>();

    private void saveCarName(String car) {
        String[] splitCar = car.split(CAR_NAME_SPLIT);
        carList.addAll(List.of(splitCar));
    }

    private int checkCarNameLength() {
        int maxCarLength = 0;

        for (int index = 0; index < carList.size(); index++) {
            maxCarLength = Math.max(carList.get(index).length(), maxCarLength);
        }

        return maxCarLength;
    }

    public List<String> carCheck(String car) {
        carList.clear();
        saveCarName(car);
        int maxCarLength = checkCarNameLength();

        if (maxCarLength > CAR_NAME_LIMIT)
            throw new IllegalStateException();

        return carList;
    }
}
