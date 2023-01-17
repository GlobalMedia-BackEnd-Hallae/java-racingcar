package model;

import java.util.ArrayList;
import java.util.List;

public class WinnerCreate {

    List<String> winner = new ArrayList<>();

    private int maxDistance(List<Car> carStatus) {
        int maxValue = 0;

        for (Car car : carStatus) {
            maxValue = Math.max(car.carPosition(), maxValue);
        }

        return maxValue;
    }

    private void isWinner(int maxDistance, int carDistance, String carName) {
        if (maxDistance == carDistance) {
            winner.add(carName);
        }
    }

    public List<String> createWinner(List<Car> carStatus) {
        int maxDistance = maxDistance(carStatus);

        for (Car car : carStatus) {
            isWinner(maxDistance, car.carPosition(), car.carName());
        }

        return winner;
    }
}
