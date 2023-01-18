package gmbs.model;

import java.util.Random;

public class Dice {

    private final int diceRangeStart;
    private final int diceRangeEnd;

    private final Random random = new Random();

    public Dice(int rangeStart, int rangeEnd) {
        diceRangeStart = rangeStart;
        diceRangeEnd = rangeEnd;
    }

    public int roll() {
        return random.nextInt(diceRangeEnd - diceRangeStart + 1) + diceRangeStart;
    }
}
