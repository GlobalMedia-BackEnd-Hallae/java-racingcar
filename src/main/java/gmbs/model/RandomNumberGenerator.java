package gmbs.model;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int generate(int rangeStart, int rangeEnd) {
        return random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
    }
}
