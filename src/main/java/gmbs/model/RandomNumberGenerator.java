package gmbs.model;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final int rangeStart;
    private final int rangeEnd;

    private final Random random = new Random();

    public RandomNumberGenerator(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public int generate() {
        return random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
    }
}
