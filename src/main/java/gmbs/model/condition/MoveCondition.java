package gmbs.model.condition;

import java.util.Random;

public class MoveCondition implements Condition {

    private static final int STANDARD_NUMBER = 4;
    private static final int END_BOUND = 9;

    private final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(END_BOUND) >= STANDARD_NUMBER;
    }
}
