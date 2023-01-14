package Model;

import java.util.ArrayList;
import java.util.List;

public class CreateWinnerList {

    private List<String> winnerList = new ArrayList<>();

    private int maxDistance(List<Car> carClassList) {
        int maxValue = 0;

        for (int index = 0; index < carClassList.size(); index++) {
            maxValue = Math.max(carClassList.get(index).carPosition(), maxValue);
        }

        return maxValue;
    }

    private void storeWinnerList(int maxDistance, int carDistance, String carName) {
        if (maxDistance == carDistance) {
            winnerList.add(carName);
        }
    }

    public List<String> createWinnerList(List<Car> carClassList) {
        int maxDistance = maxDistance(carClassList);

        for (int index = 0; index < carClassList.size(); index++) {
            storeWinnerList(maxDistance, carClassList.get(index).carPosition(), carClassList.get(index).carName());
        }

        return winnerList;
    }
}
