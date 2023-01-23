package gmbs.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public static int generateNumber(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        if (min == max) {
            return min;
        }
        return min + ThreadLocalRandom.current().nextInt(max - min);
    }
}
