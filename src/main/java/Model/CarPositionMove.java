package model;

import java.util.List;
import java.util.Random;

public class CarPositionMove {

    private Random random = new Random();

    public void move(List<Car> carStatus) {
        for (Car car : carStatus) {
            car.move(ableToAdvance());
        }
    }

    private boolean ableToAdvance() {
        final int NUMBER_RANGE = 10;
        final int ADVANCE_LIMIT = 4;

        return random.nextInt(NUMBER_RANGE) >= ADVANCE_LIMIT;
    }
}
