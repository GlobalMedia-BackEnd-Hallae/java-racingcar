package gmbs.model;

import java.util.Random;

public class RandomNumberGenerator {

    private final int RangeStart;
    private final int RangeEnd;

    private final Random random = new Random();

    public RandomNumberGenerator(int rangeStart, int rangeEnd) {
        RangeStart = rangeStart;
        RangeEnd = rangeEnd;
    }

    public int generate() {
        return random.nextInt(RangeEnd - RangeStart + 1) + RangeStart;
    }
}
