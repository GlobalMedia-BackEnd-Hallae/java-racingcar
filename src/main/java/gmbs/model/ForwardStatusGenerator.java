package gmbs.model;

import java.util.Random;

public class ForwardStatusGenerator {
    Random randomCarStatus = new Random();

    public int randomCarStatus(int rangeStart, int rangeEnd) {
        if(rangeStart<0 || rangeEnd<0 || rangeStart>rangeEnd) {
            throw new IllegalArgumentException();
        }
        return randomCarStatus.nextInt(rangeEnd-rangeStart+1)+rangeStart;
    }

    public boolean isMoveForward(int rangeStart, int rangeEnd, int referenceCondition) {
        if (referenceCondition<rangeStart || referenceCondition > rangeEnd) {
            throw new IllegalArgumentException();
        }
        return randomCarStatus(rangeStart,rangeEnd)<=referenceCondition;
    }
}
