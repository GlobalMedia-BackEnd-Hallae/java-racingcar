package Model;

import java.util.List;
import java.util.Random;

public class Move {

    private static final int NUMBER_RANGE = 10;

    private Random random = new Random();

    private int makeRandomNumber() {
        return random.nextInt(NUMBER_RANGE);
    }

    private int decideMoveOrNot(int number) {
        if (number >= 4)
            return 1;

        return 0;
    }

    public void move(List<Car> carClassList) {
        for (int index = 0; index < carClassList.size(); index++) {
            int number = makeRandomNumber();
            carClassList.get(index).move(decideMoveOrNot(number));
        }
    }
}
