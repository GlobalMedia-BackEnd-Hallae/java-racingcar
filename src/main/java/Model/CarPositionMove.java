package model;

import java.util.List;
import java.util.Random;

public class CarPositionMove {

    private static final int NUMBER_RANGE = 10;
    private static final int ADVANCE_LIMIT = 4;

    private Random random = new Random();

    private boolean ableToAdvance() {
        return random.nextInt(NUMBER_RANGE) >= ADVANCE_LIMIT;
    }

    public void move(List<Car> carClassList) {
        for (int index = 0; index < carClassList.size(); index++) {
            carClassList.get(index).move(ableToAdvance());
        }
    }
}
