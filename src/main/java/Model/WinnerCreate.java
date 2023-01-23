package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinnerCreate {

    private static final String EXPRESSION_DELIMITER = "";

    public List<String> createWinner(List<Car> carStatus) {
        List<String> winner = new ArrayList<>();

        int maxDistance = maxDistance(carStatus);

        for (Car car : carStatus) {
            winner.add(isWinner(maxDistance, car.carPosition(), car.carName()));
        }

        winner.removeAll(Arrays.asList(EXPRESSION_DELIMITER));

        return winner;
    }

    private int maxDistance(List<Car> carStatus) {
        final int INITIAL_VALUE = 0;

        int maxValue = INITIAL_VALUE;

        for (Car car : carStatus) {
            maxValue = Math.max(car.carPosition(), maxValue);
        }

        return maxValue;
    }

    private String isWinner(int maxDistance, int carDistance, String carName) {
        if (maxDistance == carDistance) {
            return carName;
        }

        return EXPRESSION_DELIMITER;
    }
}
